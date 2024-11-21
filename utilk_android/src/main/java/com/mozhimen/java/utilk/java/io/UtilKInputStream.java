package com.mozhimen.java.utilk.java.io;

import android.annotation.SuppressLint;
import android.util.Log;

import com.mozhimen.java.
elemk.java.functions.Function2;
import com.mozhimen.java.
utilk.android.util.UtilKLogWrapper;
import com.mozhimen.java.
utilk.commons.IUtilK;
import com.mozhimen.java.
utilk.java.ranges.UtilK_Ranges;

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
public class UtilKInputStream implements IUtilK {

    public static int read_use(InputStream inputStream, byte[] bytes) throws IOException {
        try {
            return inputStream.read(bytes);
        } finally {
            inputStream.close();
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    public static void read_write_use(InputStream inputStream, OutputStream outputStream, int bufferSize, Function2<Integer, Float, Void> block) throws IOException {
        try {
            byte[] bytes = new byte[bufferSize];
            long totalCount = inputStream.available();
            int readCount;
            int offset = 0;
            float percent;
            UtilKLogWrapper.d(TAG, "read_write_use: totalCount $totalCount");
            while ((readCount = inputStream.read(bytes)) != -1) {
                offset += readCount;
                outputStream.write(bytes, 0, readCount);
                percent = UtilK_Ranges.constraint(((float) offset / (float) totalCount), 0f, 1f);
                //UtilKLogWrapper.d(TAG, "inputStream2outputStream: offset $offset total $totalCount percent $percent")
                if (block != null) {
                    block.invoke(readCount, percent);
                }
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
