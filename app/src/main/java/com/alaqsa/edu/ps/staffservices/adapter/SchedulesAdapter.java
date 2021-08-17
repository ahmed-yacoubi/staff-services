package com.alaqsa.edu.ps.staffservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutHomeBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutScheduleBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SchedulesAdapter extends RecyclerView.Adapter<SchedulesAdapter.SchedulesViewHolder> {

    private ArrayList<Test> testArrayList;

    public SchedulesAdapter(ArrayList<Test> testArrayList) {
        this.testArrayList = testArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public SchedulesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new SchedulesViewHolder(LayoutScheduleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SchedulesAdapter.SchedulesViewHolder holder, int position) {
        Test test = testArrayList.get(position);
        holder.binding.schTextViewCourse.setText(test.getCourse());
        holder.binding.schTextViewClass.setText(test.getClasss());
        holder.binding.schTextViewHill.setText(test.getHill());
        holder.binding.schTextViewTime.setText(test.getTime());
        holder.getOldPosition();
        if (position == testArrayList.size() - 1)
            holder.binding.schView.setVisibility(View.GONE);
        else holder.binding.schView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return testArrayList.size();
    }

    class SchedulesViewHolder extends RecyclerView.ViewHolder {

        private LayoutScheduleBinding binding;

        public SchedulesViewHolder(LayoutScheduleBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
