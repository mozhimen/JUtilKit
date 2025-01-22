package com.mozhimen.java.utilk.java.net;

import com.mozhimen.java.
elemk.android.javax.net.bases.BaseHostnameVerifier;
import com.mozhimen.java.
utilk.javax.net.UtilKSSLSocketFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HttpsURLConnection;

/**
 * @ClassName UtilKHttpURLConnection
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/8/15 23:37
 * @Version 1.0
 */
public class UtilKHttpURLConnection {
    public static HttpURLConnection get_ofTLS(String strUrl) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        return get_ofTLS(strUrl, 1000, 1000);
    }

    public static HttpURLConnection get_ofTLS(String strUrl, int connectTimeout, int readTimeout) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        URL uRL = UtilKURL.get(strUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRL.openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new BaseHostnameVerifier());
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(UtilKSSLSocketFactory.get_ofTLS());//获取SSLSocketFactory对象
        }
        httpURLConnection.setConnectTimeout(connectTimeout);
        httpURLConnection.setReadTimeout(readTimeout);
        return httpURLConnection;
    }
}
