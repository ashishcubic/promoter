package com.apbl.promoterapp.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.apbl.promoterapp.core.BaseApplication;

public class VersionUtils {

    public static int getAppVersion() {
        return getAppPackageInfo().versionCode;
    }

    public static String getAppVersionName() {
        return getAppPackageInfo().versionName;
    }

    private static PackageInfo getAppPackageInfo() {
        Context context = BaseApplication.getInstance();
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }
}
