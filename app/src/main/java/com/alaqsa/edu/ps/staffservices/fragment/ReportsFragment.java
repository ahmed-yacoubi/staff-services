package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.adapter.SchedulesViewPagerAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.SubjectAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentReportsBinding;
import com.alaqsa.edu.ps.staffservices.model.Subject;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ReportsFragment extends Fragment {

    private static ReportsFragment instance;

    private FragmentReportsBinding binding;

    private List<Fragment> fragmentList;
    public SchedulesViewPagerAdapter adapter;

    public interface onReportsEventListener {
        void reportsEvent();
    }

    onReportsEventListener reportsEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            reportsEventListener = (onReportsEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    public ReportsFragment() {
        // Required empty public constructor
    }


    public static ReportsFragment newInstance() {
        if (instance == null) {
            instance = new ReportsFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reportsEventListener.reportsEvent();
        fragmentList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReportsBinding.inflate(inflater, container, false);


        initViewPager();

        initTabLayout();
        return binding.getRoot();
    }

    private void initTabLayout() {


        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.homeTapLayout, binding.homeViewPager, new TabLayoutMediator.TabConfigurationStrategy() {

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("الساعات النظامية");

                        break;
                    case 1:
                        tab.setText("الساعات المكتبية");
                        break;
                    case 2:
                        tab.setText("مساقات الغير مكتمل");
                        break;


                }

            }
        });
        tabLayoutMediator.attach();

    }


    private void initViewPager() {
        fragmentList.add(ContainerTabFragment.newInstance("report", "regularHours"));
        fragmentList.add(ContainerTabFragment.newInstance("report", "officeHours"));
        fragmentList.add(ContainerTabFragment.newInstance("report", "incompleteCourses"));

        adapter = new SchedulesViewPagerAdapter(getActivity(), fragmentList);
        binding.homeViewPager.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}