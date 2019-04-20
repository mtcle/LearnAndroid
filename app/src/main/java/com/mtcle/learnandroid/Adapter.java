package com.mtcle.learnandroid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 作者：Lenovo on 2019/4/20 15:54
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class Adapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




        return null;
    }


    /*@Override
    public int getItemViewType(int position) {
        if(isOther){
            return R.layout.leftlayoutItem
        }else{
            return R.layout.rightLayoutItem
        }
    }*/

    @Override
    public int getViewTypeCount() {
        return 1;
    }
}
