package com.mozhimen.utilk.android.wrapper;

import android.content.Context;
import android.support.annotation.StringRes;
import com.mozhimen.utilk.android.android.content.UtilKContext;
/**
 * @ClassName UtilKRes
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/8/15 23:24
 * @Version 1.0
 */
public class UtilKRes {
    public static String getString_ofContext(Context context, @StringRes int intResStr) {
        return UtilKContext.getString(context, intResStr);
    }
}
