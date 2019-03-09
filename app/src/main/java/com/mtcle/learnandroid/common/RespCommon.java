package com.mtcle.learnandroid.common;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * 作者：Lenovo on 2019/3/8 17:11
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class RespCommon<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
