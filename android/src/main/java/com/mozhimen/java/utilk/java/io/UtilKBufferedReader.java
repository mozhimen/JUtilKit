package com.mozhimen.java.utilk.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName UtilKBufferedReader
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/4
 * @Version 1.0
 */
public class UtilKBufferedReader {
    public static BufferedReader get(Reader reader, int bufferSize) {
        if (bufferSize == 0) return new BufferedReader(reader);
        else return new BufferedReader(reader, bufferSize);
    }

    //////////////////////////////////////////////////////////////

    public static String readLines_use(BufferedReader bufferedReader, boolean isAddLineBreak) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line = "";
            if (isAddLineBreak) {
                while ((line = bufferedReader.readLine()) != null)
                    stringBuilder.append(line).append("\n");
                return stringBuilder.toString()/*.replaceAfterLast("\n", "")*/;
            } else {
                while ((line = bufferedReader.readLine()) != null)
                    stringBuilder.append(line);/*.append("\n")*/
                return stringBuilder.toString();/*.replaceAfterLast("\n", "")*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        return "";
    }

    public static String readLine_use(BufferedReader bufferedReader) {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
