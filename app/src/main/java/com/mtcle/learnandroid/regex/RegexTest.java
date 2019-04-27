package com.mtcle.learnandroid.regex;

import java.util.regex.Pattern;

/**
 * 作者：Lenovo on 2019/4/27 15:59
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class RegexTest {


    public static void main(String[] a) {
        String line = "1222223335.2";
        String p = "\\w+";

        //这个正则表达式，代表
        // 以数字开头，
        // 可以有小数点0个或者一个，
        // 小数点后面必须有数字
        //数字长度是1~2位
        String p1="^\\d+(\\.\\d{1,2}+)?";//+代表至少一个，？代表 0次或者1次，*代表0次或者多次
        System.out.printf("结果：" + Pattern.matches(p1, line));


        //这个正则表达式，代表
        // 以数字开头，
        // 可以有小数点0个或者一个，
        // 小数点后面必须有数字
        //数字长度是1~2位
        String line2="a11111111a";
        String p2="([a-z]|[A-Z])+(\\d)+";//+代表至少一个，？代表 0次或者1次，*代表0次或者多次
        System.out.printf("结果：" + Pattern.matches(p2, line2));
    }


}
