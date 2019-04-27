package com.mtcle.learnandroid.contacts;

import com.google.gson.Gson;

/**
 * 作者：Lenovo on 2019/4/23 15:54
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class PhoneNumber {
    /**
     * 系统原始数据，例如：139-1234-5678
     */
    private String phoneNum;
    /**
     * 格式化后的电话号码，移除了空格 - 等，例如13912345678
     */
    private String phoneNumSmart;
    private int type;

    public PhoneNumber(String phoneNum, int type) {
        this.phoneNum = phoneNum;
        this.type = type;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPhoneNumSmart() {
        return phoneNumSmart;
    }

    public void setPhoneNumSmart(String phoneNumSmart) {
        this.phoneNumSmart = phoneNumSmart;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
