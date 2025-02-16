package com.mozhimen.java.utilk.android.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import androidx.annotation.RequiresPermission;

import com.mozhimen.java.
        elemk.android.android.content.cons.CPermission;
import com.mozhimen.java.
        utilk.android.util.UtilKLogWrapper;
import com.mozhimen.java.
        utilk.commons.IUtilK;

import java.util.List;

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

    public static PackageInfo getPackageInfo(Context context, String strPackageName, int flags) throws PackageManager.NameNotFoundException {
        return get(context).getPackageInfo(strPackageName, flags);
    }



    /////////////////////////////////////////////////////////////////////////////////

    /**
     * 查询所有的符合Intent的Activities
     */
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    @SuppressLint("QueryPermissionsNeeded")
    public static List<ResolveInfo> queryIntentActivities(Context context, Intent intent, int flags) {
        return get(context).queryIntentActivities(intent, flags);
    }

    /////////////////////////////////////////////////////////////////////////////////

    public static Intent getLaunchIntentForPackage(Context context, String strPackageName) {
        return get(context).getLaunchIntentForPackage(strPackageName);
    }
}
