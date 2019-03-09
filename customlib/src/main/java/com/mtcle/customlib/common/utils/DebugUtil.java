package com.mtcle.customlib.common.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.mtcle.customlib.BuildConfig;

public class DebugUtil {
	private final static String TAG = "DebugUtil";
	public static final boolean DEBUG = BuildConfig.DEBUG;

	public static void toast(Context context, String content) {
		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
	}

	public static void debug(String tag, String msg) {
		if (DEBUG && !StringUtils.isBlank(msg)) {
			Log.d(tag, msg);
		}
	}

	public static void debug(String msg) {
		if (DEBUG && !StringUtils.isBlank(msg)) {
			Log.d(TAG, msg);
		}
	}

	public static void info(String tag, String msg) {
		Log.i(tag, msg);
	}

	public static void info(String tag, String msg, Throwable th) {
		Log.i(tag, msg);
	}

	public static void warn(String tag, String msg) {
		Log.w(tag, msg);
	}

	public static void warn(String tag, String msg, Throwable th) {
		Log.w(tag, msg);
	}

	public static void error(String tag, String error) {
		Log.e(tag, error);
	}

	public static void error(String tag, String error, Throwable th) {
		Log.e(tag, error, th);
	}

	public static void error(String error) {
		Log.e(TAG, error);
	}
}
