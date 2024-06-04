package com.mozhimen.utilk.android.content;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * @ClassName ContextStartUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/25
 * @Version 1.0
 */
public class UtilKContextStart {
    public static void startContext(Context context, Intent intent) {
        if (!(context instanceof Activity)) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void startContextByPackageName(Context context, String strPackageName, String activityName) {
        Intent intent = UtilKIntent.getByPackageName(strPackageName, activityName);
        startContext(context, intent);
    }
}
