package com.example.morriganbe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class PaginaSecundaria extends AppCompatActivity {

    ProgressBar progressBar;
    WebView mywebview;
    String url = "https://morriganbe.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_secundaria);

        progressBar = findViewById(R.id.progressBar);
        mywebview = findViewById(R.id.webViewSecundaria);
        mywebview.loadUrl(url);

        WebSettings settings = mywebview.getSettings();

        settings.setJavaScriptEnabled(true);
        settings.setDisplayZoomControls(false);
        settings.supportZoom();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        mywebview.clearHistory();
        mywebview.clearCache(true);

        mywebview.setWebChromeClient(new WebChromeClient());

        mywebview.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                progressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

    }


}