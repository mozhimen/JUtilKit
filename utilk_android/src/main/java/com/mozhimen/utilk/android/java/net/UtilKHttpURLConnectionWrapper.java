package com.mozhimen.utilk.android.java.net;

import static com.mozhimen.utilk.android.java.io.UtilKInputStreamFormat.inputStream2str_use_ofBufferedReader;

import android.util.Log;

import com.mozhimen.utilk.android.commons.IUtilK;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.Map;

/**
 * @ClassName UtilKHttpURLConnectionWrapper
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/8/15 23:35
 * @Version 1.0
 */
public class UtilKHttpURLConnectionWrapper implements IUtilK {
    public static String request_ofPost(String strUrl, Map<String, String> headers, Map<String, Object> params) {
        return request_ofPost(strUrl, headers, params, 1000, 1000);
    }

    public static String request_ofPost(String strUrl, Map<String, String> headers, Map<String, Object> params, int connectTimeout, int readTimeout) {
        HttpURLConnection httpURLConnection = null;
        JSONObject jsonObject = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            httpURLConnection = UtilKHttpURLConnection.get_ofTLS(strUrl, connectTimeout, readTimeout);
            httpURLConnection.setRequestMethod("POST");

            /*//            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8")// 设置通用请求类型
            //            httpURLConnection.setRequestProperty("Charset", "UTF-8")
            //            httpURLConnection.setRequestProperty("connection", "keep-alive")// 设置链接状态*/
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            if (params != null) {
                jsonObject = new JSONObject();
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    Object obj = entry.getValue();
                    if (obj instanceof Map<?, ?>) {
                        JSONObject jsonObject1 = new JSONObject();
                        for (Map.Entry<String, Object> entry1 : ((Map<String, Object>) obj).entrySet()) {
                            jsonObject1.put(entry1.getKey(), entry1.getValue());
                        }
                        jsonObject.put(entry.getKey(), jsonObject1);
                    } else {
                        jsonObject.put(entry.getKey(), obj);
                    }
                }
            }

            httpURLConnection.setDoOutput(true);// post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
            httpURLConnection.setDoInput(true);// 设置是否从httpUrlConnection读入，默认情况下是true;
            httpURLConnection.setUseCaches(false);// Post 请求不能使用缓存
//            httpURLConnection.instanceFollowRedirects = true// 设置本次连接是否自动处理重定向
            httpURLConnection.connect();

            if (jsonObject != null) {
                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(jsonObject.toString());
                outputStreamWriter.flush();
                outputStreamWriter.close();
                Log.d(TAG, "requestPost: " + jsonObject.toString());
            }

            InputStream inputStream;
            if (httpURLConnection.getResponseCode() == 200)
                inputStream = httpURLConnection.getInputStream();
            else
                inputStream = httpURLConnection.getErrorStream();
            return inputStream2str_use_ofBufferedReader(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "request_ofPost: ", e);
        } finally {
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, "request_ofPost: ", e);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();// 关闭相应的流
            }
        }
        return "";
    }
}
