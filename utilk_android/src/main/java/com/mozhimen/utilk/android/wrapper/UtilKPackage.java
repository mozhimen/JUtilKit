package com.mozhimen.utilk.android.wrapper;

import android.content.Context;

import com.mozhimen.utilk.android.android.content.UtilKContext;
import com.mozhimen.utilk.android.android.content.UtilKPackageInfo;
import com.mozhimen.utilk.android.bases.BaseUtilK;

/**
 * @ClassName UtilKPackage
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/8/15 23:04
 * @Version 1.0
 */
public class UtilKPackage extends BaseUtilK {
    public static String getPackageName() {
        return UtilKContext.getPackageName(getContext());
    }

    public static boolean hasPackage(Context context,String strPackageName) {
        return UtilKPackageInfo.hasPackage(context, strPackageName);
    }
}
