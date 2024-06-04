package com.mozhimen.utilk.java.io;

import com.mozhimen.utilk.java.lang.UtilKStrFile;

import java.io.File;

/**
 * @ClassName UtilKFile
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:31
 * @Version 1.0
 */
public class UtilKFile {
    public static File createFile(String strFilePathName) throws Exception {
        return createFile(UtilKStrFile.strFilePath2file(strFilePathName));
    }

    public static File createFile(File file) throws Exception {
        String parent = file.getParent();
        if (parent != null) {
            createFolder(parent);
        } else {
            throw new Exception("don't have parent folder");
        }
        if (!isFileExist(file)) {
            boolean res = file.createNewFile();
//            Log.d(TAG, "createFile: file " + file.getAbsolutePath() + " " + res);
        } else {
//            Log.d(TAG, "createFile: file is exits");
        }
        return file;
    }

    public static File createFolder(String folderPath) {
        return createFolder(UtilKStrFile.strFilePath2file(UtilKStrFile.getStrFolderPath(folderPath)));
    }

    public static File createFolder(File folder) {
        if (!isFolderExist(folder)) {
            boolean res = folder.mkdirs();
            //Log.d(TAG, "createFolder: create path " + folder.getAbsolutePath() + " " + res);
        }
        return folder;
    }

    public static boolean isFileExist(File file) {
        return isFile(file);
    }

    public static boolean isFile(File file) {
        return file.exists() && file.isFile();
    }

    public static boolean isFolderExist(File folder) {
        return isFolder(folder);
    }

    public static boolean isFolder(File folder) {
        return folder.exists() && folder.isDirectory();
    }
}
