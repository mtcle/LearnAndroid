package com.mtcle.learnandroid.day324.thread;

/**
 * 作者：Lenovo on 2019/3/20 18:07
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class ThreadLearnActivity {


    private static Integer totalSize = 0;

    public static void main(String[] a) {
        thread1Test();
        thread2Test();
    }

    private static void thread1Test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始1线程操作.....");
                while (true){
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
                while (true){
                    doSomeThingCoastTime("线程2");
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


    private  static void doSomeThingCoastTime(String name) {
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
}
