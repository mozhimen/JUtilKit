package com.mozhimen.utilk.android.content;

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
    public static InputStream open(Context context, String strAssetName) throws IOException {
        return context.getAssets().open(strAssetName);
    }
}
