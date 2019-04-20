package com.mtcle.customlib.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

/**
 * 作者：Lenovo on 2019/3/9 09:51
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public abstract class CommonAcitivty extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String subString = "子类传过来的字符串";
        setContentView(getSubLayoutId());
        mContext = this;
    }


    private PermissionCallback permissionCallback;

    /**
     * 发起动态权限申请
     *
     * @param perssions
     */
    protected void requestPerssion(String[] perssions, PermissionCallback permissionCallback) {
        //发起动态权限申请
        this.permissionCallback = permissionCallback;
        //TODO





    }

    protected void Toast(String msg) {

        //xxx
    }


    protected abstract int getSubLayoutId();


    protected <T> T jsonParse(String jsonStr, Class<T> cls) {
        T obj = null;
        try {
            //做一些非空判断
            obj = new Gson().fromJson(jsonStr, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


        return obj;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //动态权限授权结果
        if (permissionCallback != null) {
            permissionCallback.result(requestCode, permissions, grantResults);
        }
    }

    protected interface PermissionCallback {
        void result(int requestCode, String[] permissions, int[] grantResults);
    }

}
