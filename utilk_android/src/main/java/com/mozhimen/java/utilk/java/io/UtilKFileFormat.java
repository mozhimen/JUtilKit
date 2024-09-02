package com.mozhimen.java.utilk.java.io;

import android.net.Uri;

import com.mozhimen.java.utilk.android.content.UtilKContext;
import com.mozhimen.java.utilk.android.os.UtilKBuildVersion;
import com.mozhimen.java.utilk.android.support.UtilKFileProvider;
import com.mozhimen.java.utilk.android.util.UtilKLogWrapper;
import com.mozhimen.java.utilk.bases.BaseUtilK;
import com.mozhimen.java.elemk.android.android.content.cons.CIntent;
import com.mozhimen.java.utilk.wrapper.UtilKPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName UtilKFileFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:21
 * @Version 1.0
 */
public class UtilKFileFormat extends BaseUtilK {

    //    @ADescription(CIntent.FLAG_GRANT_READ_URI_PERMISSION.toString(), CIntent.FLAG_GRANT_WRITE_URI_PERMISSION.toString())
    public static Uri file2uri(File file) {
        if (!UtilKFileWrapper.isFileExist(file)) {
            UtilKLogWrapper.e(TAG, "file2Uri: file isFileExist false");
            return null;
        }
        Uri uri;
        if (UtilKBuildVersion.isAfterV_24_7_N()) {
            String authority = UtilKPackage.getPackageName() + ".fileProvider";
            UtilKLogWrapper.d(TAG, "file2Uri: authority " + authority);
            uri = UtilKFileProvider.getUriForFile(getContext(), authority, file);
            UtilKContext.grantUriPermission(getContext(), uri, CIntent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public static FileOutputStream file2fileOutputStream(File file) throws FileNotFoundException {
        return file2fileOutputStream(file, false);
    }

    public static FileOutputStream file2fileOutputStream(File file, boolean isAppend) throws FileNotFoundException {
        return UtilKFileOutputStream.get(file, isAppend);
    }
}
