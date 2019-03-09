package com.mtcle.learnandroid.beans;

import com.google.gson.Gson;

/**
 * 作者：Lenovo on 2019/3/9 09:44
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class User {


    private String name;
    private int sex;







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


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
