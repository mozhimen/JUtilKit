package com.mozhimen.java.utilk.android.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import androidx.annotation.IdRes;

import com.mozhimen.java.utilk.wrapper.UtilKRes;

/**
 * @ClassName UtilKApplicationInfo
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/8/15 23:23
 * @Version 1.0
 */
public class UtilKApplicationInfo {
    public static ApplicationInfo get(Context context) {
        return UtilKContext.getApplicationInfo(context);
    }

    //////////////////////////////////////////////////////////////////////

    @IdRes
    public static int getLabelRes(Context context) {
        return get(context).labelRes;
    }

    @SuppressLint("ResourceType")
    public static String getLabelResStr(Context context) {
        try {
            int intResStr = getLabelRes(context);
            if (intResStr == 0) return "";
            return UtilKRes.getString_ofContext(context, intResStr);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
