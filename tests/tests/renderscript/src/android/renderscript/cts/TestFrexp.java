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

// Don't edit this file!  It is auto-generated by frameworks/rs/api/gen_runtime.

package android.renderscript.cts;

import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.Element;

public class TestFrexp extends RSBaseCompute {

    private ScriptC_TestFrexp script;
    private ScriptC_TestFrexpRelaxed scriptRelaxed;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        script = new ScriptC_TestFrexp(mRS);
        scriptRelaxed = new ScriptC_TestFrexpRelaxed(mRS);
    }

    private void checkFrexpFloatIntFloat() {
        Allocation inV = CreateRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0x4c40bc225a45eb6dL);
        try {
            Allocation outIptr = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.SIGNED_32, 1), INPUTSIZE);
            Allocation out = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocOutIptr(outIptr);
            script.forEach_testFrexpFloatIntFloat(inV, out);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFrexpFloatIntFloat: " + e.toString());
        }
        try {
            Allocation outIptr = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.SIGNED_32, 1), INPUTSIZE);
            Allocation out = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocOutIptr(outIptr);
            scriptRelaxed.forEach_testFrexpFloatIntFloat(inV, out);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFrexpFloatIntFloat: " + e.toString());
        }
    }

    private void checkFrexpFloat2Int2Float2() {
        Allocation inV = CreateRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0xe7a92d375526161L);
        try {
            Allocation outIptr = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.SIGNED_32, 2), INPUTSIZE);
            Allocation out = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            script.set_gAllocOutIptr(outIptr);
            script.forEach_testFrexpFloat2Int2Float2(inV, out);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFrexpFloat2Int2Float2: " + e.toString());
        }
        try {
            Allocation outIptr = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.SIGNED_32, 2), INPUTSIZE);
            Allocation out = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            scriptRelaxed.set_gAllocOutIptr(outIptr);
            scriptRelaxed.forEach_testFrexpFloat2Int2Float2(inV, out);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFrexpFloat2Int2Float2: " + e.toString());
        }
    }

    private void checkFrexpFloat3Int3Float3() {
        Allocation inV = CreateRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0x6fc32b940b05a592L);
        try {
            Allocation outIptr = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.SIGNED_32, 3), INPUTSIZE);
            Allocation out = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            script.set_gAllocOutIptr(outIptr);
            script.forEach_testFrexpFloat3Int3Float3(inV, out);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFrexpFloat3Int3Float3: " + e.toString());
        }
        try {
            Allocation outIptr = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.SIGNED_32, 3), INPUTSIZE);
            Allocation out = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            scriptRelaxed.set_gAllocOutIptr(outIptr);
            scriptRelaxed.forEach_testFrexpFloat3Int3Float3(inV, out);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFrexpFloat3Int3Float3: " + e.toString());
        }
    }

    private void checkFrexpFloat4Int4Float4() {
        Allocation inV = CreateRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0xd10bc454a0b8e9c3L);
        try {
            Allocation outIptr = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.SIGNED_32, 4), INPUTSIZE);
            Allocation out = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            script.set_gAllocOutIptr(outIptr);
            script.forEach_testFrexpFloat4Int4Float4(inV, out);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFrexpFloat4Int4Float4: " + e.toString());
        }
        try {
            Allocation outIptr = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.SIGNED_32, 4), INPUTSIZE);
            Allocation out = Allocation.createSized(mRS, GetElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            scriptRelaxed.set_gAllocOutIptr(outIptr);
            scriptRelaxed.forEach_testFrexpFloat4Int4Float4(inV, out);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFrexpFloat4Int4Float4: " + e.toString());
        }
    }

    public void testFrexp() {
        checkFrexpFloatIntFloat();
        checkFrexpFloat2Int2Float2();
        checkFrexpFloat3Int3Float3();
        checkFrexpFloat4Int4Float4();
    }
}
