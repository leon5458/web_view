package com.example.webview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * ********文件描述：js调Android addJavascriptInterface（）进行对象映射********
 * ********作者：huleiyang********
 * ********创建时间：2019/11/27********
 * ********更改时间：2019/11/27********
 * ********版本号：1********
 */
public class AddjsInterfaceActivity extends AppCompatActivity{

    private WebView webView;
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_jsinterface_activity_layout);

        webView = findViewById(R.id.addJavascriptInterface);

        WebSettings webSettings = webView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 通过addJavascriptInterface()将Java对象映射到JS对象
        //参数1：Javascript对象名
        //参数2：Java对象名
        webView.addJavascriptInterface(new AddJS(), "test");//AndroidtoJS类对象映射到js的test对象
        // 加载JS代码
        // 格式规定为:file:///android_asset/文件名.html
        webView.loadUrl("file:///android_asset/addjs.html");
    }

    public class AddJS{
        @JavascriptInterface
        public void main(String msg){
            System.out.println("js调用了android的方法");
            Log.e("----js传递过来的参数",msg);

        }
    }
}
