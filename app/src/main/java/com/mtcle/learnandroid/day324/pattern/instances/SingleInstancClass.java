package com.mtcle.learnandroid.day324.pattern.instances;

/**
 * 作者：Lenovo on 2019/3/20 17:17
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：线程安全的，有jvm保证线程安全
 */
public class SingleInstancClass {
    private static final SingleInstancClass ourInstance = new SingleInstancClass();

    public static SingleInstancClass getInstance() {
        return ourInstance;
    }

    private SingleInstancClass() {
        //TODO
    }
}
