package com.mozhimen.utilk.javax.net;

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
        sslContext.init(null, new TrustManager[]{new BaseX509TrustManager()}, new SecureRandom());
        return sslContext;
    }

    @SuppressWarnings("CustomX509TrustManager")
    static class BaseX509TrustManager implements X509TrustManager {


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


    //////////////////////////////////////////////////////////////////////////////////

    public static SSLSocketFactory getSocketFactory_ofSSL() throws NoSuchAlgorithmException, KeyManagementException {
        return get_ofSSL().getSocketFactory();
    }
}