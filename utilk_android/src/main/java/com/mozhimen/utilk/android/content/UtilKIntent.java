package com.mozhimen.utilk.android.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import com.mozhimen.utilk.java.lang.UtilKStrFile;

/**
 * @ClassName UtilKIntent
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:04
 * @Version 1.0
 */
public class UtilKIntent {
    public static Intent getByPackageName(String strPackageName, String activityName) {
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(strPackageName, strPackageName + "." + activityName);
        intent.setComponent(cn);
        return intent;
    }

    public static Intent getInstall(Context context, String strFilePathName) {
        Uri uri = UtilKStrFile.strFilePath2uri(context, strFilePathName);
        if (uri != null) {
            return getInstall(uri);
        } else return null;
    }

    public static Intent getInstall(Uri apkUri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) //判断安卓系统是否大于7.0  大于7.0使用以下方法
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //增加读写权限//添加这一句表示对目标应用临时授权该Uri所代表的文件
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        return intent;
    }
}
