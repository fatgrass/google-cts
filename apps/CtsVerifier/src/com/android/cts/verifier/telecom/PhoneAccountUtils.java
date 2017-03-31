/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License
 */

package com.android.cts.verifier.telecom;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;

import com.android.cts.verifier.PassFailButtons;

/**
 * Utilities class for dealing with the Telecom CTS Verifier PhoneAccounts.
 */
public class PhoneAccountUtils {
    public static final String TEST_PHONE_ACCOUNT_ID = "test";
    public static final String TEST_PHONE_ACCOUNT_LABEL = "CTS Verifier Test";
    public static final Uri TEST_PHONE_ACCOUNT_ADDRESS = Uri.parse("sip:test@android.com");

    public static final PhoneAccountHandle TEST_PHONE_ACCOUNT_HANDLE =
            new PhoneAccountHandle(new ComponentName(
                    PassFailButtons.class.getPackage().getName(),
                    CtsConnectionService.class.getName()), TEST_PHONE_ACCOUNT_ID);
    public static final PhoneAccount TEST_PHONE_ACCOUNT = new PhoneAccount.Builder(
            TEST_PHONE_ACCOUNT_HANDLE, TEST_PHONE_ACCOUNT_LABEL)
            .setAddress(TEST_PHONE_ACCOUNT_ADDRESS)
            .setCapabilities(PhoneAccount.CAPABILITY_CALL_PROVIDER)
            .build();

    /**
     * Registers the test phone account.
     * @param context The context.
     */
    public static void registerTestPhoneAccount(Context context) {
        TelecomManager telecomManager = (TelecomManager) context.getSystemService(
                Context.TELECOM_SERVICE);
        telecomManager.registerPhoneAccount(TEST_PHONE_ACCOUNT);
    }

    /**
     * Retrieves the test phone account, or null if not registered.
     * @param context The context.
     * @return The Phone Account.
     */
    public static PhoneAccount getPhoneAccount(Context context) {
        TelecomManager telecomManager = (TelecomManager) context.getSystemService(
                Context.TELECOM_SERVICE);
        return telecomManager.getPhoneAccount(TEST_PHONE_ACCOUNT_HANDLE);
    }

    /**
     * Unregisters the test phone account.
     * @param context The context.
     */
    public static void unRegisterTestPhoneAccount(Context context) {
        TelecomManager telecomManager = (TelecomManager) context.getSystemService(
                Context.TELECOM_SERVICE);
        telecomManager.unregisterPhoneAccount(TEST_PHONE_ACCOUNT_HANDLE);
    }
}
