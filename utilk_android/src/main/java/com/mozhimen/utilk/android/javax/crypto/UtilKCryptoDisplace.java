package com.mozhimen.utilk.android.javax.crypto;

import android.graphics.Bitmap;
import android.util.Log;

import com.mozhimen.utilk.android.java.UtilKByteArrayFormat;

/**
 * @ClassName UtilKCryptDisplace
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:48
 * @Version 1.0
 */
public class UtilKCryptoDisplace {
    private static final String TAG = "UtilKCryptDisplace>>>>>";

    public static Bitmap decrypt2bitmap(String str) {
        byte[] bytes = UtilKCryptoDisplace.decrypt2bytes(str);
        Log.d(TAG, "decrypt2bitmap: bytes " + bytes.length);
        try {
            return UtilKByteArrayFormat.bytes2bitmapAny(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decrypt2bytes(String str) {
        String decryption = decrypt(str);
        char[] chars = decryption.toCharArray();
        byte[] bytes = new byte[chars.length];
        for (int i = 0; i < chars.length; i++) {
            bytes[i] = (byte) chars[i];
        }
        return bytes;
    }

    public static String decrypt(String str) {
        char[] tempChars = str.toCharArray();
        for (int i = 0; i < tempChars.length; i++) {
            if (i % 10 == 0) {
                tempChars[i] = decrypt(String.valueOf(tempChars[i]), 5).charAt(0);
            }
        }
        return new String(tempChars);
    }

    public static String decrypt(String str, int k) {
        String cipher = "";
        /*密钥转换
        如果密文是向前移位，解密时就向后移位
        如果密文是向后移位，解密时就向前移位
         */
        k = 0 - k;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 小写字母的转换
            if (c >= 'a' && c <= 'z') {
                c += k % 26;
                //  向左超界
                if (c < 'a') c += 26;
                //向右超界
                if (c > 'z') c -= 26;
            } else if (c >= 'A' && c <= 'Z') {//    大写字母的转换
                c += k % 26;
                //  向左超界
                if (c < 'A') c += 26;
                //  向右超界
                if (c > 'Z') c -= 26;
            } else if (c >= '0' && c <= '9') {//    数字的转换
                c += k % 10;
                //  向左超界
                if (c < '0') c += 10;
                //  向右超界
                if (c > '9') c -= 10;

            }
            //将解密后的字符连成字符串
            cipher += c;
        }
        return cipher;
    }
}
