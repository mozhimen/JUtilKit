package com.mozhimen.utilk.android.android.content;

import android.content.Context;
import android.content.pm.PackageManager;

import com.mozhimen.utilk.android.bases.BaseUtilK;

/**
 * @ClassName UtilKPackage
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 16:03
 * @Version 1.0
 */
public class UtilKPackage extends BaseUtilK {
    public static String getPackageName() {
        return UtilKContext.getPackageName(getContext());
    }

    public static boolean hasPackage(Context context, String strPackageName) {
        try {
            UtilKPackageInfo.get(context, strPackageName);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
