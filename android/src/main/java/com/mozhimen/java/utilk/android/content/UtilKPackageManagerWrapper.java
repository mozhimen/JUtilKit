package com.mozhimen.java.utilk.android.content;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.mozhimen.java.utilk.android.util.UtilKLogWrapper;
import com.mozhimen.java.utilk.commons.IUtilK;

/**
 * @ClassName UtilKPackageManagerWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/13
 * @Version 1.0
 */
public class UtilKPackageManagerWrapper implements IUtilK {
    public static PackageInfo getPackageInfoSafe(Context context, String strPackageName, int flags) {
        try {
            return UtilKPackageManager.getPackageInfo(context, strPackageName, flags);
        } catch (Exception e) {
            e.printStackTrace();
            UtilKLogWrapper.e(TAG, "getPackageInfo: ", e);
            return null;
        }
    }
}
