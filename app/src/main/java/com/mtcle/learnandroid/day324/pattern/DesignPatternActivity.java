package com.mtcle.learnandroid.day324.pattern;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mtcle.customlib.common.CommonAcitivty;
import com.mtcle.learnandroid.R;
import com.mtcle.learnandroid.day324.pattern.buildPattern.ClassB;
import com.mtcle.learnandroid.day324.pattern.buildPattern.ClassBBuilder;
import com.mtcle.learnandroid.day324.pattern.factory.ClassA;
import com.mtcle.learnandroid.day324.pattern.factory.ClassAFactory;
import com.mtcle.learnandroid.day324.pattern.instances.SingleInstancClass;
import com.mtcle.learnandroid.day324.pattern.observer.Publish1;
import com.mtcle.learnandroid.day324.pattern.observer.User;

/**
 * 作者：Lenovo on 2019/3/20 17:08
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class DesignPatternActivity extends CommonAcitivty {
    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_design_pattern;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public static void main(String[] a) {
        observer();
//        buildPattern();
    }

    /**
     * 单例模式
     */
    private void SingleInstances() {
        SingleInstancClass singleInstancClass = SingleInstancClass.getInstance();
    }

    /**
     * 观察者模式
     */
    private static void observer() {
        Publish1 publish1 = new Publish1();
        publish1.addObserver(new User("观察者1"));
        publish1.addObserver(new User("观察者2"));
        publish1.addObserver(new User("观察者3"));

        publish1.notifyMsg("发布一条通知！！");
    }


    /**
     * 生成器模式
     */
    private static void buildPattern() {
        ClassB b = ClassBBuilder.create().setName("张三").setPhone("110").build();
        ClassB b1=new ClassB();
        b1.setName("xxx");
        b1.setSex(1);
        System.out.println("B:" + b);
    }

    /**
     * 工厂模式
     */
    private void factory() {


        ClassAFactory factory = new ClassAFactory();
        ClassA classA = factory.createClassA();

//        Bitmap bitmap = BitmapFactory.decodeFile("xxx");
    }

    /**
     * 适配器模式
     */
    private void adapter() {

    }
}
