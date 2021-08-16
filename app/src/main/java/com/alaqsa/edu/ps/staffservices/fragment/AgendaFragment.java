package com.alaqsa.edu.ps.staffservices.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.database.Database;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentAgendaBinding;
import com.alaqsa.edu.ps.staffservices.model.Agenda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgendaFragment extends Fragment {

    private FragmentAgendaBinding binding;
    private Database database;
    private Agenda agenda;

    public AgendaFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Database.getInstance(getActivity());
        getDataFromDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAgendaBinding.inflate(inflater, container, false);
        initTextView();
        return binding.getRoot();

    }

    private void initTextView() {

        binding.AgendaTvFinalEnd.setText(agenda.getStart_final_exam());
        binding.AgendaTvFinalStart.setText(agenda.getStart_final_exam());
        binding.AgendaTvEndOfDraw.setText(agenda.getEnd_semester());
        binding.AgendaTvFinalEntryEnd.setText(agenda.getEnd_semester());
        binding.AgendaTvMidtermEnd.setText(agenda.getStart_midterm());
        binding.AgendaTvMidtermStart.setText(agenda.getBeginning_semester());
        binding.AgendaTvMidtermStart.setText(agenda.getBeginning_semester());
        binding.AgendaTvMidtermStart.setText(agenda.getBeginning_semester());
        binding.AgendaTvMidtermStart.setText(agenda.getBeginning_semester());
        binding.AgendaTvMidtermStart.setText(agenda.getBeginning_semester());
        binding.AgendaTvMidtermStart.setText(agenda.getBeginning_semester());
        binding.AgendaTvMidtermStart.setText(agenda.getBeginning_semester());


    }


    private void getDataFromDatabase() {

        agenda = database.getAgenda().get(0);
    }
}
