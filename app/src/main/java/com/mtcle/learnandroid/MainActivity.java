package com.mtcle.learnandroid;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.mtcle.customlib.common.utils.DebugUtil;
import com.mtcle.learnandroid.beans.User;
import com.mtcle.learnandroid.common.AppRequestDataActivity;
import com.mtcle.learnandroid.common.RespCommon;
import com.okhttplib.HttpInfo;
import com.okhttplib.annotation.RequestType;

public class MainActivity extends AppRequestDataActivity {
    boolean i = false;
    String test;


    public static String aa = "xxxx";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast("xxx");
        String str = "{\n" +
                "name: \"张三\",\n" +
                "sex: 1\n" +
                "}";
        getIntent().getIntExtra("xxx", 0);
        String url = "http://m2.qiushibaike.com/article/list/suggest?count=30&page=1";

        appRequestDataMap(url, null, RequestType.GET, new RequestCallBack() {
            @Override
            public void onSuccess(RespCommon obj, HttpInfo info) {
                DebugUtil.debug("请求完成...............");
                //JSON 解析
            }
        });
//        User user=new Gson().fromJson(str,User.class);
        User user = jsonParse(str, User.class);

        startService(new Intent(this, TestServices.class));
       /*bindService(new Intent(this, TestServices.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        },BIND_AUTO_CREATE);*/


        test();




        requestPerssion(new String[]{"xxx", "xxx"}, new PermissionCallback() {
            @Override
            public void result(int requestCode, String[] permissions, int[] grantResults) {
                //当前页面动态权限申请结果回调
            }
        });

    }

    BroadCastRec b;
    IntentFilter intentFilter;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

//        startService(new Intent());


        /*bindService(new Intent(mContext, TestServices.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);*/


      /*  b = new BroadCastRec();
        intentFilter = new IntentFilter(BroadCastRec.Action);
        registerReceiver(b, intentFilter);
*/

    }

    @Override
    protected void onDestroy() {

        //强引用类型 释放掉
        super.onDestroy();
//        unregisterReceiver(b);


    }

   /* public static void main(String[] a){

        String str="{\n" +
                "name: \"张三\",\n" +
                "sex: 1\n" +
                "}";


//        User user=new Gson().fromJson(str,User.class);


    }*/


    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected int getSubLayoutId() {
        i = false;
        return R.layout.activity_main;
    }

    private void test() {
        i = true;
    }


    private static void StrDel() {
        String str = "\"1234'56\"";
        int start = str.indexOf('"');//
        int test = str.indexOf("'");
        int end = str.lastIndexOf('"');
//       String str2= str.substring(start+1,end);
        str.toLowerCase();
        str.toUpperCase();
        String str2 = "xxxxx,xxxx,223,444";
        str2.charAt(0);
        char a = 'x';


//        String[] a = str2.split(",");


//        List<String> list = Arrays.asList(a);


        //subString
        //repleace
        //indexOf
        //split

    }


    public static void main(String[] a) {
        StrDel();
    }


}
