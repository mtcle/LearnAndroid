package com.mtcle.learnandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.mtcle.customlib.common.CommonAcitivty;
import com.mtcle.customlib.common.utils.DebugUtil;
import com.mtcle.learnandroid.beans.User;
import com.mtcle.learnandroid.common.AppRequestDataActivity;
import com.mtcle.learnandroid.common.RespCommon;
import com.okhttplib.HttpInfo;
import com.okhttplib.annotation.RequestType;

public class MainActivity extends AppRequestDataActivity {
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

        String url = "http://m2.qiushibaike.com/article/list/suggest?count=30&page=1";

        appRequestDataMap(url, null, RequestType.GET, new RequestCallBack() {
            @Override
            public void onSuccess(RespCommon obj, HttpInfo info) {
                DebugUtil.debug("请求完成...............");
                //JSON 解析
            }
        });
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
