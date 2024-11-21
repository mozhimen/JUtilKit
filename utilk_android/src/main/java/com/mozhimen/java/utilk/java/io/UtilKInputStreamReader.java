package com.mozhimen.java.utilk.java.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @ClassName UtilKInputStreamReader
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/4
 * @Version 1.0
 */
public class UtilKInputStreamReader {
    public static InputStreamReader get(InputStream inputStream, String charset) throws UnsupportedEncodingException {
        if (charset == null) return new InputStreamReader(inputStream);
        else return new InputStreamReader(inputStream, charset);
    }

    public static InputStreamReader get(InputStream inputStream, Charset charset) throws UnsupportedEncodingException {
        if (charset == null) return new InputStreamReader(inputStream);
        else return new InputStreamReader(inputStream, charset);
    }

    ///////////////////////////////////////////////////////////

    public static String readLines_use(InputStream inputStream, String charset, int bufferSize, boolean isAddLineBreak) throws IOException {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = get(inputStream, charset);
            return UtilKBufferedReader.readLines_use(UtilKBufferedReader.get(inputStreamReader, bufferSize), isAddLineBreak);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        }
        return "";
    }
}
