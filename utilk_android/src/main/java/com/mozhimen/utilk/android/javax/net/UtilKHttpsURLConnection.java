package com.mozhimen.utilk.android.javax.net;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

class UtilKHttpsURLConnection {

    public static HttpsURLConnection get(String strUrl, int connectTimeout, int readTimeout) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        URL uRL = new URL(strUrl);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRL.openConnection();
        httpsURLConnection.setHostnameVerifier(new BaseHostnameVerifier());
        httpsURLConnection.setSSLSocketFactory(UtilKSSLSocketFactory.get_ofSSL());//获取SSLSocketFactory对象
        httpsURLConnection.setConnectTimeout(connectTimeout); // 设置超时时间
        httpsURLConnection.setReadTimeout(readTimeout);
        return httpsURLConnection;
    }

    static class BaseHostnameVerifier implements HostnameVerifier {
        @SuppressWarnings("BadHostnameVerifier")
        @Override
        public boolean verify(String hostname, SSLSession session) {
//            UtilKLogWrapper.d(TAG, "verify: WARNING: Hostname is not matched for cert.")
            return true;
        }
    }

    public static HttpsURLConnection get(String strUrl) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        return get(strUrl, 10000, 10000);
    }


    public static void applyDefaultHostnameVerifier_SSLSocketFactory(HostnameVerifier hostnameVerifier, SSLSocketFactory sslSocketFactory) {
        HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
    }
}