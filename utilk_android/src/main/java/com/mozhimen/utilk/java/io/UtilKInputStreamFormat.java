package com.mozhimen.utilk.java.io;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName UtilKInputStream
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:08
 * @Version 1.0
 */
public class UtilKInputStreamFormat {
    public static Bitmap inputStream2bitmapAny(InputStream inputStream) {
        try {
            return BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
