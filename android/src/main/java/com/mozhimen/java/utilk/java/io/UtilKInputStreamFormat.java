package com.mozhimen.java.utilk.java.io;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.mozhimen.java.
elemk.java.functions.Function2;
import com.mozhimen.java.
utilk.commons.IUtilK;
import com.mozhimen.java.
utilk.java.UtilKByteArray;
import com.mozhimen.java.
utilk.java.UtilKByteArrayFormat;
import com.mozhimen.java.
utilk.java.UtilKStrFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


/**
 * @ClassName UtilKInputStream
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:08
 * @Version 1.0
 */
public class UtilKInputStreamFormat implements IUtilK {

    ////////////////////////////////////////////////////////////////////////////

    public static byte[] inputStream2bytes_use(InputStream inputStream) throws Exception {
        return inputStream2bytes_use(inputStream, false);
    }

    public static byte[] inputStream2bytes_use(InputStream inputStream, boolean isVerify) throws Exception {
        byte[] bytes = UtilKByteArray.get(inputStream);
        int available = inputStream.available();
        int readLength = UtilKInputStream.read_use(inputStream, bytes);
        if (isVerify && (long) readLength < available) {
            throw new IOException(String.format("File length is [{}] but read [{}]!", new Object[]{available, readLength}));
        }
        return bytes;
    }

    ////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////

    public static String inputStream2str_use_ofBufferedReader(InputStream inputStream, String charset, int bufferSize, boolean isAddLineBreak) throws IOException {
        return UtilKInputStreamReader.readLines_use(inputStream, charset, bufferSize, isAddLineBreak);
    }

    public static String inputStream2str_use_ofBytes(InputStream inputStream) throws IOException {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            int readCount;
            byte[] bytes = new byte[1024];
            while ((readCount = inputStream.read(bytes)) != -1)
                stringBuilder.append(UtilKByteArrayFormat.bytes2str(bytes, 0, readCount));
            return stringBuilder.toString();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////

    public static Bitmap inputStream2bitmapAny_use(InputStream inputStream) {
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

    ////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////

    public static File inputStream2file_use(InputStream inputStream, String strFilePathNameDest, boolean isAppend, int bufferSize, Function2<Integer, Float, Void> block) throws Exception {
        File file = UtilKStrFile.strFilePath2file(strFilePathNameDest);
        UtilKStrFile.createFile(strFilePathNameDest);
        return inputStream2file_use(inputStream, file, isAppend, bufferSize, block);
    }

    public static File inputStream2file_use(InputStream inputStream, File fileDest, boolean isAppend, int bufferSize, Function2<Integer, Float, Void> block) throws Exception {
        UtilKFileWrapper.createFile(fileDest);
        /*//        val fileInputStream = file.file2fileInputStream()
        //        Log.d(TAG, "inputStream2file: inputStream ${inputStream.available()}")
        //        if (isInputStreamSame(inputStream, fileInputStream)) {//相似内容就直接返回地址
        //            Log.d(TAG, "assetCopyFile: the two files is same")
        //            return file//"the two files is same, don't need overwrite"
        //        }*/
        try {
            UtilKInputStream.read_write_use(inputStream, UtilKFileFormat.file2fileOutputStream(fileDest, isAppend), bufferSize, block);
            return fileDest;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File inputStream2file_use_ofBufferedOutStream(
            InputStream inputStream,
            String strFilePathNameDest,
            boolean isAppend,
            int bufferSize,
            Function2<Integer, Float, Void> block
    ) throws Exception {
        File tempFile = UtilKStrFile.strFilePath2file(strFilePathNameDest);
        UtilKFileWrapper.createFile(tempFile);
        return inputStream2file_use_ofBufferedOutStream(inputStream, tempFile, isAppend, bufferSize, block);
    }

    public static File inputStream2file_use_ofBufferedOutStream(InputStream inputStream, File fileDest, boolean isAppend, int bufferSize, Function2<Integer, Float, Void> block) throws Exception {
        UtilKFileWrapper.createFile(fileDest);
        try {
            UtilKInputStream.read_write_use(inputStream,UtilKFileFormat.file2bufferedOutputStream(fileDest,isAppend), bufferSize, block);
            return fileDest;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
