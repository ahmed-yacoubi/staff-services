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
import com.alaqsa.edu.ps.staffservices.databinding.FragmentHomeBinding;
import com.alaqsa.edu.ps.staffservices.fragment.dialog.DialogFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    List<Fragment> fragmentList = new ArrayList<>();
    public SchedulesViewPagerAdapter adapter;

    public interface onHomeEventListener {
        void homeEvent();
    }

    HomeFragment.onHomeEventListener homeEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            homeEventListener = (HomeFragment.onHomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }



    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeEventListener.homeEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initViewPager();
        initTabLayout();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


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
        fragmentList.add(ContainerTabFragment.newInstance("home", "sunday"));
        fragmentList.add(ContainerTabFragment.newInstance("home", "monday"));
        fragmentList.add(ContainerTabFragment.newInstance("home", "tuesday"));
        fragmentList.add(ContainerTabFragment.newInstance("home", "wednesday"));
        fragmentList.add(ContainerTabFragment.newInstance("home", "thursday"));
        adapter = new SchedulesViewPagerAdapter(getActivity(), fragmentList);
        binding.homeViewPager.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}