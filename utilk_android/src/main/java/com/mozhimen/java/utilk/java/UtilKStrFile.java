package com.mozhimen.java.utilk.java;

import android.net.Uri;

import com.mozhimen.java.utilk.java.io.UtilKFileFormat;
import com.mozhimen.java.utilk.java.io.UtilKFileWrapper;

import java.io.File;

/**
 * @ClassName UtilKStrFile
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKStrFile {

    //region # file
    public static boolean isFile(String strFilePathName) {
        return UtilKFileWrapper.isFile(strFilePath2file(strFilePathName));
    }

    //    @ADescription(CIntent.FLAG_GRANT_READ_URI_PERMISSION.toString(), CIntent.FLAG_GRANT_WRITE_URI_PERMISSION.toString())
    public static Uri strFilePath2uri(String strFilePathName) {
        return UtilKFileFormat.file2uri(strFilePath2file(strFilePathName));
    }

    public static File strFilePath2file(String strFilePathNameDest) {
        return new File(strFilePathNameDest);
    }

    public static boolean createFile(String strFilePathName) throws Exception {
        return UtilKFileWrapper.createFile(strFilePath2file(strFilePathName));
    }
    //endregion

    /////////////////////////////////////////////////////////////////

    //region # folder
    public static String getStrFolderPath(String folderPath) {
        if (!folderPath.endsWith("/"))
            return folderPath + "/";
        else return folderPath;
    }

    public static boolean createFolder(String folderPath) {
        return UtilKFileWrapper.createFolder(strFilePath2file(getStrFolderPath(folderPath)));
    }
    //endregion
}
