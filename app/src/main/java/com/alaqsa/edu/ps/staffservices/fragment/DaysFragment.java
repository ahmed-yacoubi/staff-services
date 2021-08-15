package com.alaqsa.edu.ps.staffservices.fragment;

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
import com.alaqsa.edu.ps.staffservices.adapter.HomeAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.NotificationsAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.SchedulesAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentDaysBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentHomeBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentSchedulesBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;


public class DaysFragment extends Fragment implements Serializable {

    private static final String ARG_DATA = "data";
    private static final String ARG_TYPE = "type";
    private FragmentDaysBinding binding;

    private String mData;
    private String mType;
    private HomeAdapter adapter;
    private SchedulesAdapter schedulesAdapter;
    private ArrayList<Test> testArrayList;
    private NotificationsAdapter notificationsAdapter;

    public DaysFragment() {
    }


    public static DaysFragment newInstance(String type, String data) {
        DaysFragment fragment = new DaysFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DATA, data);
        args.putString(ARG_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mData = getArguments().getString(ARG_DATA);
            mType = getArguments().getString(ARG_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDaysBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testArrayList = new ArrayList<>();
        if (mType.equals("home")) {
            addData();
            home();

        } else if (mType.equals("schedules")) {
            addData();

            schedules();
        } else if (mType.equals("notification_msg")) {
            addDataMsg();

            notificationMessage();
        }


    }


    private void addData() {
        for (int i = 1; i <= 5; i++)
            testArrayList.add(new Test(i, "Mobile Apps", "101", "WH201",
                    "10:00-12:00", false, "ALAQSA Reg.", "SID: 2301180724, Mobile Apps Development" +
                    " 2 = 97"));
    }

    private void home() {

        adapter = new HomeAdapter(testArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.schRecyclerView.setHasFixedSize(true);
        binding.schRecyclerView.setLayoutManager(layoutManager);
        binding.schRecyclerView.setAdapter(adapter);

    }

    private void notificationMessage() {

        notificationsAdapter = new NotificationsAdapter(testArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.schRecyclerView.setHasFixedSize(true);
        binding.schRecyclerView.setLayoutManager(layoutManager);
        binding.schRecyclerView.setAdapter(notificationsAdapter);

    }

    private void addDataMsg() {
        for (int i = 1; i <= 10; i++)
            testArrayList.add(new Test(i, "Mobile Apps", "101", "WH201",
                    "10:00-12:00", false, "ALAQSA Reg.", "SID: 2301180724, Mobile Apps Development" +
                    " 2 = 97"));
    }

    private void schedules() {

        schedulesAdapter = new SchedulesAdapter(testArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.schRecyclerView.setHasFixedSize(true);
        binding.schRecyclerView.setLayoutManager(layoutManager);
        binding.schRecyclerView.setAdapter(schedulesAdapter);

    }
}