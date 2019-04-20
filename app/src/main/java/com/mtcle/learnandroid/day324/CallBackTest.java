package com.mtcle.learnandroid.day324;

/**
 * 作者：Lenovo on 2019/4/20 15:41
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class CallBackTest {

    private void use() {
        testCallback(new CallbackListener() {
            @Override
            public void result(String result) {
                //拿到了结果
            }
        });
    }


    private void testCallback(CallbackListener callbackListener) {
        //业务操作
        //.......................


        callbackListener.result("我是被调用方得到的结果，返回给调用发");
    }


    interface CallbackListener {
        void result(String result);
    }
}
