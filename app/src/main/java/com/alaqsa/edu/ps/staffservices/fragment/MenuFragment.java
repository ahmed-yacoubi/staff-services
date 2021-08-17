package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
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
import com.alaqsa.edu.ps.staffservices.adapter.MenuAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentMenuBinding;
import com.alaqsa.edu.ps.staffservices.model.MenuItem;
import com.alaqsa.edu.ps.staffservices.model.SubMenuItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;

    private MenuAdapter adapter;

    private ArrayList<MenuItem> menuItems;
    private ArrayList<SubMenuItem> academicSubMenuItems, administrativeSubMenuItems, settingsSubMenuItems;


    public interface onMenuEventListener {
        void menuEvent();
    }

    onMenuEventListener menuEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            menuEventListener = (onMenuEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    public MenuFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuEventListener.menuEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menuItems = new ArrayList<>();
        academicSubMenuItems = new ArrayList<>();
        administrativeSubMenuItems =  new ArrayList<>();
        settingsSubMenuItems = new ArrayList<>();

        addData();

        adapter = new MenuAdapter(menuItems, getContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.menuRecyclerView.setHasFixedSize(true);
        binding.menuRecyclerView.setLayoutManager(layoutManager);
        binding.menuRecyclerView.setAdapter(adapter);

    }

    private void addData() {
        // Academic Menu
        academicSubMenuItems.add(new SubMenuItem(R.drawable.ic_agenda,
                getString(R.string.agenda)));
        academicSubMenuItems.add(new SubMenuItem(R.drawable.ic_schedules2,
                getString(R.string.schedules)));
        academicSubMenuItems.add(new SubMenuItem(R.drawable.ic_reports,
                getString(R.string.reports)));
        academicSubMenuItems.add(new SubMenuItem(R.drawable.ic_observation,
                getString(R.string.midterm_observation)));
        academicSubMenuItems.add(new SubMenuItem(R.drawable.ic_observation,
                getString(R.string.final_observation)));

        menuItems.add(new MenuItem(R.drawable.ic_academic, getString(R.string.academic_services),
                false, academicSubMenuItems));

        // Administrative Menu
        administrativeSubMenuItems.add(new SubMenuItem(R.drawable.ic_basic_info,
                getString(R.string.basic_info)));
        administrativeSubMenuItems.add(new SubMenuItem(R.drawable.ic_job_info,
                getString(R.string.job_info)));

        menuItems.add(new MenuItem(R.drawable.ic_administrative, getString(R.string.administrative_services),
                false, administrativeSubMenuItems));

        // Staff
        menuItems.add(new MenuItem(R.drawable.ic_staff, getString(R.string.view_staff),
                false, null));


        menuItems.add(new MenuItem(R.drawable.ic_settings, getString(R.string.settings),
                false, null));

        // Logout
        menuItems.add(new MenuItem(R.drawable.ic_logout, getString(R.string.logout),
                false, null));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onPause() {
        super.onPause();

        adapter.closeTabs();
    }
}