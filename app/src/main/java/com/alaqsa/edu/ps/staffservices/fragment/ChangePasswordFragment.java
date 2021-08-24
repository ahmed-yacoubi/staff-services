package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentChangePasswordBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentHomeBinding;
import com.alaqsa.edu.ps.staffservices.fragment.dialog.DialogFragment;

import java.io.Serializable;


public class ChangePasswordFragment extends Fragment implements Serializable {
    private static ChangePasswordFragment changePasswordFragment;
    private FragmentChangePasswordBinding binding;

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

    private void shoe(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChangePasswordBinding.inflate(inflater, container, false);

        binding.changePasswordFragmentBtnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment= DialogFragment.newInstance("هل تريد",null,"yes","no","logout");
                dialogFragment.show(getFragmentManager(),"");
            }
        });


        return binding.getRoot();


    }
}
