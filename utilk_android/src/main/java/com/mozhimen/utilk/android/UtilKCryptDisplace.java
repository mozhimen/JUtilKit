package com.mozhimen.utilk.android;

import android.graphics.Bitmap;
import android.util.Log;

/**
 * @ClassName UtilKCryptDisplace
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:48
 * @Version 1.0
 */
public class UtilKCryptDisplace {
    private static final String TAG = "UtilKCryptDisplace>>>>>";

    public static Bitmap decrypt2bitmap(String str) {
        byte[] bytes = com.mozhimen.utilk.java.UtilKCryptDisplace.decrypt2bytes(str);
        Log.d(TAG, "decrypt2bitmap: bytes " + bytes.length);
        try {
            return UtilKByteArrayFormat.bytes2bitmapAny(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
