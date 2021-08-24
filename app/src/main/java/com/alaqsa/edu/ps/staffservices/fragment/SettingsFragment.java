package com.alaqsa.edu.ps.staffservices.fragment;

import static com.alaqsa.edu.ps.staffservices.util.Utils.SharedPref.CHANGE_LANG;
import static com.alaqsa.edu.ps.staffservices.util.Utils.SharedPref.SHARED_PREF_NAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.activity.SplashActivity;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentAttendanceSheetBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentSettingsBinding;

import java.io.Serializable;
import java.util.Locale;

public class SettingsFragment extends Fragment implements Serializable {

    private static SettingsFragment settingsFragment;
    private FragmentSettingsBinding binding;
    private SharedPreferences sp;
    public interface onSettingsEventListener {
        void settingsEvent();
    }

    onSettingsEventListener settingsEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        sp=getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        try {
            settingsEventListener = (onSettingsEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    public SettingsFragment() {
        // Required empty public constructor
    }


    public static SettingsFragment newInstance() {
        if (settingsFragment==null){
            settingsFragment = new SettingsFragment();
        }
        return settingsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingsEventListener.settingsEvent();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        if (sp.getString(CHANGE_LANG,"ar").equals("ar")){
            binding.settingsFragmentRbEnglish.setChecked(false);
            binding.settingsFragmentRbArabic.setChecked(true);


        }else{
            binding.settingsFragmentRbEnglish.setChecked(true);
            binding.settingsFragmentRbArabic.setChecked(false);
            
        }
        changeLang();
        return binding.getRoot();
    }


    private void changeLang(){

        binding.settingsFragmentRbArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),SplashActivity.class);
                sp.edit().putString(CHANGE_LANG,"ar").apply();
                getActivity().finish();
                startActivity(intent);
                setLocale("ar");
            }
        });

        binding.settingsFragmentRbEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),SplashActivity.class);
                sp.edit().putString(CHANGE_LANG,"en").apply();
                getActivity().finish();
                startActivity(intent);
                setLocale("en");
            }
        });


    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void setLocale(String lang) {

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();

        Configuration conf = res.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            conf.setLocale(new Locale(lang.toLowerCase()));

        } else {
            conf.locale = new Locale(lang.toLowerCase());

        }

        res.updateConfiguration(conf, dm);
    }
}