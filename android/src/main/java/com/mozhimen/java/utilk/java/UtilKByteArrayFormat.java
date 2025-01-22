package com.mozhimen.java.utilk.java;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.mozhimen.java.
utilk.commons.IUtilK;

import java.nio.charset.Charset;

/**
 * @ClassName UtilKByteArrayFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:10
 * @Version 1.0
 */
public class UtilKByteArrayFormat implements IUtilK {

    @SuppressLint("LongLogTag")
    public static Bitmap bytes2bitmapAny(byte[] bytes) {
        Log.d(TAG, "bytes2bitmapAny bytes size " + bytes.length);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    //////////////////////////////////////////////////////////////////////////////////

    public static String bytes2str(byte[] bytes, Charset charset) {
        return UtilKString.get(bytes, charset);
    }

    public static String bytes2str(byte[] bytes, int offset, int length) {
        return UtilKString.get(bytes, offset, length);
    }
}
