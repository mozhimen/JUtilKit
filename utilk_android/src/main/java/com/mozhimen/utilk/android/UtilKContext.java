package com.mozhimen.utilk.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.WindowManager;

/**
 * @ClassName UtilKContext
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:25
 * @Version 1.0
 */
public class UtilKContext {
    public static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static PackageManager getPackageManager(Context context) {
        return context.getPackageManager();
    }


}
