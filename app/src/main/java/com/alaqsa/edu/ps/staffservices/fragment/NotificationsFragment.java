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
import com.alaqsa.edu.ps.staffservices.adapter.SchedulesViewPagerAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentHomeBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentNotificationsBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

List<Fragment> fragmentList = new ArrayList<>();
    public SchedulesViewPagerAdapter adapter;
    public NotificationsFragment() {
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
         binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViewPager();

        initTabLayout();



    }


    private void initTabLayout() {


        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.homeTapLayout, binding.homeViewPager, new TabLayoutMediator.TabConfigurationStrategy() {

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("الإشعارات");

                        break;
                    case 1:
                        tab.setText("الرسائل");
                        break;


                }

            }
        });
        tabLayoutMediator.attach();

    }


    private void initViewPager() {
        fragmentList.add(DaysFragment.newInstance("notification_msg","notification"));
        fragmentList.add(DaysFragment.newInstance("notification_msg","msg"));

        adapter = new SchedulesViewPagerAdapter(getActivity(), fragmentList);
        binding.homeViewPager.setAdapter(adapter);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}