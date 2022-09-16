package com.example.studentassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class GoogleSite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_site);
        WebView webView=findViewById(R.id.wabView);
        webView.getSettings().setLoadsImagesAutomatically(true);
webView.getSettings().setJavaScriptEnabled(true);
webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
webView.loadUrl("https://sites.google.com/d/1hkxBwtnd_FcpG8grQsOpSqkRZL7JSNn_/p/1rY2nqVwzlGJYQgJBwFwP8p1QtBVefHo7/edit");
    }
}