package com.mozhimen.utilk.android;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @ClassName UtilKStrJson
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:41
 * @Version 1.0
 */
public class UtilKStrJson {
    public static JSONObject strJson2JSONObject(String strJson) throws JSONException {
        return new JSONObject(strJson);
    }
}
