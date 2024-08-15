package com.mozhimen.elemk.android.javax.net.bases;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mozhimen.utilk.android.commons.IUtilK;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @ClassName BaseHostnameVerifier
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/1
 * @Version 1.0
 */
public class BaseHostnameVerifier implements HostnameVerifier, IUtilK {
    static Class<?> getClazz() {
        return BaseHostnameVerifier.class;
    }

    @SuppressLint("BadHostnameVerifier")
    @Override
    public boolean verify(String hostname, SSLSession session) {
        Log.d(TAG, "verify: WARNING: Hostname is not matched for cert.");
        return true;
    }
}
