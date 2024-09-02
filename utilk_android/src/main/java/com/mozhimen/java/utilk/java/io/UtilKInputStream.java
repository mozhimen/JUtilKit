package com.mozhimen.java.utilk.java.io;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName UtilKInputStrream
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/2
 * @Version 1.0
 */
public class UtilKInputStream {
    private static final String TAG = "UtilKInputStream>>>>>";

    @SuppressLint("LongLogTag")
    public static void read_write_use(InputStream inputStream, OutputStream outputStream, int bufferSize) throws IOException {
        try {
            int readCount;
            byte[] bytes = new byte[bufferSize];
            while ((readCount = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, readCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        }
    }
}
