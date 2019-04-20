package com.mtcle.learnandroid.day324.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 作者：Lenovo on 2019/3/21 10:31
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class Order {

    public static void main(String[] a) {
        UserBeanOrder user1 = new UserBeanOrder("张三", 10);
        UserBeanOrder user2 = new UserBeanOrder("李四", 20);
        UserBeanOrder user3 = new UserBeanOrder("王五", 15);
        UserBeanOrder user4 = new UserBeanOrder("赵六", 7);


        List<UserBeanOrder> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        System.out.println("当前list:" + list);

        Collections.sort(list);


//        Collections.sort(list, new Comparator<UserBeanOrder>() {
//            @Override
//            public int compare(UserBeanOrder o1, UserBeanOrder o2) {
//                if (o1.getAge() > o2.getAge()) {
//                    return 1;
//                } else if (o1.getAge() == o2.getAge()) {
//                    return 0;
//                } else {
//                    return -1;
//                }
//            }
//        });


        System.out.println("排序后list:" + list);


    }
}
