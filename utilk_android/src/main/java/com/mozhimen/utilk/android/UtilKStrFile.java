package com.mozhimen.utilk.android;

import android.content.Context;
import android.net.Uri;

/**
 * @ClassName UtilKStrFile
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:20
 * @Version 1.0
 */
public class UtilKStrFile {
    public static Uri strFilePath2uri(Context context, String strFilePathName) {
        return UtilKFileFormat.file2uri(context, com.mozhimen.utilk.java.UtilKStrFile.strFilePath2file(strFilePathName));
    }


}
