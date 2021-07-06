package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://www.kw.ac.kr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        //크롬 클라이언트로 설정
        webView.setWebChromeClient(new WebChromeClient());
        //일반 클라인언트로 설정
        webView.setWebViewClient(new WebViewClientClass());


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }


        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        //현재 URL 읽어오는 것
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            view.loadUrl(url);
            return true;
        }
    }
}