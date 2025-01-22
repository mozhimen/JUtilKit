package com.mozhimen.java.utilk.android.content;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.view.WindowManager;

import androidx.annotation.StringRes;

import java.io.File;

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

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static PackageManager getPackageManager(Context context) {
        return context.getPackageManager();
    }

    public static AssetManager getAssets(Context context) {
        return context.getAssets();
    }

    public static Resources getResources(Context context) {
        return context.getResources();
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     * 系统空间不足时可能会删除
     */
    public static File getCacheDir(Context context) {
        return context.getCacheDir();
    }

    public static File getFilesDir(Context context) {
        return context.getFilesDir();
    }

    ////////////////////////////////////////////////////////////////////////

    public static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    ////////////////////////////////////////////////////////////////////////

    public static String getString(Context context, @StringRes int intResStr) {
        return context.getString(intResStr);
    }

    ////////////////////////////////////////////////////////////////////////

    public static void grantUriPermission(Context context, Uri uri, int modeFlags) {
        grantUriPermission(context, getPackageName(context), uri, modeFlags);
    }

    public static void grantUriPermission(Context context, String strPackageName, Uri uri, int modeFlags) {
        context.grantUriPermission(strPackageName, uri, modeFlags);
    }
}
