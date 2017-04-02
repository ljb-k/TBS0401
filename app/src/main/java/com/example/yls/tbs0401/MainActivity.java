package com.example.yls.tbs0401;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    private com.tencent.smtt.sdk.WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPermission();
        mWebView = (WebView) findViewById(R.id.txWebView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String s) {
                view.loadUrl(s);
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl("http://www.baidu.com");
        getWindow().setFormat(PixelFormat.TRANSLUCENT);

    }

    private void getPermission() {

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},1001);
        }
        if(ContextCompat.checkSelfPermission(MainActivity.this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE},1001);
        }

    }


}
