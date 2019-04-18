package com.mtcle.learnandroid.day324.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.mtcle.customlib.common.CommonAcitivty;
import com.mtcle.learnandroid.R;

/**
 * 作者：Lenovo on 2019/3/20 18:07
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class ThreadLearnActivity extends CommonAcitivty {

    private TextView tvShow;

    private Handler myHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            System.out.println("主线程收到消息，刷新界面");
            tvShow.setText("当前数据：" + msg.obj);
            return true;
        }
    });

    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_thread;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvShow = findViewById(R.id.tv_show);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalSize = 0;
                doSomeThingCoastTimeAndroid("线程0");
            }
        });


        findViewById(R.id.btn_task_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask asyncTask = new MyAsyncTask();
                asyncTask.execute("我是参数");
            }
        });
    }

    private static Integer totalSize = 0;


    private void doSomeThingCoastTimeAndroid(final String name) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (totalSize < 30) {
                    try {
                        Thread.sleep(1000);//模拟耗时操作
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ++totalSize;
                    Message message = myHandler.obtainMessage();
                    message.obj = String.valueOf(totalSize);
                    myHandler.sendMessage(message);
                    System.out.println(name + "当前size：" + totalSize);
                }
            }
        }).start();
    }



    public static void main(String[] a) {
        thread1Test();
        thread2Test();
    }


    private static void thread1Test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始1线程操作.....");
                while (true) {
                    doSomeThingCoastTime("线程1");
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void thread2Test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始线程2操作.....");
                while (true) {
                    doSomeThingCoastTime("线程2");
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


    private static /*synchronized*/ void doSomeThingCoastTime(String name) {

        if (totalSize < 30) {
            try {
                Thread.sleep(500);//模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++totalSize;
            System.out.println(name + "当前size：" + totalSize);
        }
    }


    class MyAsyncTask extends AsyncTask<String, Integer, String> {


        @Override
        protected String doInBackground(String... strings) {
            while (totalSize < 30) {
                try {
                    Thread.sleep(500);//模拟耗时操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ++totalSize;
                publishProgress(totalSize);
                System.out.println("当前size：" + totalSize);
            }
            return "我执行完毕" + totalSize;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvShow.setText("当前执行进度：" + values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvShow.setText("结果：" + s);
        }
    }


}
