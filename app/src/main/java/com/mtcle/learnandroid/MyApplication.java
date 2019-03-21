package com.mtcle.learnandroid;

import android.app.Application;

import com.okhttplib.OkHttpUtil;

/**
 * 作者：Lenovo on 2019/3/9 16:25
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
//        MyCrashHandler myCrashHandler=new MyCrashHandler();
        OkHttpUtil.init(this);


    }
}
