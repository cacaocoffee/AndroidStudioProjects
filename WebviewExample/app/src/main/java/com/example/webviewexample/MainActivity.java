package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView ;
    private String url ="https://www.naver.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        //webview의 아이디 값을 찾아오고 이 인터넷에 대한 세팅을 해줘야함
        webView.getSettings().setJavaScriptEnabled(true);
        //자바스크립트 언어를 허용해줌 true
        webView.loadUrl(url); //특정 URL을 틀어줘라
        webView.setWebChromeClient(new WebChromeClient());
        //크롬이라는 브라우저에 맞춰서 쾌적하게 돌리기 위한 추가세팅
        webView.setWebViewClient(new WebViewClientClass());
        //WebviewClientClass 에다가 알트엔터 밑에꺼 선택하면 아래에 클래스가 생김



    }

    //뒤로가기 눌렀을 때 웹뷰가 잘 종료되게 하자
    // ctrl O 하고 onkeyDown 검색
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            //눌린키가 뒤로가기 키이면서  웹뷰가 뒤로 갈수있다면?
            //뒤로가게해라
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //현재 페이지의 URL을 읽어오는 메소드이다.
            view.loadUrl(url);
            return true;
        }
    }
}