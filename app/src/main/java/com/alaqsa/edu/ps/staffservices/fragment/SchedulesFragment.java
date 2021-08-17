package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.alaqsa.edu.ps.staffservices.adapter.SchedulesViewPagerAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentSchedulesBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SchedulesFragment extends Fragment  {

    private FragmentSchedulesBinding binding;
    List<Fragment> fragmentList = new ArrayList<>();
    public SchedulesViewPagerAdapter adapter;


    public interface onSchedulesEventListener {
        void schedulesEvent();
    }

    SchedulesFragment.onSchedulesEventListener schedulesEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            schedulesEventListener = (SchedulesFragment.onSchedulesEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }


    public SchedulesFragment() {
        // Required empty public constructor
    }


    public static SchedulesFragment newInstance() {
        SchedulesFragment fragment = new SchedulesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schedulesEventListener.schedulesEvent();
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
        fragmentList.add(ContainerTabFragment.newInstance("schedules", "sunday"));
        fragmentList.add(ContainerTabFragment.newInstance("schedules", "monday"));
        fragmentList.add(ContainerTabFragment.newInstance("schedules", "tuesday"));
        fragmentList.add(ContainerTabFragment.newInstance("schedules", "wednesday"));
        fragmentList.add(ContainerTabFragment.newInstance("schedules", "thursday"));
        adapter = new SchedulesViewPagerAdapter(getActivity(), fragmentList);
        binding.homeViewPager.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}