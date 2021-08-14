package com.alaqsa.edu.ps.staffservices.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.adapter.SubjectAdapter;
import com.alaqsa.edu.ps.staffservices.model.Subject;

import java.util.ArrayList;


public class ReportsFragment extends Fragment implements Serializable {

  private static ReportsFragment instance;
  private RecyclerView recyclerView;
  private ArrayList<Subject>subjects;
  private SubjectAdapter subjectAdapter;
  private RecyclerView.LayoutManager layoutManager;
  RelativeLayout relativeLayout;
  TextView tv_dontexist;




    public ReportsFragment() {
        // Required empty public constructor
    }


    public static ReportsFragment newInstance() {
        if (instance==null){
            instance=new ReportsFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_reports, container, false);
        bind(root);
        configureRecyclerview();
        if (subjects.size()==0){
            recyclerView.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
            tv_dontexist.setText(R.string.NoOfficeHours);
        }
        return root;
    }

    private void bind(View root) {
        recyclerView=root.findViewById(R.id.reportsFragment_recyclerview);
        relativeLayout=root.findViewById(R.id.reportsFragment_layout);
        tv_dontexist=root.findViewById(R.id.reportsFragment_tv_dontexist);
    }

    private void configureRecyclerview() {
        subjects=new ArrayList<>();
//        subjects.add(new Subject("Computer Architecture","ITCS548","105","male",20,false));
//        subjects.add(new Subject("Computer Architecture","ITCS548","105","male",20,false));
//        subjects.add(new Subject("Computer Architecture","ITCS548","105","male",20,false));
//        subjects.add(new Subject("Computer Architecture","ITCS548","105","male",20,false));
        subjectAdapter=new SubjectAdapter(subjects,R.layout.layout_subject);
        layoutManager=new LinearLayoutManager(getContext());

        recyclerView.setAdapter(subjectAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        subjectAdapter.notifyDataSetChanged();
    }
}
