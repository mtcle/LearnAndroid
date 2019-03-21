package com.mtcle.learnandroid.day324.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Lenovo on 2019/3/20 17:31
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class Publish1 implements PublishObserverable {

    private List<UserObserverable> allUserObserverables = new ArrayList<>();

    @Override
    public void addObserver(UserObserverable userObserverable) {
        allUserObserverables.add(userObserverable);
    }

    @Override
    public void delObserver(UserObserverable userObserverable) {
        allUserObserverables.remove(userObserverable);
    }

    @Override
    public void notifyMsg(String msg) {
        for(UserObserverable observerable:allUserObserverables){
            observerable.receiveed(msg);
        }
    }
}
