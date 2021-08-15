package com.alaqsa.edu.ps.staffservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.databinding.LayoutAttendanceBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutObservationBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttViewHolder> {

    private ArrayList<Test> testArrayList;

    public AttendanceAdapter(ArrayList<Test> testArrayList) {
        this.testArrayList = testArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public AttViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new AttViewHolder(LayoutAttendanceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AttendanceAdapter.AttViewHolder holder, int position) {
        Test test = testArrayList.get(position);
        holder.binding.attTextViewId.setText(String.valueOf(test.getId()));
        holder.binding.attTextViewName.setText(test.getCourse());

       // run switch

        if (position == testArrayList.size() - 1)
            holder.binding.attView.setVisibility(View.GONE);
        else holder.binding.attView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return testArrayList.size();
    }

    class AttViewHolder extends RecyclerView.ViewHolder {

        private LayoutAttendanceBinding binding;

        public AttViewHolder(LayoutAttendanceBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
