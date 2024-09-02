package com.mozhimen.java.utilk.android.content;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.mozhimen.java.utilk.commons.IUtilK;
import com.mozhimen.java.utilk.android.util.UtilKLogWrapper;

/**
 * @ClassName ContextStartUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/25
 * @Version 1.0
 */
public class UtilKContextStart implements IUtilK {
    public static boolean startContext(Context context, Intent intent) {
        if (!(context instanceof Activity))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            UtilKLogWrapper.e(TAG, "startContext: ", e);
            return false;
        }
    }

    public static void startContextByPackageName(Context context, String strPackageName, String activityName) {
        Intent intent = UtilKIntentWrapper.getComponent(strPackageName, activityName);
        startContext(context, intent);
    }
}
