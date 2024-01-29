package com.mozhimen.utilk.java.lang;

import com.mozhimen.utilk.java.io.UtilKFile;

import java.io.File;

/**
 * @ClassName UtilKStrFile
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:19
 * @Version 1.0
 */
public class UtilKStrFile {
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
