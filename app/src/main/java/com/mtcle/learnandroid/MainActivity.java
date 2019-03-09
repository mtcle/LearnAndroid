package com.mtcle.learnandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.mtcle.customlib.common.CommonAcitivty;

public class MainActivity extends CommonAcitivty {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast("xxx");


        //
        //xxx



    }


    @Override
    protected int getSubLayoutId() {
        return 0;
    }

    private void test(){

    }
}
