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
import com.alaqsa.edu.ps.staffservices.databinding.LayoutNotificationBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutStaffBinding;
import com.alaqsa.edu.ps.staffservices.fragment.StaffInfoFragment;
import com.alaqsa.edu.ps.staffservices.fragment.ViewStaffFragment;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ViewStaffAdapter extends RecyclerView.Adapter<ViewStaffAdapter.StaffViewHolder> {

    private ArrayList<Test> testArrayList;
    private Context context;

    public ViewStaffAdapter(ArrayList<Test> testArrayList, Context context) {
        this.testArrayList = testArrayList;
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
        Test test = testArrayList.get(position);
        holder.binding.vstaffTextViewName.setText(test.getTitle());
        holder.binding.vstaffTextViewFaculty.setText(test.getCourse());

        holder.binding.vstaffCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("fragment", new StaffInfoFragment());
                context.startActivity(new Intent(context, ContainerActivity.class)
                        .putExtra("bundle", bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        return testArrayList.size();
    }

    class StaffViewHolder extends RecyclerView.ViewHolder {

        private LayoutStaffBinding binding;

        public StaffViewHolder(LayoutStaffBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}