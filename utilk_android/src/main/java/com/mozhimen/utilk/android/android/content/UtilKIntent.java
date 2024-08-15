package com.mozhimen.utilk.android.android.content;

import android.content.Intent;

/**
 * @ClassName UtilKIntent
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/8/15 21:48
 * @Version 1.0
 */
public class UtilKIntent {
    public static Intent get() {
        return new Intent();
    }

    public static Intent get(String action) {
        return new Intent(action);
    }
}
