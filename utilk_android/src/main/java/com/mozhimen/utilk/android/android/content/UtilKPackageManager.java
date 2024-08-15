package com.mozhimen.utilk.android.android.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.mozhimen.utilk.android.android.os.UtilKBuildVersion;
import com.mozhimen.utilk.android.android.util.UtilKLogWrapper;
import com.mozhimen.utilk.android.commons.IUtilK;

/**
 * @ClassName UtilKPackageManager
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:36
 * @Version 1.0
 */
public class UtilKPackageManager implements IUtilK {
    public static PackageManager get(Context context) {
        return UtilKContext.getPackageManager(context);
    }

    public static PackageInfo getPackageInfo(Context context, String strPackageName, int flags) {
        try {
            return get(context).getPackageInfo(strPackageName, flags);
        } catch (Exception e) {
            e.printStackTrace();
            UtilKLogWrapper.e(TAG, "getPackageInfo: ", e);
            return null;
        }
    }
}
