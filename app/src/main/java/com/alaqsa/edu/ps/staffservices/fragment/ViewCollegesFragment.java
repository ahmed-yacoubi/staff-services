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
import android.widget.Toast;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.adapter.ViewCollegesAdapter;
import com.alaqsa.edu.ps.staffservices.adapter.ViewStaffAdapter;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentViewCollegesBinding;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentViewStaffBinding;
import com.alaqsa.edu.ps.staffservices.model.Employee;

import java.util.ArrayList;
import java.util.List;


public class ViewCollegesFragment extends Fragment {

    FragmentViewCollegesBinding binding;

    ViewCollegesAdapter adapter;



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ViewCollegesFragment() {
        // Required empty public constructor
    }

    public static ViewCollegesFragment newInstance(String param1, String param2) {
        ViewCollegesFragment fragment = new ViewCollegesFragment();
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
        binding = FragmentViewCollegesBinding.inflate(inflater, container, false);
        return binding.getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


         Toast.makeText(getActivity(), "View College", Toast.LENGTH_SHORT).show();


        adapter = new ViewCollegesAdapter(addArrayList(), getContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        binding.viewCollegeRecyclerView.setHasFixedSize(true);
        binding.viewCollegeRecyclerView.setLayoutManager(layoutManager);
        binding.viewCollegeRecyclerView.setAdapter(adapter);

    }


    public ArrayList<String>addArrayList (){
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Java100");
        arrayList.add("Java101");
        arrayList.add("Java102");
        arrayList.add("Java104");
        return arrayList;
    }
}