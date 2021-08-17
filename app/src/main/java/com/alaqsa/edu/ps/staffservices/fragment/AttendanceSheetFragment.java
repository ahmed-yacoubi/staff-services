package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
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
import com.alaqsa.edu.ps.staffservices.databinding.FragmentAttendanceSheetBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentMidtermObservationBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AttendanceSheetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AttendanceSheetFragment extends Fragment implements Serializable {

    private FragmentAttendanceSheetBinding binding;

    private AttendanceAdapter adapter;

    private ArrayList<Test> testArrayList;

    public interface onAttendanceEventListener {
        void attendanceEvent();
    }

    onAttendanceEventListener attendanceEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            attendanceEventListener = (onAttendanceEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AttendanceSheetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MidtermObservationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AttendanceSheetFragment newInstance(String param1, String param2) {
        AttendanceSheetFragment fragment = new AttendanceSheetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        attendanceEventListener.attendanceEvent();
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

        adapter = new AttendanceAdapter(testArrayList,getContext().getApplicationContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.attSheetRecyclerView.setHasFixedSize(true);
        binding.attSheetRecyclerView.setLayoutManager(layoutManager);
        binding.attSheetRecyclerView.setAdapter(adapter);

    }

    private void addData() {
        for (int i=1; i<=5; i++)
            testArrayList.add(new Test(i, "Mobile Apps", "101", "WH201",
                    "10:00-12:00", false, "ALAQSA Reg.", "SID: 2301180724, Mobile Apps Development" +
                    " 2 = 97"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}