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
import com.alaqsa.edu.ps.staffservices.databinding.FragmentHomeBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentNotificationsBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    private NotificationsAdapter adapter;

    private ArrayList<Test> testArrayList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotificationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationsFragment newInstance(String param1, String param2) {
        NotificationsFragment fragment = new NotificationsFragment();
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
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testArrayList = new ArrayList<>();

        addData();

        adapter = new NotificationsAdapter(testArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.notiRecyclerView.setHasFixedSize(true);
        binding.notiRecyclerView.setLayoutManager(layoutManager);
        binding.notiRecyclerView.setAdapter(adapter);

    }

    private void addData() {
        for (int i=1; i<=10; i++)
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