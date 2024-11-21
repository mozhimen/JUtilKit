package com.mozhimen.java.elemk.android.android.content.cons;

import android.Manifest;

import androidx.annotation.RequiresApi;

import com.mozhimen.java.
elemk.android.android.os.cons.CVersCode;

/**
 * @ClassName CPermission
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/8/15 21:50
 * @Version 1.0
 */
public class CPermission {
    @RequiresApi(CVersCode.V_23_6_M)
    public final static String REQUEST_INSTALL_PACKAGES = Manifest.permission.REQUEST_INSTALL_PACKAGES;
    @RequiresApi(CVersCode.V_30_11_R)
    public final static String QUERY_ALL_PACKAGES = Manifest.permission.QUERY_ALL_PACKAGES;
}
