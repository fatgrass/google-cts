/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.theme.cts;

import com.android.ddmlib.Log;
import com.android.ddmlib.Log.LogLevel;
import com.android.tradefed.device.ITestDevice;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.String;
import java.util.concurrent.Callable;

import javax.imageio.ImageIO;

/**
 * Compares the images generated by the device with the reference images.
 */
public class ComparisonTask implements Callable<Boolean> {

    private static final String TAG = ComparisonTask.class.getSimpleName();

    /** Maximum allowed LAB distance between two pixels. */
    private static final double IMAGE_THRESHOLD = 0.76;

    /** Neutral gray for blending colors. */
    private static final int GRAY = 0xFF808080;

    /** Maximum allowable number of consecutive failed pixels. */
    private static final int MAX_CONSECUTIVE_FAILURES = 1;

    private static final String STORAGE_PATH_DEVICE = "/sdcard/cts-holo-assets/%s.png";

    private final ITestDevice mDevice;

    private final File mReference;

    private final String mName;

    public ComparisonTask(ITestDevice device, File reference, String name) {
        mDevice = device;
        mReference = reference;
        mName = name;
    }

    public Boolean call() {
        boolean success = false;
        File generated = null;
        try {
            generated = File.createTempFile("gen_" + mName, ".png");

            final String remoteGenerated = String.format(STORAGE_PATH_DEVICE, mName);
            if (!mDevice.doesFileExist(remoteGenerated)) {
                Log.logAndDisplay(LogLevel.ERROR, TAG, "File " + remoteGenerated + " have not been saved on device");
                return false;
            }
            mDevice.pullFile(remoteGenerated, generated);

            final BufferedImage ref = ImageIO.read(mReference);
            final BufferedImage gen = ImageIO.read(generated);
            if (compare(ref, gen, IMAGE_THRESHOLD)) {
                success = true;
            } else {
                File diff = File.createTempFile("diff_" + mName, ".png");
                createDiff(ref, gen, diff);
                Log.logAndDisplay(LogLevel.INFO, TAG, "Diff created: " + diff.getPath());
            }
        } catch (Exception e) {
            Log.logAndDisplay(LogLevel.ERROR, TAG, String.format(STORAGE_PATH_DEVICE, mName));
            Log.logAndDisplay(LogLevel.ERROR, TAG, e.toString());
            e.printStackTrace();
        } finally {
            if (generated != null) {
                generated.delete();
            }
        }
        return success;
    }

    private static int getAlphaScaledBlue(final int color) {
        return (color & 0x000000FF) * getAlpha(color) / 255;
    }

    private static int getAlphaScaledGreen(final int color) {
        return ((color & 0x0000FF00) >> 8) * getAlpha(color) / 255;
    }

    private static int getAlphaScaledRed(final int color) {
        return ((color & 0x00FF0000) >> 16) * getAlpha(color) / 255;
    }

    private static int getAlpha(final int color) {
        // use logical shift for keeping an unsigned value
        return (color & 0xFF000000) >>> 24;
    }

    private static boolean compare(BufferedImage reference, BufferedImage generated,
            double threshold) {
        final int w = generated.getWidth();
        final int h = generated.getHeight();
        if (w != reference.getWidth() || h != reference.getHeight()) {
            return false;
        }

        double maxDist = 0;
        for (int i = 0; i < w; i++) {
            int consecutive = 0;

            for (int j = 0; j < h; j++) {
                final int p1 = reference.getRGB(i, j);
                final int p2 = generated.getRGB(i, j);
                final double dist = computeLabDistance(p1, p2);
                if (dist > threshold) {
                    System.err.println("fail " + dist);

                    consecutive++;

                    if (consecutive > MAX_CONSECUTIVE_FAILURES) {
                        System.err.println("consecutive fail");
                        return false;
                    }
                } else {
                    consecutive = 0;
                }
            }
        }
        return true;
    }

    /**
     * Returns the perceptual difference score (lower is better) for the
     * provided ARGB pixels.
     */
    private static double computeLabDistance(int p1, int p2) {
        // Blend with neutral gray to account for opacity.
        p1 = ColorUtils.blendSrcOver(p1, GRAY);
        p2 = ColorUtils.blendSrcOver(p2, GRAY);

        // Convert to LAB.
        double[] lab1 = new double[3];
        double[] lab2 = new double[3];
        ColorUtils.colorToLAB(p1, lab1);
        ColorUtils.colorToLAB(p2, lab2);

        // Compute the distance
        double dist = 0;
        for (int i = 0; i < 3; i++) {
            double delta = lab1[i] - lab2[i];
            dist += delta * delta;
        }
        return Math.sqrt(dist);
    }

    private static void createDiff(BufferedImage image1, BufferedImage image2, File out)
            throws Exception {
        final int w1 = image1.getWidth();
        final int h1 = image1.getHeight();
        final int w2 = image2.getWidth();
        final int h2 = image2.getHeight();
        final int width = Math.max(w1, w2);
        final int height = Math.max(h1, h2);
        // The diff will contain image1, image2 and the difference between the two.
        final BufferedImage diff = new BufferedImage(width * 3, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                final boolean inBounds1 = i < w1 && j < h1;
                final boolean inBounds2 = i < w2 && j < h2;
                int color1 = Color.WHITE.getRGB();
                int color2 = Color.WHITE.getRGB();
                int color3;
                if (inBounds1 && inBounds2) {
                    color1 = image1.getRGB(i, j);
                    color2 = image2.getRGB(i, j);
                    color3 = color1 == color2 ? color1 : Color.RED.getRGB();
                } else if (inBounds1 && !inBounds2) {
                    color1 = image1.getRGB(i, j);
                    color3 = Color.BLUE.getRGB();
                } else if (!inBounds1 && inBounds2) {
                    color2 = image2.getRGB(i, j);
                    color3 = Color.GREEN.getRGB();
                } else {
                    color3 = Color.MAGENTA.getRGB();
                }
                int x = i;
                diff.setRGB(x, j, color1);
                x += width;
                diff.setRGB(x, j, color2);
                x += width;
                diff.setRGB(x, j, color3);
            }
        }
        ImageIO.write(diff, "png", out);
    }

}
