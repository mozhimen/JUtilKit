package com.mozhimen.utilk.java.io;

import com.mozhimen.utilk.java.io.UtilKFile;
import com.mozhimen.utilk.java.io.UtilKFileFormat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName UtilKInputStreamFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:44
 * @Version 1.0
 */
public class UtilKInputStreamFormat {
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
        return inputStream2file(inputStream, UtilKFile.createFile(strFilePathNameDest), isAppend, bufferSize);
    }

    public static File inputStream2file(InputStream inputStream, File fileDest, boolean isAppend, int bufferSize) throws Exception {
        UtilKFile.createFile(fileDest);
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

    public static void inputStream2outputStream(InputStream inputStream, OutputStream outputStream, int bufferSize) throws IOException {
        try {
            byte[] bytes = new byte[bufferSize];
            int readCount;
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
