package com.alaqsa.edu.ps.staffservices.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;

import java.io.Serializable;

public class AgendaFragment extends Fragment implements Serializable {

   private static AgendaFragment agendaFragment;


    public AgendaFragment() {
        // Required empty public constructor
    }


    public static AgendaFragment newInstance() {
        if (agendaFragment==null){
            agendaFragment = new AgendaFragment();
        }

        return agendaFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agenda, container, false);
    }
}
