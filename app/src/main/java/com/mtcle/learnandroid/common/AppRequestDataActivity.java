package com.mtcle.learnandroid.common;


import com.mtcle.customlib.common.RequestDataActivity;

import java.util.HashMap;

/**
 * 作者：Lenovo on 2019/3/8 17:13
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public abstract class AppRequestDataActivity extends RequestDataActivity<RespCommon> {
    @Override
    protected boolean processCommonData(RespCommon respFull) {
        if (respFull != null && 200 == respFull.getCode()) {
            return true;
        }
        return false;
    }

    protected void appRequestDefault(String url, HashMap<String, String> parmas, RequestCallBack requestCallBack) {
        super.requestDataDefault(url, parmas, RespCommon.class, requestCallBack);
    }

    protected void appRequestDataMap(String url, HashMap<String, String> parmas, int requestType, RequestCallBack requestCallBack) {
        super.requestDataMap(url, parmas, requestType, RespCommon.class, requestCallBack);
    }
}
