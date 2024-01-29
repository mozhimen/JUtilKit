package com.mozhimen.utilk.java.lang;

import android.content.Context;
import android.net.Uri;

import com.mozhimen.utilk.java.io.UtilKFileFormat;

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


}
