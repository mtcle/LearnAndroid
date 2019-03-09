package com.mtcle.customlib.common.utils;

import android.util.Log;

/**
 * 作者：Lenovo on 2019/3/9 16:22
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class MyCrashHandler implements Thread.UncaughtExceptionHandler {


    /**
     * 系统默认的 UncaughtException 处理类
     */
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public MyCrashHandler() {
        mDefaultHandler=Thread.getDefaultUncaughtExceptionHandler();
        // 设置该 CrashHandler 为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.d("MyCrashHandler", "全局异常捕获");
        //
        e.printStackTrace();
    }
}
