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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.adapter.HomeAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.NotificationsAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.SchedulesAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.SubjectAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentTabContainerBinding;
import com.alaqsa.edu.ps.staffservices.model.Subject;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;


public class ContainerTabFragment extends Fragment implements Serializable {

    private static final String ARG_DATA = "data";
    private static final String ARG_TYPE = "type";
    private FragmentTabContainerBinding binding;
    private String mData;
    private String mType;
    private HomeAdapter adapter;
    private SchedulesAdapter schedulesAdapter;
    private ArrayList<Test> testArrayList;
    private NotificationsAdapter notificationsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String textView;
    private ArrayList<Subject> subjects;
    private SubjectAdapter subjectAdapter;

    public ContainerTabFragment() {
    }


    public static ContainerTabFragment newInstance(String type, String data) {
        ContainerTabFragment fragment = new ContainerTabFragment();
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
            layoutManager = new LinearLayoutManager(getContext());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTabContainerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testArrayList = new ArrayList<>();
        switch (mType) {

            case "home":
                addData();
                initHome();
                if (testArrayList.size() == 0) {
                    binding.schRecyclerView.setVisibility(View.GONE);
                    binding.reportsFragmentIv.setVisibility(View.VISIBLE);
                    binding.reportsFragmentTvDontexist.setVisibility(View.VISIBLE);
                    binding.reportsFragmentLayout.setVisibility(View.VISIBLE);
                    binding.reportsFragmentTvDontexist.setText(R.string.subject_id);

                } else {

                    binding.schRecyclerView.setVisibility(View.VISIBLE);
                    binding.reportsFragmentIv.setVisibility(View.GONE);
                    binding.reportsFragmentTvDontexist.setVisibility(View.GONE);
                    binding.reportsFragmentLayout.setVisibility(View.GONE);
                }
                break;

            case "schedules":

                addData();

                initSchedules();
                if (testArrayList.size() == 0) {
                    binding.schRecyclerView.setVisibility(View.GONE);
                    binding.reportsFragmentIv.setVisibility(View.VISIBLE);
                    binding.reportsFragmentTvDontexist.setVisibility(View.VISIBLE);
                    binding.reportsFragmentLayout.setVisibility(View.VISIBLE);
                    binding.reportsFragmentTvDontexist.setText("لا يوجد محاضرات لهذا اليوم ");

                } else {

                    binding.schRecyclerView.setVisibility(View.VISIBLE);
                    binding.reportsFragmentIv.setVisibility(View.GONE);
                    binding.reportsFragmentTvDontexist.setVisibility(View.GONE);
                    binding.reportsFragmentLayout.setVisibility(View.GONE);
                }
                break;

            case "notification_msg":
                addDataMsg();

                initNotificationMessage();
                if (testArrayList.size() == 0) {
                    binding.schRecyclerView.setVisibility(View.GONE);
                    binding.reportsFragmentIv.setVisibility(View.VISIBLE);
                    binding.reportsFragmentTvDontexist.setVisibility(View.VISIBLE);
                    binding.reportsFragmentLayout.setVisibility(View.VISIBLE);
                    binding.reportsFragmentTvDontexist.setText(" لا يوجد اشعارات ");

                } else {

                    binding.schRecyclerView.setVisibility(View.VISIBLE);
                    binding.reportsFragmentIv.setVisibility(View.GONE);
                    binding.reportsFragmentTvDontexist.setVisibility(View.GONE);
                    binding.reportsFragmentLayout.setVisibility(View.GONE);
                }
                break;

            case "report":
                addReportData();
                initReport();
                if (subjects.size() == 0) {
                    binding.schRecyclerView.setVisibility(View.GONE);
                    binding.reportsFragmentIv.setVisibility(View.VISIBLE);
                    binding.reportsFragmentTvDontexist.setVisibility(View.VISIBLE);
                    binding.reportsFragmentLayout.setVisibility(View.VISIBLE);
                    binding.reportsFragmentTvDontexist.setText(" لا يوجد تقارير ");

                } else {

                    binding.schRecyclerView.setVisibility(View.VISIBLE);
                    binding.reportsFragmentIv.setVisibility(View.GONE);
                    binding.reportsFragmentTvDontexist.setVisibility(View.GONE);
                    binding.reportsFragmentLayout.setVisibility(View.GONE);
                }
                break;
        }


    }

    private void initReport() {

        subjectAdapter = new SubjectAdapter(subjects, R.layout.layout_subject);
        layoutManager = new LinearLayoutManager(getContext());

        binding.schRecyclerView.setAdapter(subjectAdapter);
        binding.schRecyclerView.setLayoutManager(layoutManager);
        binding.schRecyclerView.setHasFixedSize(true);
        subjectAdapter.notifyDataSetChanged();
    }

    private void addReportData() {
        subjects = new ArrayList<>();
        subjects.add(new Subject("Computer Architecture", "ITCS548", "105", "male", 20, false));
        subjects.add(new Subject("Computer Architecture", "ITCS548", "105", "male", 20, false));
        subjects.add(new Subject("Computer Architecture", "ITCS548", "105", "male", 20, false));
        subjects.add(new Subject("Computer Architecture", "ITCS548", "105", "male", 20, false));


    }


    private void addData() {
        for (int i = 1; i <= 5; i++)
            testArrayList.add(new Test(i, "Mobile Apps", "101", "WH201",
                    "10:00-12:00", false, "ALAQSA Reg.", "SID: 2301180724, Mobile Apps Development" +
                    " 2 = 97"));
    }

    private void initHome() {

        adapter = new HomeAdapter(testArrayList, getContext());


        binding.schRecyclerView.setHasFixedSize(true);
        binding.schRecyclerView.setLayoutManager(layoutManager);
        binding.schRecyclerView.setAdapter(adapter);

    }


    private void initNotificationMessage() {

        notificationsAdapter = new NotificationsAdapter(testArrayList);


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

    private void initSchedules() {

        schedulesAdapter = new SchedulesAdapter(testArrayList);


        binding.schRecyclerView.setHasFixedSize(true);
        binding.schRecyclerView.setLayoutManager(layoutManager);
        binding.schRecyclerView.setAdapter(schedulesAdapter);

    }


    @Override
    public void onPause() {
        super.onPause();
        try {
            if (adapter != null)
                adapter.closeTabs();

        } catch (Exception e) {

        }
        try {
            if (subjectAdapter != null)
                subjectAdapter.closeTabs();

        } catch (Exception e) {

        }

    }
}