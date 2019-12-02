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

public class ChatFragment extends Fragment {

    WebView wv_pihole;
    private static final String URL = "http://pi.hole/admin";

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PIHOLE = "pihole";

    private String text_pihole;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        wv_pihole = (WebView)view.findViewById(R.id.wv_pihole);

        SharedPreferences pref = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        text_pihole = pref.getString(PIHOLE, "");

        wv_pihole.getSettings().setJavaScriptEnabled(true);

        wv_pihole.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        wv_pihole.loadUrl(text_pihole);

        StyleableToast.makeText(getActivity(), "Open pihole", R.style.exampleToast).show();
        return view;
    }
}
