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

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    WebView wv_profile;
    private static final String URL = "https://www.kutukupret.com/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        wv_profile = (WebView) view.findViewById(R.id.wv_profile);
        wv_profile.getSettings().setJavaScriptEnabled(true);

        wv_profile.loadUrl(URL);
        wv_profile.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });

        StyleableToast.makeText(getActivity(), "Open kutukupret", R.style.exampleToast).show();
        return view;
    }
}
