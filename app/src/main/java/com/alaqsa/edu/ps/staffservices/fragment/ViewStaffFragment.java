package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.adapter.NotificationsAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.ViewStaffAdapter;
import com.alaqsa.edu.ps.staffservices.database.Database;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentNotificationsBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentViewStaffBinding;
import com.alaqsa.edu.ps.staffservices.model.Employee;
import com.alaqsa.edu.ps.staffservices.model.Test;
import com.alaqsa.edu.ps.staffservices.other.CheckInternet;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ViewStaffFragment extends Fragment  {

    private FragmentViewStaffBinding binding;

    private ViewStaffAdapter adapter;
    private Database database;
    private List<Employee> list;

    public interface onViewStaffEventListener {
        void viewStaffEvent();
    }

    onViewStaffEventListener viewStaffEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            viewStaffEventListener = (onViewStaffEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }


    public ViewStaffFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewStaffEventListener.viewStaffEvent();

        database = Database.getInstance(getActivity());
        if (CheckInternet.isConnected()) {
            list = database.getLastEmployees();
        } else {

            // list = GETAPIDATA();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentViewStaffBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = new ArrayList<>();


        adapter = new ViewStaffAdapter(list, getContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.vstaffRecyclerView.setHasFixedSize(true);
        binding.vstaffRecyclerView.setLayoutManager(layoutManager);
        binding.vstaffRecyclerView.setAdapter(adapter);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
