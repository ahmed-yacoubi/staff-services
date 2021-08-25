package com.alaqsa.edu.ps.staffservices.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.activity.ContainerActivity;

import com.alaqsa.edu.ps.staffservices.databinding.LayoutStaffBinding;
import com.alaqsa.edu.ps.staffservices.fragment.StaffInfoFragment;
import com.alaqsa.edu.ps.staffservices.fragment.ViewStaffFragment;
import com.alaqsa.edu.ps.staffservices.model.Employee;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewStaffAdapter extends RecyclerView.Adapter<ViewStaffAdapter.StaffViewHolder> {

    private List<Employee> list;
    private Context context;

    public ViewStaffAdapter(List<Employee> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new StaffViewHolder(LayoutStaffBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewStaffAdapter.StaffViewHolder holder, int position) {
        holder.binding.vstaffTextViewName.setText(list.get(position).getName_eng());
        holder.binding.vstaffTextViewFaculty.setText(list.get(position).getCollageName());
        holder.binding.tvDepartment.setText(list.get(position).getDepartmentName());

        holder.binding.vstaffCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("fragment", "StaffInfoFragment");
                context.startActivity(new Intent(context, ContainerActivity.class)
                        .putExtra("bundle", bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StaffViewHolder extends RecyclerView.ViewHolder {

        private LayoutStaffBinding binding;

        public StaffViewHolder(LayoutStaffBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
