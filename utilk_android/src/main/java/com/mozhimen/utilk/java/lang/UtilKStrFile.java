package com.mozhimen.utilk.java.lang;

import android.content.Context;
import android.net.Uri;

import com.mozhimen.utilk.java.io.UtilKFile;
import com.mozhimen.utilk.java.io.UtilKFileFormat;

import java.io.File;

/**
 * @ClassName UtilKStrFile
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:20
 * @Version 1.0
 */
public class UtilKStrFile {
    public static Uri strFilePath2uri(Context context, String strFilePathName) {
        return UtilKFileFormat.file2uri(context, com.mozhimen.utilk.java.lang.UtilKStrFile.strFilePath2file(strFilePathName));
    }

    public static String getStrFolderPath(String folderPath) {
        if (!folderPath.endsWith("/"))
            return folderPath + "/";
        else return folderPath;
    }

    public static boolean isFile(String strFilePathName) {
        return UtilKFile.isFile(strFilePath2file(strFilePathName));
    }

    public static File strFilePath2file(String strFilePathNameDest) {
        return new File(strFilePathNameDest);
    }

}
