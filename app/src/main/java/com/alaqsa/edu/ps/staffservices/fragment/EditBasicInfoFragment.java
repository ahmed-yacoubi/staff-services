package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.databinding.FragmentEditBasicInfoBinding;
import com.alaqsa.edu.ps.staffservices.fragment.dialog.DialogFragment;

import java.io.Serializable;

public class EditBasicInfoFragment extends Fragment implements Serializable {


    private FragmentEditBasicInfoBinding binding;
    private  static EditBasicInfoFragment editBasicInfoFragment;


    public interface onEditBasicInfoEventListener {
        void editBasicInfoEvent();
    }

    onEditBasicInfoEventListener editBasicInfoEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            editBasicInfoEventListener = (onEditBasicInfoEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    public EditBasicInfoFragment() {
        // Required empty public constructor
    }


    public static EditBasicInfoFragment newInstance() {
        if (editBasicInfoFragment==null){
            editBasicInfoFragment = new EditBasicInfoFragment();
        }
        return editBasicInfoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editBasicInfoEventListener.editBasicInfoEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEditBasicInfoBinding.inflate(inflater, container, false);
        binding.editBasicInfoButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment=DialogFragment.newInstance("هل تريد حفظ التعديـــلات؟",null,"نعم","لا","EditBasicInfoFragment");
                dialogFragment.show(getParentFragmentManager(),"Dialog fragment");
            }
        });

        return binding.getRoot();
    }
}