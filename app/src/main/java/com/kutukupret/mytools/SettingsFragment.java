package com.kutukupret.mytools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muddzdev.styleabletoast.StyleableToast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment  implements View.OnClickListener {

    private TextView tv_mikhmon;
    private EditText et_mikhmon;
    private TextView tv_pihole;
    private EditText et_pihole;

    private Button saveButton;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String MIKHMON = "mikhmon";
    public static final String PIHOLE = "pihole";

    private String text_mikhmon;
    private String text_pihole;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_chat, container, false);
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        tv_mikhmon = (TextView)v.findViewById(R.id.tv_mikhmon);
        et_mikhmon = (EditText)v.findViewById(R.id.et_mikhmon);
        tv_pihole = (TextView)v.findViewById(R.id.tv_pihole);
        et_pihole = (EditText)v.findViewById(R.id.et_pihole);
        saveButton = (Button)v.findViewById(R.id.save_button);
        saveButton.setOnClickListener(this);


        loadData();
        updateViews();

        return v;
    }

    @Override
    public void onClick(View v) {
        saveData();
    }
    public void saveData() {
        SharedPreferences pref = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(MIKHMON, et_mikhmon.getText().toString());
        editor.putString(PIHOLE, et_pihole.getText().toString());

        editor.apply();

        StyleableToast.makeText(getActivity(), "Data saved", R.style.exampleToast).show();
    }

    public void loadData() {
        SharedPreferences pref = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        text_mikhmon = pref.getString(MIKHMON, "");
        text_pihole = pref.getString(PIHOLE, "");
    }

    public void updateViews() {
        tv_mikhmon.setText(text_mikhmon);
        tv_pihole.setText(text_pihole);
    }
}
