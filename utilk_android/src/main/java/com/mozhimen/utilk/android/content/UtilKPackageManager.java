package com.mozhimen.utilk.android.content;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.mozhimen.utilk.android.content.UtilKContext;

/**
 * @ClassName UtilKPackageManager
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:36
 * @Version 1.0
 */
public class UtilKPackageManager {
    public static PackageManager get(Context context) {
        return UtilKContext.getPackageManager(context);
    }

    public static PackageInfo getPackageInfo(Context context, String strPackageName,int flags) throws PackageManager.NameNotFoundException {
        return get(context).getPackageInfo(strPackageName, flags);
    }
}
