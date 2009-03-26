/*
 * Copyright (C) 2008 The Android Open Source Project
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

package android.text.cts;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.test.AndroidTestCase;
import android.text.TextPaint;
import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargetClass;
import dalvik.annotation.ToBeFixed;

/**
 * Test {@link TextPaint}.
 */
@TestTargetClass(TextPaint.class)
public class TextPaintTest extends AndroidTestCase {
    private static final int PAINT_FLAGS_MASK     = 0x000001FF;

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.COMPLETE,
            notes = "Test constructor(s) of {@link TextPaint}",
            method = "TextPaint",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.COMPLETE,
            notes = "Test constructor(s) of {@link TextPaint}",
            method = "TextPaint",
            args = {int.class}
        ),
        @TestTargetNew(
            level = TestLevel.COMPLETE,
            notes = "Test constructor(s) of {@link TextPaint}",
            method = "TextPaint",
            args = {android.graphics.Paint.class}
        )
    })
    @ToBeFixed(bug="1417734", explanation="should add @throws clause for" +
            " TextPaint#TextPaint(Paint) when the input Paint is null")
    public void testConstructor() {
        TextPaint textPaint;

        textPaint = new TextPaint();
        assertEquals(TextPaint.DEV_KERN_TEXT_FLAG & PAINT_FLAGS_MASK, textPaint.getFlags());

        textPaint = new TextPaint(TextPaint.DITHER_FLAG);
        assertEquals((TextPaint.DITHER_FLAG | TextPaint.DEV_KERN_TEXT_FLAG) & PAINT_FLAGS_MASK,
                textPaint.getFlags());

        textPaint = new TextPaint(-1);
        assertEquals((-1 | TextPaint.DEV_KERN_TEXT_FLAG) & PAINT_FLAGS_MASK,
                textPaint.getFlags());

        textPaint = new TextPaint(Integer.MAX_VALUE);
        assertEquals((Integer.MAX_VALUE | TextPaint.DEV_KERN_TEXT_FLAG) & PAINT_FLAGS_MASK,
                textPaint.getFlags());

        textPaint = new TextPaint(new Paint());
        assertEquals(TextPaint.DEV_KERN_TEXT_FLAG & PAINT_FLAGS_MASK, textPaint.getFlags());

        try {
            new TextPaint(null);
            fail("Should throw NullPointerException!");
        } catch (NullPointerException e) {
        }
    }

    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "Test {@link TextPaint#set(TextPaint)}",
        method = "set",
        args = {android.text.TextPaint.class}
    )
    @ToBeFixed(bug="1417734", explanation="should add @throws clause for" +
            " TextPaint#set(TextPaint) when the input TextPaint is null")
    public void testSet() {
        TextPaint textPaintSrc = new TextPaint(TextPaint.DITHER_FLAG);
        int[] drawableState = new int[] { 0, 1 };
        textPaintSrc.bgColor = Color.GREEN;
        textPaintSrc.baselineShift = 10;
        textPaintSrc.linkColor = Color.BLUE;
        textPaintSrc.drawableState = drawableState;
        textPaintSrc.setTypeface(Typeface.DEFAULT_BOLD);

        TextPaint textPaint = new TextPaint();
        assertEquals(0, textPaint.bgColor);
        assertEquals(0, textPaint.baselineShift);
        assertEquals(0, textPaint.linkColor);
        assertNull(textPaint.drawableState);
        assertNull(textPaint.getTypeface());
        assertEquals(TextPaint.DEV_KERN_TEXT_FLAG & PAINT_FLAGS_MASK, textPaint.getFlags());

        textPaint.set(textPaintSrc);
        assertEquals(textPaintSrc.bgColor, textPaint.bgColor);
        assertEquals(textPaintSrc.baselineShift, textPaint.baselineShift);
        assertEquals(textPaintSrc.linkColor, textPaint.linkColor);
        assertSame(textPaintSrc.drawableState, textPaint.drawableState);
        assertEquals(textPaintSrc.getTypeface(), textPaint.getTypeface());
        assertEquals(textPaintSrc.getFlags(), textPaint.getFlags());

        try {
            textPaint.set(null);
            fail("Should throw NullPointerException!");
        } catch (NullPointerException e) {
        }
    }
}
