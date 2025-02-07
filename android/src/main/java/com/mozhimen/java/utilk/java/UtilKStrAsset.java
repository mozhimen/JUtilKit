package com.mozhimen.java.utilk.java;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.mozhimen.java.elemk.java.functions.IAB_CListener;
import com.mozhimen.java.
        utilk.android.content.UtilKAssetManager;
import com.mozhimen.java.
        utilk.android.util.UtilKLogWrapper;
import com.mozhimen.java.
        utilk.bases.BaseUtilK;
import com.mozhimen.java.
        utilk.java.io.UtilKInputStreamFormat;
import com.mozhimen.java.
        utilk.javax.crypto.UtilKCryptoDisplace;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import kotlin.text.Charsets;

/**
 * @ClassName UtilKStrAsset
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:37
 * @Version 1.0
 */
public class UtilKStrAsset extends BaseUtilK {
    public static String getStrAssetName(String strAssetName) {
        if (UtilKStringWrapper.containStr(strAssetName, "/"))
            return UtilKStringWrapper.getSplitLastIndexToEnd(strAssetName, "/");
        else return "";
    }


    public static String getStrFilePathName(String strAssetName, String strFilePathNameDest) {
        if (strFilePathNameDest.endsWith("/")) return strFilePathNameDest + strAssetName;
        else return strFilePathNameDest;
    }


    public static String getStrAssetParentPath(String strAssetName) {
        if (UtilKStringWrapper.containStr(strAssetName, "/"))
            return UtilKStringWrapper.getSplitLastIndexToStart(strAssetName, "/");
        else return "";
    }

    ///////////////////////////////////////////////////////////////////

    public static Boolean isAssetExists(String strAssetName) throws IOException {
        String parentPath = getStrAssetParentPath(strAssetName);
        UtilKLogWrapper.d(TAG, "isAssetExists: parentPath $parentPath");
        String[] assets = UtilKAssetManager.list(getContext(), parentPath);
        if (assets == null) {
            UtilKLogWrapper.d(TAG, "isAssetExists: assets null");
            return false;
        }
        for (String asset : assets) {
            if ((parentPath + asset).equals(strAssetName)) {
                UtilKLogWrapper.d(TAG, "isAssetExists: true");
                return true;
            }
        }
        UtilKLogWrapper.d(TAG, "isAssetExists: false");
        return false;
    }

    ///////////////////////////////////////////////////////////////////

    public static Bitmap strAssetName2bitmapOfDecryptDisplace(Context context, String strAssetName) {
        Bitmap strLogo = null;
        try {
            String str = strAssetName2str_use_ofBytes(strAssetName/*"rolling_hahalala_sing_a_song.txt"*/);
            Log.d(TAG, "strAssetName2bitmapOfDecryptDisplace: " + str.length());
            strLogo = UtilKCryptoDisplace.decrypt2bitmap(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strLogo;
    }


    ///////////////////////////////////////////////////////////////////

    public static byte[] strAssetName2bytes_use(String strAssetName) throws Exception {
        return UtilKInputStreamFormat.inputStream2bytes_use(UtilKAssetManager.open(getContext(), strAssetName));
    }

    ///////////////////////////////////////////////////////////////////

    /**
     * 文件转String:分析json文件,从资产文件加载内容:license,获取txt文本文件内容等
     */
    public static String strAssetName2str_use_ofBufferedReader(String strAssetName) throws IOException {
        if (!isAssetExists(strAssetName)) return null;
        else
            return UtilKInputStreamFormat.inputStream2str_use_ofBufferedReader(UtilKAssetManager.open(getContext(), strAssetName), null, 1024, false);
    }

    /**
     * 获取文本文件内容: txt 最快的方法
     */
    public static String strAssetName2str_use_ofBytes(String strAssetName) throws Exception {
        if (!isAssetExists(strAssetName)) return null;
        else
            return UtilKByteArrayFormat.bytes2str(strAssetName2bytes_use(strAssetName), Charsets.UTF_8);
    }

    /**
     * 通过路径加载Assets中的文本内容
     */
    public static String strAssetName2str_use_ofStream(String strAssetName) throws IOException {
        if (!isAssetExists(strAssetName)) return null;
        else
            return UtilKInputStreamFormat.inputStream2str_use_ofBytes(UtilKAssetManager.open(getContext(), strAssetName));
    }

    ///////////////////////////////////////////////////////////////////

    public static File strAssetName2file_use(String strAssetName, File fileDest, boolean isAppend, int bufferSize, IAB_CListener<Integer, Float, Void> block) throws Exception {
        if (!isAssetExists(strAssetName)) {
            UtilKLogWrapper.d(TAG, "strAssetName2file: dont exist");
            return null;
        } else
            return UtilKInputStreamFormat.inputStream2file_use(UtilKAssetManager.open(getContext(), strAssetName), fileDest, isAppend, bufferSize, block);
    }

    public static File strAssetName2file_use(String strAssetName, String strFilePathNameDest, boolean isAppend, int bufferSize, IAB_CListener<Integer, Float, Void> block) throws Exception {
        if (!isAssetExists(strAssetName)) {
            UtilKLogWrapper.d(TAG, "strAssetName2file: dont exist");
            return null;
        } else
            return UtilKInputStreamFormat.inputStream2file_use(UtilKAssetManager.open(getContext(), strAssetName), getStrFilePathName(strAssetName, strFilePathNameDest), isAppend, bufferSize, block);
    }

    ///////////////////////////////////////////////////////////////////

    public static Bitmap strAssetName2bitmap_use(String strAssetName) throws IOException {
        if (!isAssetExists(strAssetName)) {
            UtilKLogWrapper.e(TAG, "strAssetName2bitmap: no such file");
            return null;
        } else
            return UtilKInputStreamFormat.inputStream2bitmapAny_use(UtilKAssetManager.open(getContext(), strAssetName));
    }
}
