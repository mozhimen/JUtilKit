package com.mozhimen.java.utilk.java.io;

import com.mozhimen.java.utilk.android.util.UtilKLogWrapper;
import com.mozhimen.java.utilk.commons.IUtilK;
import com.mozhimen.java.utilk.java.UtilKStrFile;

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

    public static boolean createFile(File file) throws Exception {
        String parent = file.getParent();
        if (parent != null) {
            UtilKStrFile.createFolder(parent);
        } else {
            throw new Exception("don't have parent folder");
        }
        if (!isFileExist(file)) {
            try {

                boolean res = file.createNewFile();
                UtilKLogWrapper.d(TAG, "createFile: file " + file.getAbsolutePath() + " " + res);
            } catch (Exception e) {
                e.printStackTrace();
                UtilKLogWrapper.e(TAG, "createFile: file " + file.getAbsolutePath() + " fail");
            }
        } else {
            UtilKLogWrapper.d(TAG, "createFile: file is exits");
            return true;
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    public static boolean createFolder(File folder) {
        if (isFolderExist(folder)) {
            return true;
        } else {
            boolean res = folder.mkdirs();
            UtilKLogWrapper.d(TAG, "createFolder: create path " + folder.getAbsolutePath() + " " + res);
            return res;
        }
    }

    public static boolean isFolderExist(File folder) {
        return isFolder(folder);
    }

    public static boolean isFolder(File folder) {
        return folder.exists() && folder.isDirectory();
    }
}
