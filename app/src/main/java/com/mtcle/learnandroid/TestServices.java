package com.mtcle.learnandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 作者：Lenovo on 2019/3/17 14:13
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class TestServices extends Service {


    @Override
    public void onCreate() {
        super.onCreate();


    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
