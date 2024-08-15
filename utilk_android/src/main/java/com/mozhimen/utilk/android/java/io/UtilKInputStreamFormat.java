package com.mozhimen.utilk.android.java.io;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.mozhimen.utilk.android.java.UtilKStrFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName UtilKInputStream
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:08
 * @Version 1.0
 */
public class UtilKInputStreamFormat {
    private static final String TAG = "UtilKInputStreamFormat>>>>>";

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

    @SuppressLint("LongLogTag")
    public static void inputStream2outputStream(InputStream inputStream, OutputStream outputStream, int bufferSize) throws IOException {
        try {
            byte[] bytes = new byte[bufferSize];
            int readCount;
            Log.d(TAG, "inputStream2outputStream: totalCount $totalCount");
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

    public static String inputStream2str_use_ofBufferedReader(InputStream inputStream) throws IOException {
        return inputStream2str_use_ofBufferedReader(inputStream, null, 1024);
    }

    public static String inputStream2str_use_ofBufferedReader(InputStream inputStream, String charset, int bufferSize) throws IOException {
        return UtilKInputStreamReader.readLines_use(inputStream, charset, bufferSize);
    }

    public static String inputStream2str(InputStream inputStream) throws Exception {
        return new String(inputStream2bytes(inputStream), StandardCharsets.UTF_8);
    }

    public static byte[] inputStream2bytes(InputStream inputStream) throws Exception {
        int len = inputStream.available();
        byte[] bytes = new byte[(int) len];
        try {
            int readLength = inputStream.read(bytes);
            if ((long) readLength < len) {
                throw new IOException(String.format("File length is [{}] but read [{}]!", new Object[]{len, readLength}));
            }
        } catch (Exception var10) {
            throw new Exception(var10);
        } finally {
            inputStream.close();
        }
        return bytes;
    }

    public static File inputStream2file(InputStream inputStream, String strFilePathNameDest, boolean isAppend, int bufferSize) throws Exception {
        File file = UtilKStrFile.strFilePath2file(strFilePathNameDest);
        UtilKStrFile.createFile(strFilePathNameDest);
        return inputStream2file(inputStream, file, isAppend, bufferSize);
    }

    public static File inputStream2file(InputStream inputStream, File fileDest, boolean isAppend, int bufferSize) throws Exception {
        UtilKFileWrapper.createFile(fileDest);
        /*//        val fileInputStream = file.file2fileInputStream()
        //        Log.d(TAG, "inputStream2file: inputStream ${inputStream.available()}")
        //        if (isInputStreamSame(inputStream, fileInputStream)) {//相似内容就直接返回地址
        //            Log.d(TAG, "assetCopyFile: the two files is same")
        //            return file//"the two files is same, don't need overwrite"
        //        }*/
        try {
            inputStream2outputStream(inputStream, UtilKFileFormat.file2fileOutputStream(fileDest, isAppend), bufferSize);
            return fileDest;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
