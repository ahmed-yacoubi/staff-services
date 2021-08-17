package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;

import java.io.Serializable;


public class ChangePasswordFragment extends Fragment implements Serializable {
    private static ChangePasswordFragment changePasswordFragment;


    public interface onChangePasswordEventListener {
        void changePasswordEvent();
    }

    onChangePasswordEventListener changePasswordEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            changePasswordEventListener = (onChangePasswordEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    public ChangePasswordFragment() {
        // Required empty public constructor
    }


    public static ChangePasswordFragment newInstance() {
        if (changePasswordFragment==null){
            changePasswordFragment = new ChangePasswordFragment();
        }
        return changePasswordFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change_password, container, false);
    }
}
