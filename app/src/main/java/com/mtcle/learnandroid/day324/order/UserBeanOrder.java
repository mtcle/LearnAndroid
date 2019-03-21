package com.mtcle.learnandroid.day324.order;

/**
 * 作者：Lenovo on 2019/3/21 10:31
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class UserBeanOrder /*implements Comparable<UserBeanOrder> */{
    private String name;
    private int age;

    public UserBeanOrder(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


//    @Override
//    public int compareTo(UserBeanOrder o) {
//        return getAge() - o.age;
//    }


    @Override
    public String toString() {
        return "UserBeanOrder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
