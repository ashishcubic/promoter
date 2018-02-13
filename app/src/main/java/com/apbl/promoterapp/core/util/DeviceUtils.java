package com.apbl.promoterapp.core.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.apbl.promoterapp.core.BaseApplication;

public class DeviceUtils {

    public static String getDeviceUid() {
        Context context = BaseApplication.getInstance();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String uniqueDeviceId = telephonyManager.getDeviceId();
        if (TextUtils.isEmpty(uniqueDeviceId)) {
            // for tablets
            ContentResolver cr = context.getContentResolver();
            uniqueDeviceId = Settings.Secure.getString(cr, Settings.Secure.ANDROID_ID);
        }

        return uniqueDeviceId;
    }

}
