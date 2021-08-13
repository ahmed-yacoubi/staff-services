package com.alaqsa.edu.ps.staffservices.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.adapter.HomeAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.SchedulesViewPagerAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentHomeBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    List<Fragment> fragmentList = new ArrayList<>();
    public SchedulesViewPagerAdapter adapter;


    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        fragmentList.add(DaysFragment.newInstance("sunday"));
        fragmentList.add(DaysFragment.newInstance("monday"));
        fragmentList.add(DaysFragment.newInstance("tuesday"));
        fragmentList.add(DaysFragment.newInstance("wednesday"));
        fragmentList.add(DaysFragment.newInstance("thursday"));
        adapter = new SchedulesViewPagerAdapter(getActivity(), fragmentList);
        binding.homeViewPager.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}