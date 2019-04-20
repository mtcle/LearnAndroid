package com.mtcle.learnandroid.day324.websocket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.mtcle.customlib.common.CommonAcitivty;
import com.mtcle.customlib.common.utils.DebugUtil;
import com.mtcle.learnandroid.R;
import com.okhttplib.OkHttpUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * 作者：Lenovo on 2019/3/21 10:49
 * <p>
 * 邮箱：mtcle@126.com
 * <p>
 * 描述：
 * websocket流程
 * 1、创建客户端，建立连接
 * 2、注册监听
 * 3、认证登录
 * 4、发送消息或者收到消息
 * 5、心跳，ping、pong
 */
public class WebSocket extends CommonAcitivty {
    private OkHttpClient okHttpClient;
    private okhttp3.WebSocket webSocket;
    private String url = "wss://uattsm.17wanxiao.com/websocket/payresult";

    private TextView tvTip;





    @Override
    protected int getSubLayoutId() {
        return R.layout.acitivy_socket;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTip = findViewById(R.id.tv_tip);
        okHttpClient = OkHttpUtil.getDefault().getDefaultClient();
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webSocket = okHttpClient.newWebSocket(new Request.Builder().url(url).build(), new WebSocketListener() {
                    @Override
                    public void onOpen(okhttp3.WebSocket webSocket, Response response) {
                        super.onOpen(webSocket, response);
                        DebugUtil.debug("建立连接" + response.toString());
                    }

                    @Override
                    public void onMessage(okhttp3.WebSocket webSocket, String text) {
                        super.onMessage(webSocket, text);
                        DebugUtil.debug("onMessage收到消息text：" + text);
                        tvTip.setText("接受到数据：" + text);

                        //

                    }

                    @Override
                    public void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) {
                        super.onMessage(webSocket, bytes);
                        DebugUtil.debug("onMessage收到消息byte：" + bytes);
                    }

                    @Override
                    public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
                        super.onClosing(webSocket, code, reason);
                        DebugUtil.debug("onClosing：" + reason);
                    }

                    @Override
                    public void onClosed(okhttp3.WebSocket webSocket, int code, String reason) {
                        super.onClosed(webSocket, code, reason);
                        DebugUtil.debug("onClosed：" + reason);
                    }

                    @Override
                    public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
                        super.onFailure(webSocket, t, response);
                        DebugUtil.debug("onFailure：" + response);
                    }
                });
            }
        });

        findViewById(R.id.btn_send_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webSocket != null) {
                    webSocket.send("{\"subscriber\": 44120000}");
                }
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webSocket != null) {
                    webSocket.close(4000, "自己关闭了");
                }
            }
        });

    }
}
