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


import com.alaqsa.edu.ps.staffservices.adapter.SchedulesViewPagerAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentSchedulesBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SchedulesFragment extends Fragment implements Serializable {

    private FragmentSchedulesBinding binding;
    List<Fragment> fragmentList = new ArrayList<>();
    public SchedulesViewPagerAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public SchedulesFragment() {
        // Required empty public constructor
    }


    public static SchedulesFragment newInstance(String param1, String param2) {
        SchedulesFragment fragment = new SchedulesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSchedulesBinding.inflate(inflater, container, false);
        initViewPager();
        initTabLayout();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        testArrayList = new ArrayList<>();

//        addData();
//
//        adapter = new SchedulesAdapter(testArrayList);
//

    }

//    private void addData() {
//        for (int i = 1; i <= 5; i++)
//            testArrayList.add(new Test(i, "Mobile Apps", "101", "WH201",
//                    "10:00-12:00", false, "ALAQSA Reg.", "SID: 2301180724, Mobile Apps Development" +
//                    " 2 = 97"));
//    }
    private void initTabLayout() {


        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.homeTapLayout, binding.homeViewPager, new TabLayoutMediator.TabConfigurationStrategy() {

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("الاحد");

                        break;
                    case 1:
                        tab.setText("الاثنين");
                        break;

                    case 2:

                        tab.setText("الثلاثاء");

                        break;
                    case 3:
                        tab.setText("الاربعاء");

                        break;
                    case 4:
                        tab.setText("الخميس");

                        break;

                }

            }
        });
        tabLayoutMediator.attach();

    }


    private void initViewPager() {
        fragmentList.add(DaysFragment.newInstance("schedules", "sunday"));
        fragmentList.add(DaysFragment.newInstance("schedules", "monday"));
        fragmentList.add(DaysFragment.newInstance("schedules", "tuesday"));
        fragmentList.add(DaysFragment.newInstance("schedules", "wednesday"));
        fragmentList.add(DaysFragment.newInstance("schedules", "thursday"));
        adapter = new SchedulesViewPagerAdapter(getActivity(), fragmentList);
        binding.homeViewPager.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}