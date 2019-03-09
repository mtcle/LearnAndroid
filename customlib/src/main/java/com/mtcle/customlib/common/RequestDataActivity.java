package com.mtcle.customlib.common;

import android.os.Bundle;

import com.mtcle.customlib.common.utils.DebugUtil;
import com.mtcle.customlib.common.utils.StringUtils;
import com.mtcle.customlib.common.utils.ViewUtil;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.annotation.RequestType;
import com.okhttplib.callback.Callback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by mtcle on 2017/8/9.
 * 这里的T 代表的是统一应答的包装类，例如 class A={int code; String msg; String data}
 * <p>
 * 业务Activity不能直接继承，某个项目必须自定义一个父类继承该Activity进行统一请求包装
 */

public abstract class RequestDataActivity<T> extends CommonAcitivty {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadFirstPage();

    }

    protected interface Listener{
        void Test();
    }


    protected abstract class RequestCallBack {
        public abstract void onSuccess(T obj, HttpInfo info);

        public void onFail(HttpInfo errorStr){
            //TODO 异常处理
        }
    }

    private void test(){
        RequestCallBack requestCallBack=new RequestCallBack() {
            @Override
            public void onSuccess(T obj, HttpInfo info) {

            }
        };
    }
    /**
     * 默认请求、Post
     */
    protected void requestDataDefault(String url, HashMap<String, String> parmas, final Class<T> commonResp, final RequestCallBack requestCallBack) {
        this.requestDataMap(url, parmas, RequestType.POST, commonResp, requestCallBack);
    }

    /**
     * @param url
     * @param parmas
     * @param requestType
     * @param requestCallBack requestType= @code RequestType.Get RequestType.Post
     */
    protected void requestDataMap(String url, HashMap<String, String> parmas, @RequestType int requestType, final Class<T> commonResp, final RequestCallBack requestCallBack) {
        if (requestCallBack == null) {
            DebugUtil.error("requestCallback can't null !");
            return;
        }
        OkHttpUtil.getDefault(this).doAsync(
                HttpInfo.Builder()
                        .setUrl(url)
                        .setRequestType(requestType)//设置请求方式
                        .addHeads(addHeaders())//添加头参数
                        .addParams(parmas)//添加接口参数
                        //.setDelayExec(2, TimeUnit.SECONDS)//延迟2秒执行
                        .build(),
                new Callback() {
                    @Override
                    public void onFailure(HttpInfo info) throws IOException {
                        requestCallBack.onFail(info);
                        progressErrorInfo(info);
//                        closeProgressDialog();
                    }

                    @Override
                    public void onSuccess(HttpInfo info) throws IOException {
                        String result = info.getRetDetail();
                        T respFullBean = jsonParse(result, commonResp);
                        if (respFullBean != null) {
                            if (processCommonData(respFullBean)) {
                                requestCallBack.onSuccess(respFullBean, info);
                            }else{
                                ViewUtil.showToast(mContext,"数据转换异常！");
                                requestCallBack.onFail(info);
                            }
                        } else {
                            DebugUtil.error("数据解析异常！");
                        }
//                        closeProgressDialog();
                    }
                });
    }


    /**
     * 添加请求的header支持
     */
    protected Map<String, String> addHeaders() {
        return null;
    }


    protected void progressErrorInfo(final HttpInfo info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ViewUtil.showToast(mContext, StringUtils.isBlank(info.getRetDetail()) ? "系统错误，请稍后重试！" : info.getRetDetail());
            }
        });
        }

    /**
     * 该类提供给父类实现的，主要是解析返回的数据后，看是否正常
     */
    protected abstract boolean processCommonData(T respFull);

}
