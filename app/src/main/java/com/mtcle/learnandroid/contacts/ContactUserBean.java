package com.mtcle.learnandroid.contacts;

import com.google.gson.Gson;

import java.util.List;

/**
 * 作者：Lenovo on 2019/4/23 15:38
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class ContactUserBean {
    private String name;
    private List<PhoneNumber> phoneNumbers;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
