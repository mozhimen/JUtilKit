package com.mozhimen.utilk.android;

import android.os.Build;

import androidx.annotation.ChecksSdkIntAtLeast;

/**
 * @ClassName UtilKBuildVers
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/28 1:12
 * @Version 1.0
 */
public class UtilKBuildVersion {

    public static int getSDKInt() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean isBeforeVersion(int versionInt) {
        return getSDKInt() < versionInt;
    }

    public static boolean isAfterVersion(int versionInt) {
        return getSDKInt() >= versionInt;
    }

    public static boolean isBeforeV_33_13_TIRAMISU() {
        return isBeforeVersion(Build.VERSION_CODES.TIRAMISU);
    }

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.TIRAMISU)
    public static boolean isAfterV_33_13_TIRAMISU() {
        return isAfterVersion(Build.VERSION_CODES.TIRAMISU);
    }
}
