package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;

import java.io.Serializable;

public class SettingsFragment extends Fragment implements Serializable {

    private static SettingsFragment settingsFragment;

    public interface onSettingsEventListener {
        void settingsEvent();
    }

    onSettingsEventListener settingsEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
}