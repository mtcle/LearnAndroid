package com.mtcle.customlib.common;

/**
 * 作者：Lenovo on 2019/3/9 18:02
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class AbstractLocationActivity extends RequestDataActivity {
    @Override
    protected boolean processCommonData(Object respFull) {
        return false;
    }

    @Override
    protected int getSubLayoutId() {
        return 0;
    }
}
