package com.mozhimen.java.utilk.android.content;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.WindowManager;

import androidx.annotation.StringRes;

/**
 * @ClassName UtilKContext
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:25
 * @Version 1.0
 */
public class UtilKContext {
    public static ApplicationInfo getApplicationInfo(Context context) {
        return context.getApplicationInfo();
    }

    public static String getString(Context context , @StringRes int intResStr ) {
        return context.getString(intResStr);
    }

    public static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static PackageManager getPackageManager(Context context) {
        return context.getPackageManager();
    }

    ////////////////////////////////////////////////////////////////////////

    public static void grantUriPermission(Context context, Uri uri,int modeFlags) {
        grantUriPermission(context, getPackageName(context), uri, modeFlags);
    }

    public static void grantUriPermission(Context context ,String strPackageName,Uri uri,int modeFlags) {
        context.grantUriPermission(strPackageName, uri, modeFlags);
    }
}
