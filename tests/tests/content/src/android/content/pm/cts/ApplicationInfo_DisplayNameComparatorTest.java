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

package android.content.pm.cts;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo.DisplayNameComparator;
import android.content.pm.PackageManager.NameNotFoundException;
import android.test.AndroidTestCase;
import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargetClass;
import dalvik.annotation.ToBeFixed;

/**
 * Test {@link DisplayNameComparator}.
 */
@TestTargetClass(DisplayNameComparator.class)
public class ApplicationInfo_DisplayNameComparatorTest extends AndroidTestCase {
    DisplayNameComparator mDisplayNameComparator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mDisplayNameComparator = null;
    }

    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "Test constructor(s) of {@link ApplicationInfo.DisplayNameComparator}",
        method = "ApplicationInfo.DisplayNameComparator",
        args = {android.content.pm.PackageManager.class}
    )
    public void testConstructor() {
        PackageManager pm = getContext().getPackageManager();
        new DisplayNameComparator(pm);

        new DisplayNameComparator(null);
    }

    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "Test compare(ApplicationInfo, ApplicationInfo)",
        method = "compare",
        args = {android.content.pm.ApplicationInfo.class, android.content.pm.ApplicationInfo.class}
    )
    @ToBeFixed(bug = "1417734", explanation = "NPE is not expected.")
    public void testCompare() {
        PackageManager pm = getContext().getPackageManager();
        mDisplayNameComparator = new ApplicationInfo.DisplayNameComparator(pm);

        ApplicationInfo info1 = new ApplicationInfo();
        ApplicationInfo info2 = new ApplicationInfo();
        info1.packageName = "com.android";
        info2.packageName = "com.android";
        assertEquals(0, mDisplayNameComparator.compare(info1, info2));

        try {
            info1 = mContext.getPackageManager().getApplicationInfo("com.android", 0);
        } catch (NameNotFoundException e) {
            fail("getApplicationInfo should not throw NameNotFoundException here.");
        }
        info2.packageName = "com.android.2";
        assertTrue((mDisplayNameComparator.compare(info1, info2) < 0));

        info1 = new ApplicationInfo();
        info1.packageName = "com.android.1";
        try {
            info2 =
                mContext.getPackageManager().getApplicationInfo("com.android", 0);
        } catch (NameNotFoundException e) {
            fail("getApplicationInfo should not throw NameNotFoundException here.");
        }
        assertTrue((mDisplayNameComparator.compare(info1, info2) > 0));

        try {
            mDisplayNameComparator.compare(null, null);
            fail("should throw NullPointerException.");
        } catch (NullPointerException e) {
        }
    }
}
