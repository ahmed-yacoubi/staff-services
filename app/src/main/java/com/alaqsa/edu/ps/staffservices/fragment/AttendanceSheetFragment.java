package com.alaqsa.edu.ps.staffservices.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.adapter.AttendanceAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.ObservationAdapter;
import com.alaqsa.edu.ps.staffservices.database.Database;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentAttendanceSheetBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentMidtermObservationBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;


public class AttendanceSheetFragment extends Fragment implements Serializable {

    private FragmentAttendanceSheetBinding binding;

    private AttendanceAdapter adapter;
    private Database database;
    private ArrayList<Test> testArrayList;



    public AttendanceSheetFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAttendanceSheetBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testArrayList = new ArrayList<>();

        addData();

        adapter = new AttendanceAdapter(testArrayList,getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.attSheetRecyclerView.setHasFixedSize(true);
        binding.attSheetRecyclerView.setLayoutManager(layoutManager);
        binding.attSheetRecyclerView.setAdapter(adapter);
     }

    private void addData() {
        for (int i = 1; i <= 5; i++)
            testArrayList.add(new Test(i, "احمد اليعقوبي ", "101", "WH201",
                    "10:00-12:00", false, "ALAQSA Reg.", "SID: 2301180724, Mobile Apps Development" +
                    " 2 = 97"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}