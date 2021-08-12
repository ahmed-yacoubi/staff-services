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
import com.alaqsa.edu.ps.staffservices.adapter.MenuAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentMenuBinding;
import com.alaqsa.edu.ps.staffservices.model.MenuItem;
import com.alaqsa.edu.ps.staffservices.model.SubMenuItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;

    private MenuAdapter adapter;

    private ArrayList<MenuItem> menuItems;
    private ArrayList<SubMenuItem> academicSubMenuItems, administrativeSubMenuItems, settingsSubMenuItems;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

        // Settings Menu
        settingsSubMenuItems.add(new SubMenuItem(R.drawable.ic_cancel_notifications,
                getString(R.string.cancel_notifications)));
        settingsSubMenuItems.add(new SubMenuItem(R.drawable.ic_change_language,
                getString(R.string.change_language)));
        settingsSubMenuItems.add(new SubMenuItem(R.drawable.ic_change_password,
                getString(R.string.change_password)));

        menuItems.add(new MenuItem(R.drawable.ic_settings, getString(R.string.settings),
                false, settingsSubMenuItems));

        // Logout
        menuItems.add(new MenuItem(R.drawable.ic_logout, getString(R.string.logout),
                false, null));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}