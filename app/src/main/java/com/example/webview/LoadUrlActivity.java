package com.example.webview;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/**
 * ********文件描述：Android调用js的方法loadUrl********
 * ********作者：huleiyang********
 * ********创建时间：2019/11/27********
 * ********更改时间：2019/11/27********
 * ********版本号：1********
 */
public class LoadUrlActivity extends AppCompatActivity {

    private WebView webView;
    private Button button;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_url_activity_layout);
        button = findViewById(R.id.button);
        webView = findViewById(R.id.load_url_web);

        WebSettings webSettings = webView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        webView.setWebChromeClient(new WebChromeClient());

        // 先载入JS代码
        // 格式规定为:file:///android_asset/文件名.html
        webView.loadUrl("file:///android_asset/test.html");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.post(new Runnable() {
                    @Override
                    public void run() {
                        //call 为html里面的方法
                     webView.loadUrl("javascript:call()");
                    }
                });
            }
        });

    }
}
