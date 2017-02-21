/*
 * Copyright (C) 2016 The Android Open Source Project
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

// Don't edit this file!  It is auto-generated by frameworks/rs/api/generate.sh.

package android.renderscript.cts;

import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.Element;
import android.renderscript.cts.Target;

import java.util.Arrays;

public class TestFdim extends RSBaseCompute {

    private ScriptC_TestFdim script;
    private ScriptC_TestFdimRelaxed scriptRelaxed;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        script = new ScriptC_TestFdim(mRS);
        scriptRelaxed = new ScriptC_TestFdimRelaxed(mRS);
    }

    public class ArgumentsFloatFloatFloat {
        public float inA;
        public float inB;
        public Target.Floaty out;
    }

    private void checkFdimFloatFloatFloat() {
        Allocation inA = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0xf5dd38fbc3a47366l, false);
        Allocation inB = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0xf5dd38fbc3a47367l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInB(inB);
            script.forEach_testFdimFloatFloatFloat(inA, out);
            verifyResultsFdimFloatFloatFloat(inA, inB, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimFloatFloatFloat: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInB(inB);
            scriptRelaxed.forEach_testFdimFloatFloatFloat(inA, out);
            verifyResultsFdimFloatFloatFloat(inA, inB, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimFloatFloatFloat: " + e.toString());
        }
    }

    private void verifyResultsFdimFloatFloatFloat(Allocation inA, Allocation inB, Allocation out, boolean relaxed) {
        float[] arrayInA = new float[INPUTSIZE * 1];
        Arrays.fill(arrayInA, (float) 42);
        inA.copyTo(arrayInA);
        float[] arrayInB = new float[INPUTSIZE * 1];
        Arrays.fill(arrayInB, (float) 42);
        inB.copyTo(arrayInB);
        float[] arrayOut = new float[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 1 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
                args.inA = arrayInA[i];
                args.inB = arrayInB[i];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computeFdim(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 1 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inA: ");
                        appendVariableToMessage(message, args.inA);
                        message.append("\n");
                        message.append("Input inB: ");
                        appendVariableToMessage(message, args.inB);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 1 + j]);
                        if (!args.out.couldBe(arrayOut[i * 1 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkFdimFloatFloatFloat" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkFdimFloat2Float2Float2() {
        Allocation inA = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0xca6a96c16f167f4cl, false);
        Allocation inB = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0xca6a96c16f167f4dl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            script.set_gAllocInB(inB);
            script.forEach_testFdimFloat2Float2Float2(inA, out);
            verifyResultsFdimFloat2Float2Float2(inA, inB, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimFloat2Float2Float2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            scriptRelaxed.set_gAllocInB(inB);
            scriptRelaxed.forEach_testFdimFloat2Float2Float2(inA, out);
            verifyResultsFdimFloat2Float2Float2(inA, inB, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimFloat2Float2Float2: " + e.toString());
        }
    }

    private void verifyResultsFdimFloat2Float2Float2(Allocation inA, Allocation inB, Allocation out, boolean relaxed) {
        float[] arrayInA = new float[INPUTSIZE * 2];
        Arrays.fill(arrayInA, (float) 42);
        inA.copyTo(arrayInA);
        float[] arrayInB = new float[INPUTSIZE * 2];
        Arrays.fill(arrayInB, (float) 42);
        inB.copyTo(arrayInB);
        float[] arrayOut = new float[INPUTSIZE * 2];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 2 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
                args.inA = arrayInA[i * 2 + j];
                args.inB = arrayInB[i * 2 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computeFdim(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 2 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inA: ");
                        appendVariableToMessage(message, args.inA);
                        message.append("\n");
                        message.append("Input inB: ");
                        appendVariableToMessage(message, args.inB);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 2 + j]);
                        if (!args.out.couldBe(arrayOut[i * 2 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkFdimFloat2Float2Float2" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkFdimFloat3Float3Float3() {
        Allocation inA = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0x1ecf74e170f480edl, false);
        Allocation inB = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0x1ecf74e170f480eel, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            script.set_gAllocInB(inB);
            script.forEach_testFdimFloat3Float3Float3(inA, out);
            verifyResultsFdimFloat3Float3Float3(inA, inB, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimFloat3Float3Float3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            scriptRelaxed.set_gAllocInB(inB);
            scriptRelaxed.forEach_testFdimFloat3Float3Float3(inA, out);
            verifyResultsFdimFloat3Float3Float3(inA, inB, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimFloat3Float3Float3: " + e.toString());
        }
    }

    private void verifyResultsFdimFloat3Float3Float3(Allocation inA, Allocation inB, Allocation out, boolean relaxed) {
        float[] arrayInA = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInA, (float) 42);
        inA.copyTo(arrayInA);
        float[] arrayInB = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInB, (float) 42);
        inB.copyTo(arrayInB);
        float[] arrayOut = new float[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 3 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
                args.inA = arrayInA[i * 4 + j];
                args.inB = arrayInB[i * 4 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computeFdim(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inA: ");
                        appendVariableToMessage(message, args.inA);
                        message.append("\n");
                        message.append("Input inB: ");
                        appendVariableToMessage(message, args.inB);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkFdimFloat3Float3Float3" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkFdimFloat4Float4Float4() {
        Allocation inA = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0x7334530172d2828el, false);
        Allocation inB = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0x7334530172d2828fl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            script.set_gAllocInB(inB);
            script.forEach_testFdimFloat4Float4Float4(inA, out);
            verifyResultsFdimFloat4Float4Float4(inA, inB, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimFloat4Float4Float4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            scriptRelaxed.set_gAllocInB(inB);
            scriptRelaxed.forEach_testFdimFloat4Float4Float4(inA, out);
            verifyResultsFdimFloat4Float4Float4(inA, inB, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimFloat4Float4Float4: " + e.toString());
        }
    }

    private void verifyResultsFdimFloat4Float4Float4(Allocation inA, Allocation inB, Allocation out, boolean relaxed) {
        float[] arrayInA = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInA, (float) 42);
        inA.copyTo(arrayInA);
        float[] arrayInB = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInB, (float) 42);
        inB.copyTo(arrayInB);
        float[] arrayOut = new float[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 4 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
                args.inA = arrayInA[i * 4 + j];
                args.inB = arrayInB[i * 4 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computeFdim(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inA: ");
                        appendVariableToMessage(message, args.inA);
                        message.append("\n");
                        message.append("Input inB: ");
                        appendVariableToMessage(message, args.inB);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkFdimFloat4Float4Float4" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public class ArgumentsHalfHalfHalf {
        public short inA;
        public double inADouble;
        public short inB;
        public double inBDouble;
        public Target.Floaty out;
    }

    private void checkFdimHalfHalfHalf() {
        Allocation inA = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 1, 0xc0b8321d3357407dl, false);
        Allocation inB = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 1, 0xc0b8321d3357407el, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 1), INPUTSIZE);
            script.set_gAllocInB(inB);
            script.forEach_testFdimHalfHalfHalf(inA, out);
            verifyResultsFdimHalfHalfHalf(inA, inB, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimHalfHalfHalf: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInB(inB);
            scriptRelaxed.forEach_testFdimHalfHalfHalf(inA, out);
            verifyResultsFdimHalfHalfHalf(inA, inB, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimHalfHalfHalf: " + e.toString());
        }
    }

    private void verifyResultsFdimHalfHalfHalf(Allocation inA, Allocation inB, Allocation out, boolean relaxed) {
        short[] arrayInA = new short[INPUTSIZE * 1];
        Arrays.fill(arrayInA, (short) 42);
        inA.copyTo(arrayInA);
        short[] arrayInB = new short[INPUTSIZE * 1];
        Arrays.fill(arrayInB, (short) 42);
        inB.copyTo(arrayInB);
        short[] arrayOut = new short[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (short) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 1 ; j++) {
                // Extract the inputs.
                ArgumentsHalfHalfHalf args = new ArgumentsHalfHalfHalf();
                args.inA = arrayInA[i];
                args.inADouble = Float16Utils.convertFloat16ToDouble(args.inA);
                args.inB = arrayInB[i];
                args.inBDouble = Float16Utils.convertFloat16ToDouble(args.inB);
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.HALF, relaxed);
                CoreMathVerifier.computeFdim(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 1 + j]))) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inA: ");
                        appendVariableToMessage(message, args.inA);
                        message.append("\n");
                        message.append("Input inB: ");
                        appendVariableToMessage(message, args.inB);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 1 + j]);
                        message.append("\n");
                        message.append("Actual   output out (in double): ");
                        appendVariableToMessage(message, Float16Utils.convertFloat16ToDouble(arrayOut[i * 1 + j]));
                        if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 1 + j]))) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkFdimHalfHalfHalf" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkFdimHalf2Half2Half2() {
        Allocation inA = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 2, 0xc54d7b18fa8ab75bl, false);
        Allocation inB = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 2, 0xc54d7b18fa8ab75cl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 2), INPUTSIZE);
            script.set_gAllocInB(inB);
            script.forEach_testFdimHalf2Half2Half2(inA, out);
            verifyResultsFdimHalf2Half2Half2(inA, inB, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimHalf2Half2Half2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 2), INPUTSIZE);
            scriptRelaxed.set_gAllocInB(inB);
            scriptRelaxed.forEach_testFdimHalf2Half2Half2(inA, out);
            verifyResultsFdimHalf2Half2Half2(inA, inB, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimHalf2Half2Half2: " + e.toString());
        }
    }

    private void verifyResultsFdimHalf2Half2Half2(Allocation inA, Allocation inB, Allocation out, boolean relaxed) {
        short[] arrayInA = new short[INPUTSIZE * 2];
        Arrays.fill(arrayInA, (short) 42);
        inA.copyTo(arrayInA);
        short[] arrayInB = new short[INPUTSIZE * 2];
        Arrays.fill(arrayInB, (short) 42);
        inB.copyTo(arrayInB);
        short[] arrayOut = new short[INPUTSIZE * 2];
        Arrays.fill(arrayOut, (short) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 2 ; j++) {
                // Extract the inputs.
                ArgumentsHalfHalfHalf args = new ArgumentsHalfHalfHalf();
                args.inA = arrayInA[i * 2 + j];
                args.inADouble = Float16Utils.convertFloat16ToDouble(args.inA);
                args.inB = arrayInB[i * 2 + j];
                args.inBDouble = Float16Utils.convertFloat16ToDouble(args.inB);
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.HALF, relaxed);
                CoreMathVerifier.computeFdim(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 2 + j]))) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inA: ");
                        appendVariableToMessage(message, args.inA);
                        message.append("\n");
                        message.append("Input inB: ");
                        appendVariableToMessage(message, args.inB);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 2 + j]);
                        message.append("\n");
                        message.append("Actual   output out (in double): ");
                        appendVariableToMessage(message, Float16Utils.convertFloat16ToDouble(arrayOut[i * 2 + j]));
                        if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 2 + j]))) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkFdimHalf2Half2Half2" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkFdimHalf3Half3Half3() {
        Allocation inA = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 3, 0xeb01fb025929c82al, false);
        Allocation inB = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 3, 0xeb01fb025929c82bl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 3), INPUTSIZE);
            script.set_gAllocInB(inB);
            script.forEach_testFdimHalf3Half3Half3(inA, out);
            verifyResultsFdimHalf3Half3Half3(inA, inB, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimHalf3Half3Half3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 3), INPUTSIZE);
            scriptRelaxed.set_gAllocInB(inB);
            scriptRelaxed.forEach_testFdimHalf3Half3Half3(inA, out);
            verifyResultsFdimHalf3Half3Half3(inA, inB, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimHalf3Half3Half3: " + e.toString());
        }
    }

    private void verifyResultsFdimHalf3Half3Half3(Allocation inA, Allocation inB, Allocation out, boolean relaxed) {
        short[] arrayInA = new short[INPUTSIZE * 4];
        Arrays.fill(arrayInA, (short) 42);
        inA.copyTo(arrayInA);
        short[] arrayInB = new short[INPUTSIZE * 4];
        Arrays.fill(arrayInB, (short) 42);
        inB.copyTo(arrayInB);
        short[] arrayOut = new short[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (short) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 3 ; j++) {
                // Extract the inputs.
                ArgumentsHalfHalfHalf args = new ArgumentsHalfHalfHalf();
                args.inA = arrayInA[i * 4 + j];
                args.inADouble = Float16Utils.convertFloat16ToDouble(args.inA);
                args.inB = arrayInB[i * 4 + j];
                args.inBDouble = Float16Utils.convertFloat16ToDouble(args.inB);
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.HALF, relaxed);
                CoreMathVerifier.computeFdim(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]))) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inA: ");
                        appendVariableToMessage(message, args.inA);
                        message.append("\n");
                        message.append("Input inB: ");
                        appendVariableToMessage(message, args.inB);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        message.append("\n");
                        message.append("Actual   output out (in double): ");
                        appendVariableToMessage(message, Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]));
                        if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]))) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkFdimHalf3Half3Half3" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkFdimHalf4Half4Half4() {
        Allocation inA = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 4, 0x10b67aebb7c8d8f9l, false);
        Allocation inB = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 4, 0x10b67aebb7c8d8fal, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 4), INPUTSIZE);
            script.set_gAllocInB(inB);
            script.forEach_testFdimHalf4Half4Half4(inA, out);
            verifyResultsFdimHalf4Half4Half4(inA, inB, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimHalf4Half4Half4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 4), INPUTSIZE);
            scriptRelaxed.set_gAllocInB(inB);
            scriptRelaxed.forEach_testFdimHalf4Half4Half4(inA, out);
            verifyResultsFdimHalf4Half4Half4(inA, inB, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFdimHalf4Half4Half4: " + e.toString());
        }
    }

    private void verifyResultsFdimHalf4Half4Half4(Allocation inA, Allocation inB, Allocation out, boolean relaxed) {
        short[] arrayInA = new short[INPUTSIZE * 4];
        Arrays.fill(arrayInA, (short) 42);
        inA.copyTo(arrayInA);
        short[] arrayInB = new short[INPUTSIZE * 4];
        Arrays.fill(arrayInB, (short) 42);
        inB.copyTo(arrayInB);
        short[] arrayOut = new short[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (short) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 4 ; j++) {
                // Extract the inputs.
                ArgumentsHalfHalfHalf args = new ArgumentsHalfHalfHalf();
                args.inA = arrayInA[i * 4 + j];
                args.inADouble = Float16Utils.convertFloat16ToDouble(args.inA);
                args.inB = arrayInB[i * 4 + j];
                args.inBDouble = Float16Utils.convertFloat16ToDouble(args.inB);
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.HALF, relaxed);
                CoreMathVerifier.computeFdim(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]))) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inA: ");
                        appendVariableToMessage(message, args.inA);
                        message.append("\n");
                        message.append("Input inB: ");
                        appendVariableToMessage(message, args.inB);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        message.append("\n");
                        message.append("Actual   output out (in double): ");
                        appendVariableToMessage(message, Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]));
                        if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]))) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkFdimHalf4Half4Half4" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public void testFdim() {
        checkFdimFloatFloatFloat();
        checkFdimFloat2Float2Float2();
        checkFdimFloat3Float3Float3();
        checkFdimFloat4Float4Float4();
        checkFdimHalfHalfHalf();
        checkFdimHalf2Half2Half2();
        checkFdimHalf3Half3Half3();
        checkFdimHalf4Half4Half4();
    }
}
