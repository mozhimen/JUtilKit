package com.mozhimen.java.elemk.android.android.content.cons;

import android.content.Intent;

/**
 * @ClassName CIntent
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class CIntent {
    public final static int FLAG_GRANT_READ_URI_PERMISSION = Intent.FLAG_GRANT_READ_URI_PERMISSION;
    public final static String ACTION_VIEW = Intent.ACTION_VIEW;
    public final static String ACTION_MAIN = Intent.ACTION_MAIN;

    //////////////////////////////////////////////////////////////////////////

    public final static String CATEGORY_LAUNCHER = Intent.CATEGORY_LAUNCHER;

    /**
     * 当设置此标致，并且acitivity已经启动，那么不是启动一个新的activity，所有其他顶部的activity都会关闭，这个intent将被交付到（现在顶部）老的activity 做为新的intent。如果一个task由A,B,C,D组成，如果D调用startActivity（），跳到B, 然后C,D被finish掉，B接收新的intent ，结束栈中：A,B.现在运行的B的实例或者在onNewIntent方法中接收你start的新intent，或者自己finish掉然后重启一个新的intent。如果声明启动了启动模式是“multiple”(默认)，并且你没有在这个intent中设置FLAG_ACTIVITY_SINGLE_TOP，就会finish掉然后重新创建。其他的启动模式。或者FLAG_ACTIVITY_SINGLE_TOP被设置了，intent将会传送到当前实例的onNewIntent方法中。这个启动模式也可以跟FLAG_ACTIVITY_NEW_TASK结合使用：如果用来start根activity，它将会在此task任务当前正在执行的实例bring to foreground，然后清除到跟状态。比如，当从notification manager启动一个activity。
     */
    public final static int FLAG_ACTIVITY_CLEAR_TOP = Intent.FLAG_ACTIVITY_CLEAR_TOP;

    /**
     * 如果在通过Context.startActivity()启动activity时为Intent设置了此标识，这个标识将导致：任何与此activity相关联的task都会被清除。也就是说， 此activity将变成一个空栈中新的最底端的activity，所有的旧activity都会被finish掉，这个标识仅仅和FLAG_ACTIVITY_NEW_TASK联合起来才能使用
     */
    public final static int FLAG_ACTIVITY_CLEAR_TASK = Intent.FLAG_ACTIVITY_CLEAR_TASK;
}
