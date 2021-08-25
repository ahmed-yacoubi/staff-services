package com.alaqsa.edu.ps.staffservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutHomeBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutScheduleBinding;
import com.alaqsa.edu.ps.staffservices.model.Subject;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SchedulesAdapter extends RecyclerView.Adapter<SchedulesAdapter.SchedulesViewHolder> {

    private List<Subject> list;

    public SchedulesAdapter(List<Subject> testArrayList) {
        this.list = testArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public SchedulesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new SchedulesViewHolder(LayoutScheduleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SchedulesAdapter.SchedulesViewHolder holder, int position) {


        holder.binding.schTextViewCourse.setText(list.get(position).getSubject_name());
        holder.binding.schTextViewClass.setText(list.get(position).getDivision());
        holder.binding.schTextViewHill.setText(list.get(position).getHall());
        holder.binding.schTextViewTime.setText(list.get(position).getTime());
        holder.getOldPosition();
        if (position == list.size() - 1)
            holder.binding.schView.setVisibility(View.GONE);
        else holder.binding.schView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SchedulesViewHolder extends RecyclerView.ViewHolder {

        private LayoutScheduleBinding binding;

        public SchedulesViewHolder(LayoutScheduleBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
