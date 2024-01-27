package com.mozhimen.utilk.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * @ClassName UtilKByteArrayFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:10
 * @Version 1.0
 */
public class UtilKByteArrayFormat {
    private static final String TAG = "UtilKByteArrayFormat>>>>>";

    @SuppressLint("LongLogTag")
    public static Bitmap bytes2bitmapAny(byte[] bytes) {
        Log.d(TAG, "bytes2bitmapAny bytes size " + bytes.length);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
