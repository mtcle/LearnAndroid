package com.mtcle.learnandroid.contacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;

import com.mtcle.customlib.common.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Lenovo on 2019/4/23 15:32
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class ContactsUtils {


    /**
     * 耗时操作，巨慢
     *
     * @param context
     * @return
     */
    public static synchronized List<ContactUserBean> queryContacts(Context context) {
        List<ContactUserBean> contactList = new ArrayList<>();
        // 获取用来操作数据的类的对象，对联系人的基本操作都是使用这个对象
        ContentResolver cr = context.getContentResolver();
        // 查询contacts表的所有记录
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
                null, null, null);
        // 如果记录不为空
        if (cursor.getCount() > 0) {
            // 游标初始指向查询结果的第一条记录的上方，执行moveToNext函数会判断
            // 下一条记录是否存在，如果存在，指向下一条记录。否则，返回false。
            while (cursor.moveToNext()) {
                ContactUserBean userBean = new ContactUserBean();
                String rawContactId = "";
                // 从Contacts表当中取得ContactId
                String id = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.Contacts._ID));
                String userName = cursor.getString(cursor
                        .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//                Log.v("contactID", id);
//                DebugUtil.debug("name:" + userName);
                userBean.setName(userName);
                userBean.setId(id);
                // 获取RawContacts表的游标
                Cursor rawContactCur = cr.query(ContactsContract.RawContacts.CONTENT_URI, null,
                        ContactsContract.RawContacts._ID + "=?", new String[]{id}, null);
                // 该查询结果一般只返回一条记录，所以我们直接让游标指向第一条记录
                if (rawContactCur.moveToFirst()) {
                    // 读取第一条记录的RawContacts._ID列的值
                    rawContactId = rawContactCur.getString(rawContactCur
                            .getColumnIndex(ContactsContract.RawContacts._ID));
//                    Log.v("rawContactID", rawContactId);
                }
                // 关闭游标
                rawContactCur.close();
                // 读取号码
                if (Integer
                        .parseInt(cursor.getString(cursor
                                .getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    // 根据查询RAW_CONTACT_ID查询该联系人的号码
                    Cursor phoneCur = cr
                            .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                    null,
                                    ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID
                                            + "=?",
                                    new String[]{rawContactId}, null);
                    // 上面的ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                    // 可以用下面的phoneUri代替
                    // Uri
                    // phoneUri=Uri.parse("content://com.android.contacts/data/phones");

                    List<PhoneNumber> numbers = new ArrayList<>();
                    // 一个联系人可能有多个号码，需要遍历
                    while (phoneCur.moveToNext()) {
                        // 获取号码
                        String number = phoneCur
                                .getString(phoneCur
                                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                        Log.v("number", number);
                        // 获取号码类型
                        int type = phoneCur
                                .getInt(phoneCur
                                        .getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
//                        Log.v("type", type);
                        PhoneNumber phoneNumber = new PhoneNumber(number, type);
                        numbers.add(phoneNumber);

                    }
                    phoneCur.close();
                    userBean.setPhoneNumbers(numbers);
                    contactList.add(userBean);
                }
            }
            cursor.close();
        }
        return contactList;
    }


    public synchronized static List<PhoneNumber> getPhoneByName(Context context, String name) {
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "=?",
                new String[]{name}, null);
        List<PhoneNumber> allPhoneNum = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                int type = cursor.getInt(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                if (!TextUtils.isEmpty(phone)) {
                    PhoneNumber phoneNumber = new PhoneNumber(phone, type);
                    allPhoneNum.add(phoneNumber);
                }
            }
        }
        return allPhoneNum;
    }


    /**
     * 根据手机号码查询联系人姓名
     *
     * @param context
     * @param phoneNum(传入纯数字手机号码)
     * @return
     */
    public synchronized static String getDisplayNameByPhone1(Context context, String phoneNum) {
        if (StringUtils.isBlank(phoneNum) || phoneNum.length() != 11) {
            return null;
        }

        String displayName = null;
        //手机号格式，例如13912345678  转换为：139 1234 5678
        String phone1 = new StringBuffer(phoneNum.subSequence(0, 3)).append(" ").append(phoneNum.substring(3, 7))
                .append(" ").append(phoneNum.substring(7, 11)).toString();
        //手机号格式，例如13912345678  转换为：139-1234-5678
        String phone2 = new StringBuffer(phoneNum.subSequence(0, 3)).append("-").append(phoneNum.substring(3, 7))
                .append("-").append(phoneNum.substring(7, 11)).toString();
        //手机号格式，例如13912345678  转换为：1 391-234-5678
        String phone3format = new StringBuffer(phoneNum.subSequence(0, 1)).append(" ").append(phoneNum.substring(1, 4)).append("-").append(phoneNum.substring(4, 7))
                .append("-").append(phoneNum.substring(7, 11)).toString();
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.NUMBER + " in(?,?,?,?)", new String[]{
                phoneNum, phone1, phone2, phone3format}, null);

        if (cursor != null) {

            while (cursor.moveToNext()) {
                displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                if (!TextUtils.isEmpty(displayName)) {
                    break;
                }
                cursor.close();
            }
        }
        return displayName;
    }
}
