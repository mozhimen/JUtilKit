package com.mozhimen.utilk.android.android.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.mozhimen.elemk.android.android.content.cons.CIntent;
import com.mozhimen.utilk.android.android.os.UtilKBuildVersion;
import com.mozhimen.utilk.android.java.UtilKStrFile;
import com.mozhimen.utilk.android.java.io.UtilKFileFormat;
import java.io.File;

/**
 * @ClassName UtilKIntent
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:04
 * @Version 1.0
 */
public class UtilKIntentWrapper {


    ///////////////////////////////////////////////////////////////////////////////////////

    public static Intent getByPackageName(String strPackageName, String activityName) {
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(strPackageName, strPackageName + "." + activityName);
        intent.setComponent(cn);
        return intent;
    }

    public static Intent getViewInstall(Context context, File fileApk) {
        Uri uri = UtilKFileFormat.strFilePath2uri(context, strFilePathName);
        if (uri != null)
            return getViewInstall(uri);
        else
            return null;
    }

    public static Intent getViewInstall(Context context, String strFilePathName) {
        Uri uri = UtilKStrFile.strFilePath2uri(context, strFilePathName);
        if (uri != null)
            return getViewInstall(uri);
        else
            return null;
    }

    public static Intent getViewInstall(Uri apkUri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (UtilKBuildVersion.isAfterV_24_7_N()) //判断安卓系统是否大于7.0  大于7.0使用以下方法
            intent.addFlags(CIntent.FLAG_GRANT_READ_URI_PERMISSION); //增加读写权限//添加这一句表示对目标应用临时授权该Uri所代表的文件
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        return intent;
    }
}
