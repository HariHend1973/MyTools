package com.kutukupret.mytools;

import android.content.Context;
import android.content.SharedPreferences;
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

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String MIKHMON = "mikhmon";

    private String text_mikhmon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        wv_mikhmon = (WebView)view.findViewById(R.id.wv_mikhmon);

        SharedPreferences pref = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        text_mikhmon = pref.getString(MIKHMON, "");

        wv_mikhmon.getSettings().setJavaScriptEnabled(true);

        wv_mikhmon.loadUrl(text_mikhmon);
        wv_mikhmon.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        StyleableToast.makeText(getActivity(), "Open mikhmon", R.style.exampleToast).show();
        return view;
    }
}
