package com.mtcle.learnandroid.day324.pattern.observer;

/**
 * 作者：Lenovo on 2019/3/20 17:37
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class User implements UserObserverable {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void receiveed(String msg) {
        System.out.println(name + "收到通知：" + msg);
//        DebugUtil.debug(name + "收到通知：" + msg);
    }
}
