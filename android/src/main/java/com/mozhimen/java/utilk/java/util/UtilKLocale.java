package com.mozhimen.java.utilk.java.util;

import android.util.Pair;

import java.util.Locale;

/**
 * @ClassName UtiKLocale
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/4
 * @Version 1.0
 */
public class UtilKLocale {
    private static final String TAG = "UtilKLocale>>>>>";

    //////////////////////////////////////////////////////////////////////////////////////
    //other
    //////////////////////////////////////////////////////////////////////////////////////

    public static Pair<String, String> getOSLang() {
        String language = Locale.getDefault().getLanguage();
//        Log.d(TAG, "getOSLang: language" + language);
        String languageTag = Locale.getDefault().toLanguageTag().replace("-Hant", "");
//        Log.d(TAG, "getOSLang: toLanguageTag " + languageTag);
        try {
            String[] tags = languageTag.split("-");
            String newTag = "";
            if (tags.length > 1) {
                newTag = "r" + tags[1];
            }
            languageTag = tags[0] + "-" + newTag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pair<String, String> pair = new Pair<>(language, languageTag);
//        Log.d(TAG, "getOSLang: language " + pair.first + " " + pair.second);
        return pair;
    }
}
