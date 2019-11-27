package com.kutukupret.mytools;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.muddzdev.styleabletoast.StyleableToast;

import androidx.fragment.app.Fragment;

public class MessageFragment extends Fragment {
    WebView wv_mikhmon;
    private static final String URL = "https://mikhmon.kutukupret.com/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        wv_mikhmon = (WebView)view.findViewById(R.id.wv_mikhmon);
        wv_mikhmon.getSettings().setJavaScriptEnabled(true);

        wv_mikhmon.loadUrl(URL);
        wv_mikhmon.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        StyleableToast.makeText(getActivity(), "Open mikhmon", R.style.exampleToast).show();
        return view;
    }
}
