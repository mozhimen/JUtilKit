package com.mozhimen.utilk.java.io;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.mozhimen.utilk.android.content.UtilKContext;
import com.mozhimen.utilk.java.io.UtilKFile;

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
public class UtilKFileFormat {
    private static final String TAG = "UtilKFileFormat>>>>>";

    public static Uri file2uri(Context context, File file) {
        if (!UtilKFile.isFileExist(file)) {
            Log.e(TAG, "file2Uri: file isFileExist false");
            return null;
        }
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(context, UtilKContext.getPackageName(context) + ".fileProvider", file);
            context.grantUriPermission(context.getPackageName(), uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }

    public static FileOutputStream file2fileOutputStream(File file, boolean isAppend) throws FileNotFoundException {
        return new FileOutputStream(file, isAppend);
    }
}
