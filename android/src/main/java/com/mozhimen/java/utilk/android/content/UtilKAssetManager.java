package com.mozhimen.java.utilk.android.content;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.AssetFileDescriptor;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName AssetManagerUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/25
 * @Version 1.0
 */
public class UtilKAssetManager {
    public static AssetManager get_ofContext(Context context) {
        return UtilKContext.getAssets(context);
    }

    public static AssetManager get_ofResources(Context context) {
        return UtilKResources.getAssets_ofApp(context);//===get_ofContext
    }

    //////////////////////////////////////////////////////////////////////////////

    public static InputStream open(Context context, String strAssetName) throws IOException {
        return get_ofContext(context).open(strAssetName);
    }

    public static AssetFileDescriptor openFd(Context context, String strAssetName) throws IOException {
        return get_ofContext(context).openFd(strAssetName);
    }

    public static String[] list(Context context, String strAssetName) throws IOException {
        return get_ofContext(context).list(strAssetName);
    }
}
