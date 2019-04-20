/**
 *
 */
package com.mtcle.customlib.common.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ViewUtil {

    private static Toast mToast;

    public static void showToast(Context context,
                                 int toastId) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, context.getText(toastId).toString(), Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showToast(Context context, String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void showToastLongTime(Context context, String formatStr) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, formatStr, Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void showToastLongTime(Context context, int formatStr) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, formatStr, Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    /**
     * showAalert
     * 描述：
     *
     * @param context
     * @param titleMsg
     */
    public static void showAalert(Context context, CharSequence... titleMsg) {
        showAalert(context, 0, false, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }, titleMsg);
    }

    public static void showAalertWithCancel(Context context, DialogInterface.OnClickListener dialogOnClickListener, CharSequence... titleMsg) {
        showAalert(context, 0, true, dialogOnClickListener, titleMsg);
    }

    public static void showAalert(Context context, int iconRes, boolean showCancel, DialogInterface.OnClickListener dialogOnClickListener, CharSequence... titleMsg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (iconRes > 0) {
            builder.setIcon(iconRes);
        }
        if (titleMsg.length == 1) {
            builder.setTitle("温馨提示");
            builder.setMessage(titleMsg[0]);
        } else if (titleMsg.length > 1) {
            builder.setTitle(titleMsg[0]);
            builder.setMessage(titleMsg[1]);
        }
        builder.setCancelable(false);
        if (titleMsg.length < 4) {
            builder.setPositiveButton("取消", dialogOnClickListener);
            if (showCancel) {
                builder.setNegativeButton("返回", dialogOnClickListener);
            }
        } else {
            builder.setPositiveButton(titleMsg[2], dialogOnClickListener);
            builder.setNegativeButton(titleMsg[3], dialogOnClickListener);
        }
        builder.show();
    }

    public static void showAalertWithItems(Context context, String[] items, DialogInterface.OnClickListener dialogOnClickListener, CharSequence... titleMsg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //builder.setIcon(R.drawable.dialog_icon_warning);
        if (titleMsg == null) {
            builder.setTitle("温馨提示");
        } else if (titleMsg.length == 1) {
            builder.setTitle(titleMsg[0]);
        }
        builder.setItems(items, dialogOnClickListener);
        builder.setCancelable(false);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.dismiss();
            }
        });
        builder.show();
    }

    /*public static void showAalert4HtmlWithCancelButton(Context context, CharSequence title, CharSequence message){
        showAalert4Html(context, null, title, message, "取消");
    }*/
    /*public static void showAalert4Html(Context context, DialogInterface.OnClickListener dialogOnClickListener,CharSequence title, CharSequence message, CharSequence... btnTitle){
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(icon);
		final View layout = LayoutInflater.from(context).inflate(R.layout.webkit, null);
		builder.setView(layout);
		builder.setTitle((title == null || StringUtils.isBlank(title.toString())) ? "温馨提示" : title);
		WebView wvContent = (WebView) layout.findViewById(R.id.webview);
		wvContent.loadDataWithBaseURL(null, message.toString(), "text/html","UTF-8", null);
		
		if(btnTitle.length == 1){
			builder.setNegativeButton(btnTitle[0], dialogOnClickListener);
		}else if(btnTitle.length == 2){
			builder.setNegativeButton(btnTitle[0], dialogOnClickListener);
			builder.setPositiveButton(btnTitle[1], dialogOnClickListener);
		}
		builder.setCancelable(false);
		builder.show();
	}*/


    private static long lastClickTime = 0;//上次点击的时间
    private static int spaceTime = 1000;//时间间隔

    /**
     * isFastDoubleClick
     * 描述：防止重复点击
     *
     * @return
     */
    public static boolean isFastDoubleClick() {
        long currentTime = System.currentTimeMillis();//当前系统时间
        boolean isAllowClick;//是否允许点击
        if (currentTime - lastClickTime > spaceTime) {
            isAllowClick = false;
        } else {
            isAllowClick = true;
        }
        lastClickTime = currentTime;
        return isAllowClick;
    }

    /**
     * 描述：显示键盘
     *
     * @param view
     */
    public static void setKeyboardFocus(final View view) {
        try {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            (new Handler()).postDelayed(new Runnable() {
                public void run() {
                    view.dispatchTouchEvent(MotionEvent.obtain(
                            SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                            MotionEvent.ACTION_DOWN, 0, 0, 0));
                    view.dispatchTouchEvent(MotionEvent.obtain(
                            SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                            MotionEvent.ACTION_UP, 0, 0, 0));
                }
            }, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public static List<String> getMessage() {



//        ArrayList<String> messages=new ArrayList<String>();//不要这样用
//        HashMap<String,String> maps=new HashMap<String, String>();
        List<String> messages = new ArrayList<String>();//这样用


        messages.add("");

        Map<String, String> maps = new HashMap<String, String>();
        maps.put("xxx", "xxx");

//        ArrayList<String> messages = new ArrayList<String>();

        return messages;
    }
}
