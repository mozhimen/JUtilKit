package com.mozhimen.java.utilk.android.content;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;

import com.mozhimen.java.
        utilk.commons.IUtilK;

/**
 * @ClassName UtilKPackageInfo
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:36
 * @Version 1.0
 */
public class UtilKPackageInfo implements IUtilK {
    public static PackageInfo get(Context context, String strPackageName, int flags) {
        return UtilKPackageManagerWrapper.getPackageInfoSafe(context, strPackageName, flags);
    }

    public static PackageInfo get(Context context, int flags) {
        return get(context, UtilKContext.getPackageName(context), flags /*0*/);
    }

    public static PackageInfo get(Context context) {
        return get(context, 0);
    }

    //////////////////////////////////////////////////////////////

    /**
     * 获取程序包名
     */
    public static String getVersionName(Context context) {
        PackageInfo packageInfo = get(context);
        if (packageInfo != null) {
            return getVersionName(packageInfo);
        } else
            return "";
    }

    public static String getVersionName(PackageInfo packageInfo) {
        try {
            if (packageInfo != null) {
                return packageInfo.versionName;
            } else
                return "";
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "getVersionName: NameNotFoundException ${e.message}");
            return "";
        }
    }

    /**
     * 获取程序版本号
     */
    public static int getVersionCode(Context context) {
        PackageInfo packageInfo = get(context);
        if (packageInfo != null) {
            return getVersionCode(packageInfo);
        } else
            return 0;
    }

    public static int getVersionCode(PackageInfo packageInfo) {
        try {
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    return (int) packageInfo.getLongVersionCode();
                } else {
                    return packageInfo.versionCode;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "getVersionCode: NameNotFoundException ${e.message}");
            return 0;
        }
    }


}
