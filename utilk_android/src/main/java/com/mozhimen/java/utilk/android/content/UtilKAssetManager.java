package com.mozhimen.java.utilk.android.content;

import android.content.Context;

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
    public static InputStream open_ofCxt(Context context, String strAssetName) throws IOException {
        return context.getAssets().open(strAssetName);
    }
}
