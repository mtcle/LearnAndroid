package com.mtcle.learnandroid.day324.pattern.buildPattern;

import com.google.gson.Gson;

/**
 * 作者：Lenovo on 2019/3/20 17:49
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class ClassB {

    private String name;
    private int sex;
    private String phoneNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
