package com.mozhimen.java.utilk.android.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


import androidx.annotation.RequiresPermission;

import com.mozhimen.java.
elemk.android.android.content.cons.CIntent;
import com.mozhimen.java.
elemk.android.android.content.cons.CPermission;
import com.mozhimen.java.
utilk.android.app.UtilKActivityInfoWrapper;
import com.mozhimen.java.utilk.android.os.UtilKBuildVersion;
import com.mozhimen.java.
utilk.java.UtilKStrFile;
import com.mozhimen.java.
utilk.java.UtilKStringWrapper;
import com.mozhimen.java.
utilk.java.io.UtilKFileFormat;

import java.io.File;

/**
 * @ClassName UtilKIntent
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:04
 * @Version 1.0
 */
public class UtilKIntentWrapper {
    //获取启动App的Intent
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    public static Intent getMainLauncher_ofPackageManger(Context context, String strPackageName) {
        String strLauncherActivityName = UtilKActivityInfoWrapper.getMainLauncherName(context, strPackageName);
        if (UtilKStringWrapper.hasSpace(strLauncherActivityName) || strLauncherActivityName.isEmpty())
            return UtilKPackageManager.getLaunchIntentForPackage(context, strPackageName);
        return getMainLauncher_ofClazz(strPackageName, strLauncherActivityName);
    }

    //获取mainLauncher
    public static Intent getMainLauncher_ofClazz(String strPackageName, String strActivityName) {
        Intent intent = getMain();
        intent.addCategory(CIntent.CATEGORY_LAUNCHER);
        intent.setClassName(strPackageName, strActivityName);
        return intent;
    }


    ///////////////////////////////////////////////////////////////////////////////////////

    public static Intent getComponent(String strPackageName, String activityName) {
        Intent intent = UtilKIntent.get();
        ComponentName cn = new ComponentName(strPackageName, strPackageName + "." + activityName);
        intent.setComponent(cn);
        return intent;
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    public static Intent getView() {
        return UtilKIntent.get(CIntent.ACTION_VIEW);
    }

    public static Intent getViewInstall(Uri apkUri) {
        Intent intent = getView();
        if (UtilKBuildVersion.isAfterV_24_7_N()) //判断安卓系统是否大于7.0  大于7.0使用以下方法
            intent.addFlags(CIntent.FLAG_GRANT_READ_URI_PERMISSION); //增加读写权限//添加这一句表示对目标应用临时授权该Uri所代表的文件
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        return intent;
    }

    public static Intent getViewInstall(String strFilePathName) {
        Uri uri = UtilKStrFile.strFilePath2uri(strFilePathName);
        if (uri != null)
            return getViewInstall(uri);
        else
            return null;
    }

    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    public static Intent getViewInstall(File fileApk) {
        Uri uri = UtilKFileFormat.file2uri(fileApk);
        if (uri != null)
            return getViewInstall(uri);
        else
            return null;
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    public static Intent getMain() {
        return UtilKIntent.get(CIntent.ACTION_MAIN);
    }

    public static Intent getMain(Uri uri) {
        return UtilKIntent.get(CIntent.ACTION_MAIN, uri);
    }

    //获取mainLauncher
    public static Intent getMainLauncher_ofPackage(String strPackageName, Uri uri) {
        Intent intent = getMain(uri);
        intent.addCategory(CIntent.CATEGORY_LAUNCHER);
        intent.setPackage(strPackageName);
        return intent;
    }
}
