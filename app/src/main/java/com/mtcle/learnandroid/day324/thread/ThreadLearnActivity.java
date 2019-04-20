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


//        HttpRequestAsyncTask httpRequestAsyncTask = new HttpRequestAsyncTask();
//        httpRequestAsyncTask.execute("我是参数");
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


    private void costTimeDel() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //1、调接口，耗时操作
                //.... 耗时3秒
                //操作结果
                result = "结果";


            }
        }).start();
    }

    public static void main(String[] a) {
        thread1Test();
        thread2Test();
    }

    String result;

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

//        costTimeDel();

        //刷新ui，result是没有值的
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


    class HttpRequestAsyncTask extends AsyncTask<String, Integer, Object> {

        //异步任务开始前调的方法，可以刷新ui
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //例如：显示loading框
        }

        //线程操作，无法刷新ui，结果返回
        @Override
        protected Object doInBackground(String... strings) {
            //耗时操作，例如网络请求，计算之类
            String result = "耗时操作得到的结果";
            publishProgress(50);//
            return result;
        }

        //耗时操作时，同步刷新ui使用的，例如下载进度条刷新
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //ui显示 下载进度等
            //得到下载进度50% 刷新progressbar
        }

        //得到耗时操作返回的结果，刷新ui
        @Override
        protected void onPostExecute(Object result) {
            super.onPostExecute(result);
            //耗时操作完成，返回结果
            //拿到结果刷新ui，赋值等

        }
    }



    class MyAsyncTask extends AsyncTask<String, Integer, String> {


        //耗时操作
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

        //进度
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvShow.setText("当前执行进度：" + values[0]);
        }

        //结果
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvShow.setText("结果：" + s);
        }
    }


}
