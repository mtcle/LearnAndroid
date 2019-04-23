package com.mtcle.customlib.common.utils;

import android.app.Activity;

import com.taobao.library.EasyPermission;
import com.taobao.library.PermissionResultCallback;

import java.util.List;

/**
 * 作者：Lenovo on 2019/4/23 16:55
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class PermissionUtils {

    public interface OnPermissionListener {
        void onPermissionGranted(List<String> grantedPermissions);

        void onPermissionDenied(List<String> grantedPermissions);

        void onIsAllGranted(boolean isAllGranted);//是否全部同意
    }


    public static EasyPermission checkPermissionByMtcle(Activity context, final String[] permissions, final OnPermissionListener onPermissionListener) {
        EasyPermission easyPermission = new EasyPermission.Builder(context, null, new PermissionResultCallback() {
            @Override
            public void onPermissionGranted(List<String> grantedPermissions) {
                onPermissionListener.onPermissionGranted(grantedPermissions);
                onPermissionListener.onIsAllGranted(true);
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                onPermissionListener.onPermissionDenied(deniedPermissions);
                onPermissionListener.onIsAllGranted(false);
            }
        }).permission(permissions)//申请那些权限
                .rationalMessage("若想使用此功能，请赋予必需的权限")//想用户解释为什么需要这些权限
                .deniedMessage("您没有授予权限，功能将不能正常使用。你可以去设置页面重新授予权限")//用户仍然拒绝，引导用户去设置页面打开
                .settingBtn(true)
                .build();
        easyPermission.check();//检查
        return easyPermission;
    }
}
