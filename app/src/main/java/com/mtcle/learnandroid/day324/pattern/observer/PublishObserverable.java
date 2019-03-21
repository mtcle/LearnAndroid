package com.mtcle.learnandroid.day324.pattern.observer;

/**
 * 作者：Lenovo on 2019/3/20 17:28
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public interface PublishObserverable {
    void addObserver(UserObserverable userObserverable);
    void delObserver(UserObserverable userObserverable);
    void notifyMsg(String msg);

}
