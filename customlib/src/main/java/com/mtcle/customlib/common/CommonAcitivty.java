package com.mtcle.customlib.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mtcle.customlib.R;

/**
 * 作者：Lenovo on 2019/3/9 09:51
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public abstract class CommonAcitivty extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String subString="子类传过来的字符串";
        int layoutId=getSubLayoutId();


        setContentView(getSubLayoutId());
    }


    protected void Toast(String msg){

        //xxx
    }


    protected abstract int getSubLayoutId();



}
