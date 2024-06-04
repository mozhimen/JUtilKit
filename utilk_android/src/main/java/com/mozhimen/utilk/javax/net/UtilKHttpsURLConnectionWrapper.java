package com.mozhimen.utilk.javax.net;

import android.annotation.SuppressLint;
import android.util.Log;

import com.mozhimen.utilk.java.io.UtilKInputStreamFormat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * @ClassName UtilKHttpsURLConnectionWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/4/9
 * @Version 1.0
 */
public class UtilKHttpsURLConnectionWrapper {
    private static final String TAG = "UtilKHttpsURLConnectionWrapper>>>>>";

    public static String requestPost(String strUrl, Map<String, String> headers, Map<String, String> params) throws NoSuchAlgorithmException, KeyManagementException, JSONException {
        return requestPost(strUrl, headers, params, 3000, 100000);
    }

    @SuppressLint("LongLogTag")
    public static String requestPost(String strUrl, Map<String, String> headers, Map<String, String> params, int connectTimeout, int readTimeout) throws NoSuchAlgorithmException, KeyManagementException, JSONException {
        HttpsURLConnection httpsURLConnection = null;
        JSONObject jsonObject = null;
        OutputStreamWriter outputStreamWriter;
        try {
            httpsURLConnection = UtilKHttpsURLConnection.get(strUrl, connectTimeout, readTimeout);
            httpsURLConnection.setRequestMethod("POST");
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            if (params != null) {
                jsonObject = new JSONObject();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    jsonObject.put(entry.getKey(), entry.getValue());
                }
            }
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.connect();

            if (jsonObject != null) {
                outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream(), StandardCharsets.UTF_8);
                outputStreamWriter.write(jsonObject.toString());
                outputStreamWriter.flush();
                outputStreamWriter.close();
                Log.d(TAG, "requestPost: "+jsonObject.toString());
            }

            InputStream inputStream;
            if (httpsURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
                inputStream = httpsURLConnection.getInputStream();
            else
                inputStream = httpsURLConnection.getErrorStream();
            return UtilKInputStreamFormat.inputStream2str_use_ofBufferedReader(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace(); // url格式错误
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
        }
        return "";
    }
}