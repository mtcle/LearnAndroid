package com.mtcle.learnandroid.contacts;

import android.Manifest;
import android.util.Log;
import android.view.View;

import com.mtcle.customlib.common.CommonAcitivty;
import com.mtcle.customlib.common.utils.DebugUtil;
import com.mtcle.customlib.common.utils.ViewUtil;
import com.mtcle.customlib.common.view.DialogInput;
import com.mtcle.learnandroid.R;

import java.util.List;

/**
 * 作者：Lenovo on 2019/4/23 15:09
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class ContactsActivity extends CommonAcitivty {
    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_contacts;
    }

    public void btnContacts(View v) {

        requestPerssion(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS}, new PermissionCallback() {
            @Override
            public void result(boolean isPermissioned) {
                if (isPermissioned) {
                    //有权限
                    List<ContactUserBean> contacts = ContactsUtils.queryContacts(mContext);
                    DebugUtil.debug("读取通讯录结束：" + contacts);

                    String userNme = ContactsUtils.getDisplayNameByPhone1(mContext, "15966666666");
                    DebugUtil.debug("根据电话查姓名结果：" + userNme);

                    List<PhoneNumber> phone = ContactsUtils.getPhoneByName(mContext, "张三");
                    DebugUtil.debug("根据姓名查电话结果：" + phone);
                } else {
                    ViewUtil.showToast(mContext, "无权限，无法使用！");
                }
            }
        });
    }

    public void btnSms(View v) {

        requestPerssion(new String[]{Manifest.permission.READ_SMS, Manifest.permission.READ_CONTACTS}, new PermissionCallback() {
            @Override
            public void result(boolean isPermissioned) {
                if (isPermissioned) {
                    //有权限
                    DebugUtil.debug("有短信权限了");
                    List<SmsBean> datas = SmsReadUtils.getSmsInPhone(mContext);
                    DebugUtil.debug("短信列表：" + datas);
                } else {
                    ViewUtil.showToast(mContext, "无权限，无法使用！");
                }
            }
        });
    }


    public void btnDialog(View v) {
//        PopFromDownDialog popFromDownDialog = new PopFromDownDialog(this, new PopFromDownDialog.MenuClickDialogListener() {
//            @Override
//            public void onMenu1Clicked() {
//
//            }
//
//            @Override
//            public void onMenu2Clicked() {
//
//            }
//        });
//
//        popFromDownDialog.show(v);


        DialogInput dialogInput=new DialogInput(this, new DialogInput.MenuClickDialogListener() {
            @Override
            public void onMenu2Clicked(String inputStr) {
                Log.d("mtcle","input输入的值："+inputStr);
            }
        });


        dialogInput.show(v);


    }
}
