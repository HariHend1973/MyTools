package com.kutukupret.mytools;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

public class ChatFragment extends Fragment {

    WebView wv_pihole;
    private static final String URL = "http://pi.hole/admin";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        wv_pihole = (WebView)view.findViewById(R.id.wv_pihole);
        wv_pihole.getSettings().setJavaScriptEnabled(true);

        wv_pihole.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        wv_pihole.loadUrl(URL);
        return view;
    }
}
