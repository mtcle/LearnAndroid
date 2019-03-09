package com.mtcle.learnandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.mtcle.customlib.common.CommonAcitivty;
import com.mtcle.learnandroid.beans.User;

public class MainActivity extends CommonAcitivty {
    boolean i=false;
    String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast("xxx");
        String str="{\n" +
                "name: \"张三\",\n" +
                "sex: 1\n" +
                "}";


//        User user=new Gson().fromJson(str,User.class);
        User user=jsonParse(str,User.class);
//        if(i){
//            test="xxx";
//        }else{
//
//        }
//
//        Log.d("mtcle",null);
        //
        //xxx



    }

    public static void main(String[] a){

        String str="{\n" +
                "name: \"张三\",\n" +
                "sex: 1\n" +
                "}";


//        User user=new Gson().fromJson(str,User.class);


    }



    @Override
    protected int getSubLayoutId() {
        i=false;
        return 0;
    }

    private void test(){
        i=true;
    }
}
