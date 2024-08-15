package com.mozhimen.utilk.android.javax.net;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @ClassName UtilKSSLContext
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/28 16:19
 * @Version 1.0
 */
class UtilKSSLContext {
    public static SSLContext get_ofSSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[]{new com.mozhimen.elemk.android.javax.net.bases.BaseX509TrustManager()}, new SecureRandom());
        return sslContext;
    }

    public static SSLContext get_ofTLS() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new com.mozhimen.elemk.android.javax.net.bases.BaseX509TrustManager()}, new SecureRandom());
        return sslContext;
    }

    //////////////////////////////////////////////////////////////////////////////////

    public static SSLSocketFactory getSocketFactory_ofTLS() throws NoSuchAlgorithmException, KeyManagementException {
        return get_ofTLS().getSocketFactory();
    }

    public static SSLSocketFactory getSocketFactory_ofSSL() throws NoSuchAlgorithmException, KeyManagementException {
        return get_ofSSL().getSocketFactory();
    }
}