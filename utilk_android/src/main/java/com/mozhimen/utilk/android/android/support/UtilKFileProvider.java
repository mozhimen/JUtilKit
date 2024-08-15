package com.mozhimen.utilk.android.android.support;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * @ClassName UtilKFileProvider
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKFileProvider {
    public static Uri getUriForFile(Context context, String authority, File file) {
        return FileProvider.getUriForFile(context, authority, file);
    }
}
