package com.mozhimen.java.utilk.wrapper;
import androidx.annotation.RequiresPermission;

import com.mozhimen.java.elemk.android.android.content.cons.CPermission;
import com.mozhimen.java.utilk.android.app.UtilKActivityStart;
import com.mozhimen.java.utilk.bases.BaseUtilK;
import java.io.File;

/**
 * @ClassName UtilKInstall
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:17
 * @Version 1.0
 */
public class UtilKInstall extends BaseUtilK {

    /**
     * 手动安装 if sdk >= 24 add provider
     */
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    public static boolean install_ofView(String strPathNameApk) {
        return UtilKActivityStart.startViewInstall(getContext(), strPathNameApk);
    }

    /**
     * 手动安装 if sdk >= 24 add provider
     */
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    public static void install_ofView(File fileApk) {
        UtilKActivityStart.startViewInstall(getContext(), fileApk);
    }
}
