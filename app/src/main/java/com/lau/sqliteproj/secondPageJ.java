package com.lau.sqliteproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class secondPageJ extends AppCompatActivity {
    WebView w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondpage);
        w = (WebView) findViewById(R.id.webv);
        // getting the specified url from the previous page
        String wURL = getIntent().getStringExtra("URL");
        w.setWebViewClient(new WebViewClient());
        w.loadUrl(wURL);
    }
}