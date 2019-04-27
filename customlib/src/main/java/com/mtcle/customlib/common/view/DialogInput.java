package com.mtcle.customlib.common.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mtcle.customlib.R;


/**
 * 仿IOS弹出层菜单
 */
public class DialogInput implements OnClickListener {

    private Context mContext;
    private PopupWindow popupWindow;
    private TextView tv_menu1, tv_menu2, tvCancel;
    private EditText etInput;
    private String inputStr;
    private MenuClickDialogListener listener;

    public DialogInput(Context context, MenuClickDialogListener listener) {
        mContext = context;
        this.listener = listener;
        init();
    }

    public DialogInput(Context context, String[] items,
                       MenuClickDialogListener dialogOnClickListener) {
        mContext = context;
        listener = dialogOnClickListener;
        init();
        if (items != null && items.length < 2) {
            throw new RuntimeException("定义菜单项，至少两项");
        } else {
            tv_menu1.setText(items[0]);
            tv_menu2.setText(items[1]);
        }
    }

    private void init() {
        final View contentView = LayoutInflater.from(mContext).inflate(
                R.layout.tp_wx_popupwindows_menu_input, null);

        tv_menu2 = (TextView) contentView.findViewById(R.id.tvPopMenu2);
        tv_menu2.setOnClickListener(this);
        tvCancel = (TextView) contentView.findViewById(R.id.tvCancel);
        tvCancel.setOnClickListener(this);

        etInput = contentView.findViewById(R.id.et_input);
        popupWindow = new PopupWindow(contentView, LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT, true);
        popupWindow.setTouchable(true);
        contentView.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = contentView.findViewById(R.id.tiezipopupmenu)
                        .getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setAnimationStyle(R.style.MyDialogStyleBottom);
    }

    public void show(View v) {
        popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
    }

    public void dismiss() {
        popupWindow.dismiss();
    }

    @Override
    public void onClick(View v) {

        popupWindow.dismiss();

        if (v.getId() == R.id.tvPopMenu2) {
            if (listener != null) {
                inputStr = etInput.getText().toString();
                listener.onMenu2Clicked(inputStr);
            }
        } else if (v.getId() == R.id.tvCancel) {
            popupWindow.dismiss();
        }
    }

    public interface MenuClickDialogListener {
        /**
         * 确认按钮回调
         */
        void onMenu2Clicked(String inputStr);

    }
}
