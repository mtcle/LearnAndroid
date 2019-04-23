package com.mtcle.learnandroid.contacts;

import com.google.gson.Gson;

/**
 * 作者：Lenovo on 2019/4/23 16:22
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class SmsBean {
    private String phoneNum;
    private String content;
    private int type;
    private String typeStr;

    private long date;
    private String dateStr;

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
