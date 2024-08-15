package com.mozhimen.utilk.android.java;

import android.content.Context;
import android.net.Uri;

import com.mozhimen.utilk.android.java.io.UtilKFileFormat;
import com.mozhimen.utilk.android.java.io.UtilKFileWrapper;

import java.io.File;

/**
 * @ClassName UtilKStrFile
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKStrFile {
    public static Uri strFilePath2uri(Context context, String strFilePathName) {
        return UtilKFileFormat.file2uri(context, strFilePath2file(strFilePathName));
    }

    public static String getStrFolderPath(String folderPath) {
        if (!folderPath.endsWith("/"))
            return folderPath + "/";
        else return folderPath;
    }

    public static boolean isFile(String strFilePathName) {
        return UtilKFileWrapper.isFile(strFilePath2file(strFilePathName));
    }

    public static File strFilePath2file(String strFilePathNameDest) {
        return new File(strFilePathNameDest);
    }

    public static File createFile(String strFilePathName) throws Exception {
        return createFile(com.mozhimen.utilk.android.java.UtilKStrFile.strFilePath2file(strFilePathName));
    }

    //@ADescription(CIntent.FLAG_GRANT_READ_URI_PERMISSION.toString(), CIntent.FLAG_GRANT_WRITE_URI_PERMISSION.toString())
    public static Uri strFilePath2uri(String strFilePathName) {
        return file2uri(strFilePathName.strFilePath2file().)
    }

    public static File createFolder(String folderPath) {
        return createFolder(com.mozhimen.utilk.android.java.lang.UtilKStrFile.strFilePath2file(com.mozhimen.utilk.android.java.lang.UtilKStrFile.getStrFolderPath(folderPath)));
    }
}
