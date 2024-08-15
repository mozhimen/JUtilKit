package com.mozhimen.utilk.android.java.io;

import com.mozhimen.utilk.android.android.util.UtilKLogWrapper;
import com.mozhimen.utilk.android.commons.IUtilK;
import com.mozhimen.utilk.android.java.lang.UtilKStrFile;

import java.io.File;

/**
 * @ClassName UtilKFileWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKFileWrapper implements IUtilK {
    public static boolean isFile(File file) {
        return file.exists() && file.isFile();
    }

    public static boolean isFileExist(File file) {
        return isFile(file);
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
            UtilKLogWrapper.d(TAG, "createFile: file " + file.getAbsolutePath() + " " + res);
        } else {
            UtilKLogWrapper.d(TAG, "createFile: file is exits");
        }
        return file;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

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

    public static boolean isFolderExist(File folder) {
        return isFolder(folder);
    }

    public static boolean isFolder(File folder) {
        return folder.exists() && folder.isDirectory();
    }
}
