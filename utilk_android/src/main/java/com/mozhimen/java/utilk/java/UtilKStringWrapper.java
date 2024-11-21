package com.mozhimen.java.utilk.java;

import com.mozhimen.java.
utilk.java.collections.UtilK_Collections;

import java.util.Collection;

/**
 * @ClassName UtilKString
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKStringWrapper {
    /**
     * 获取分割后的最后一个元素
     */
    public static String getSplitLastIndexToEnd(String str, String splitStr) {
        return str.substring(str.lastIndexOf(splitStr) + 1, str.length());
    }

    public static String getSplitLastIndexToStart(String str, String splitStr) {
        return getSplitLastIndexToStart(str, splitStr, true);
    }

    /**
     * 获取分割后的最后一个元素的互斥集合
     */
    public static String getSplitLastIndexToStart(String str, String splitStr, boolean isContainSplitStr) {
        if (isContainSplitStr)
            return str.substring(0, str.lastIndexOf(splitStr) + 1);
        else {
            int index = str.lastIndexOf(splitStr);
            if (index >= 0) return str.substring(0, index);
            else return str;
        }
    }

    /**
     * 获取分割后的第一个元素
     */
    public static String getSplitFirstIndexToStart(String str, String splitStr) {
        int index = str.indexOf(splitStr);
        if (index >= 0) return str.substring(0, index);
        else return str;
    }

    public static String getSplitFirstIndexToEnd(String str, String splitStr) {
        int index = str.indexOf(splitStr);
        if (index >= 0) return str.substring(index + 1, str.length());
        else return str;
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * 是否含有空格
     */
    public static boolean hasSpace(String str) {
        int i = 0;
        int len = str.length();
        while (i < len) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
            ++i;
        }
        return true;
    }

    public static boolean containStr(String strContent, String str) {
        if (strContent.isEmpty() || str.isEmpty()) return false;
        return strContent.contains(str);
    }

    public static boolean containsAny(String strContent, Collection<String> strs) {
        return UtilK_Collections.any(strs, it -> containStr(strContent, it));
    }
}
