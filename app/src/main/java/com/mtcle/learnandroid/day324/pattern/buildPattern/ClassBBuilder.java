package com.mtcle.learnandroid.day324.pattern.buildPattern;

/**
 * 作者：Lenovo on 2019/3/20 17:50
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class ClassBBuilder {
    private static ClassB classB;
    private static ClassBBuilder builder;

    public static ClassBBuilder create() {
        classB = new ClassB();
        builder = new ClassBBuilder();
        return builder;
    }


    public ClassBBuilder setName(String name) {
        classB.setName(name);
        return builder;
    }

    public ClassBBuilder setPhone(String phone) {
        classB.setPhoneNum(phone);
        return builder;
    }
    //...


    public ClassB build() {
        return classB;
    }
}
