package com.mozhimen.java.utilk.android.os;
import android.os.Process;

/**
 * @ClassName UtilKProcess
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKProcess {
    public static int getMyPid() {
        return Process.myPid();
    }

    public static void killProcess(int intPid) {
        Process.killProcess(intPid);
    }

    public static void killProcess_ofMyPid() {
        killProcess(getMyPid());
    }
}
