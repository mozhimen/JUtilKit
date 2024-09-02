package com.mozhimen.java.utilk.android.os;

import android.os.Build;

import com.mozhimen.java.elemk.android.android.os.cons.CVersCode;
//import androidx.annotation.ChecksSdkIntAtLeast;

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

    ///////////////////////////////////////////////////////////////////////

    public static boolean isBeforeV_33_13_TIRAMISU() {
        return isBeforeVersion(CVersCode.V_33_13_TIRAMISU);
    }

    //    @ChecksSdkIntAtLeast(api = CVersCode.V_24_7_N)
    public static boolean isAfterV_24_7_N() {
        return isAfterVersion(CVersCode.V_24_7_N);
    }

    //    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.TIRAMISU)
    public static boolean isAfterV_33_13_TIRAMISU() {
        return isAfterVersion(CVersCode.V_33_13_TIRAMISU);
    }
}