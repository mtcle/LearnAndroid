package com.mtcle.customlib.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.mtcle.customlib.common.utils.DebugUtil;
import com.mtcle.customlib.common.utils.PermissionUtils;
import com.taobao.library.EasyPermission;

import java.util.List;

/**
 * 作者：Lenovo on 2019/3/9 09:51
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public abstract class CommonAcitivty extends AppCompatActivity {

    protected Context mContext;

    protected int PERMISSION_REQUEST_CODE = 0x18;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String subString = "子类传过来的字符串";
        setContentView(getSubLayoutId());
        mContext = this;
    }


    private EasyPermission easyPermission;

    /**
     * 发起动态权限申请
     *
     * @param perssions
     */
    protected void requestPerssion(String[] perssions, final PermissionCallback permissionCallback) {
        //发起动态权限申请
        easyPermission = PermissionUtils.checkPermissionByMtcle(this, perssions, new PermissionUtils.OnPermissionListener() {
            @Override
            public void onPermissionGranted(List<String> grantedPermissions) {
                DebugUtil.debug("权限同意：" + grantedPermissions);
            }

            @Override
            public void onPermissionDenied(List<String> grantedPermissions) {
                DebugUtil.error("权限被拒绝：" + grantedPermissions);
            }

            @Override
            public void onIsAllGranted(boolean isAllGranted) {
                DebugUtil.debug("是否全部授予权限：" + isAllGranted);
                permissionCallback.result(isAllGranted);
            }
        });
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

    protected interface PermissionCallback {
        void result(boolean isPermissioned);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (easyPermission != null) {
            easyPermission.handleResult(requestCode, resultCode, data);
        }
    }

}
