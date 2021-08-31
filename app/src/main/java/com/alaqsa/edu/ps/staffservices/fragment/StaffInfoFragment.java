package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.database.Database;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentStaffInfoBinding;
import com.alaqsa.edu.ps.staffservices.model.Basicinfo;
import com.alaqsa.edu.ps.staffservices.model.Employee;

import java.io.Serializable;
import java.util.List;


public class StaffInfoFragment extends Fragment {

    private Database database;
    private Employee employee;
    private FragmentStaffInfoBinding binding;

    public interface onStaffInfoEventListener {
        void staffInfoEvent();
    }

    onStaffInfoEventListener staffInfoEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            staffInfoEventListener = (onStaffInfoEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }
    //3*30=120
    //3*30=250


    public StaffInfoFragment() {
        // Required empty public constructor
    }

    public static StaffInfoFragment newInstance() {
        StaffInfoFragment fragment = new StaffInfoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Database.getInstance(getActivity());
        employee = database.getOneEmplooey(1);
        staffInfoEventListener.staffInfoEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStaffInfoBinding.inflate(inflater, container, false);
        initData();

        return binding.getRoot();

    }

    private void initData() {

        binding.staffInfoTextMob.setText(employee.getPhoneNo());
        binding.staffInfoTextViewDep.setText(employee.getDepartmentName());
        binding.staffInfoTextViewCollage.setText(employee.getCollageName());
        binding.staffInfoTextViewEmail.setText(employee.getPersonalEmail());
        binding.staffInfoTextViewName.setText(employee.getName_arb());

    }
}