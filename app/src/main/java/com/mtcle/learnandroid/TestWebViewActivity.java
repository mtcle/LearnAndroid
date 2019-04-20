package com.mtcle.learnandroid;

import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.mtcle.customlib.common.utils.ViewUtil;
import com.mtcle.learnandroid.common.AppRequestDataActivity;

import java.util.List;

/**
 * 作者：Lenovo on 2019/4/20 10:41
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 */
public class TestWebViewActivity extends AppRequestDataActivity {
    @Override
    protected int getSubLayoutId() {
        return R.layout.activity_webview;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView myWebView = findViewById(R.id.wv_content);
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new JsInteration(), "zhangsan");
        myWebView.setWebChromeClient(new WebChromeClient() {
        });
        myWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

        });



        List<String> datas = ViewUtil.getMessage();
        test(datas);
        test1(datas);
    }

    public class JsInteration {

        @JavascriptInterface
        public void toastMessage(String message) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }


    }

    private void test(List<String> test) {
        ///
//        test.add();
//        test.size();
    }

    private void test1(List<String> test) {
        ///
    }

    private void test2(List<String> test) {
        ///
    }
}
