package com.mozhimen.utilk.android.java.lang;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.mozhimen.utilk.android.android.content.UtilKAssetManager;
import com.mozhimen.utilk.android.java.io.UtilKInputStreamFormat;
import com.mozhimen.utilk.android.javax.crypto.UtilKCryptoDisplace;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName UtilKStrAsset
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:37
 * @Version 1.0
 */
public class UtilKStrAsset {
    private static final String TAG = "UtilKStrAsset>>>>>";

    public static String strAssetName2strFilePathName(String strAssetName, String strFilePathNameDest) {
        if (strFilePathNameDest.endsWith("/")) return strFilePathNameDest + strAssetName;
        else return strFilePathNameDest;
    }

    public static File strAssetName2file(Context context, String strAssetName, String strFilePathNameDest, boolean isAppend, int bufferSize) throws Exception {
        if (!isAssetExists(context, strAssetName)) return null;
        else
            return UtilKInputStreamFormat.inputStream2file(UtilKAssetManager.open_ofCxt(context, strAssetName), strAssetName2strFilePathName(strAssetName, strFilePathNameDest), isAppend, bufferSize);
    }

    public static Bitmap strAssetName2bitmapOfDecryptDisplace(Context context, String strAssetName) {
        Bitmap strLogo = null;
        try {
            String str = strAssetName2str(context, strAssetName/*"rolling_hahalala_sing_a_song.txt"*/);
            Log.d(TAG, "strAssetName2bitmapOfDecryptDisplace: " + str.length());
            strLogo = UtilKCryptoDisplace.decrypt2bitmap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strLogo;
    }

    public static Bitmap strAssetName2bitmap(Context context, String strAssetName) {
        try {
            if (!isAssetExists(context, strAssetName)) return null;
            else
                return UtilKInputStreamFormat.inputStream2bitmapAny(UtilKAssetManager.open_ofCxt(context, strAssetName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String strAssetName2str(Context context, String assetFileName) throws Exception {
        if (!isAssetExists(context, assetFileName)) return null;
        else
            return UtilKInputStreamFormat.inputStream2str(context.getResources().getAssets().open(assetFileName));
    }

    public static Boolean isAssetExists(Context context, String strAssetName) throws IOException {
        String[] assets = context.getResources().getAssets().list("");
        if (assets == null) return false;
        for (String asset : assets) {
            if (asset.equals(strAssetName)) return true;
        }
        return false;
    }
}
