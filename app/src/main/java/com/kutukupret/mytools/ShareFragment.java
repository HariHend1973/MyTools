package com.kutukupret.mytools;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muddzdev.styleabletoast.StyleableToast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShareFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_share, container, false);

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/html");
        //sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Share MyTools");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml("https://github.com/HariHend1973/MyTools/blob/master/app/release/MyTools.apk").toString());
        startActivity(Intent.createChooser(sharingIntent,"Share link using"));

        StyleableToast.makeText(getActivity(), "Share MyTools", R.style.exampleToast).show();
        return v;
    }
}
