package com.mozhimen.elemk.android.javax.net.bases;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * @ClassName BaseX509TrustManager
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/8/15 22:47
 * @Version 1.0
 */
@SuppressWarnings("CustomX509TrustManager")
public class BaseX509TrustManager implements X509TrustManager {


    @SuppressWarnings("TrustAllX509TrustManager")
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {

    }

    @SuppressWarnings("TrustAllX509TrustManager")
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[] {};
    }
}
