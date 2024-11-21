package com.mozhimen.java.utilk.wrapper;

import android.content.Context;

import com.mozhimen.java.
utilk.android.content.UtilKContext;
import com.mozhimen.java.
utilk.android.content.UtilKPackageInfo;
import com.mozhimen.java.
utilk.bases.BaseUtilK;

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
