package com.mozhimen.utilk.android.content;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * @ClassName UtilKPackage
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 16:03
 * @Version 1.0
 */
public class UtilKPackage {
    public static boolean hasPackage(Context context, String strPackageName) {
        try {
            UtilKPackageInfo.get(context, strPackageName);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
