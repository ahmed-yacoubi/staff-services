package com.alaqsa.edu.ps.staffservices.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.activity.ContainerActivity;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutHomeBinding;
import com.alaqsa.edu.ps.staffservices.interfaces.OnClick;
import com.alaqsa.edu.ps.staffservices.model.Subject;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<Subject> list;
    private Context context;
    private List<HomeAdapter.HomeViewHolder> holders;
    OnClick click;

    public HomeAdapter(List<Subject> list, Context context, OnClick click) {
        this.list = list;
        this.context = context;
        this.holders = new ArrayList<>();
        this.click = click;
    }

    @NonNull
    @NotNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeAdapter.HomeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.homeTextViewCourse.setText(list.get(position).getSubject_name());
        holder.binding.homeTextViewClass.setText(list.get(position).getDivision());
        holder.binding.homeTextViewHill.setText(list.get(position).getHall());
        holder.binding.homeTextViewTime.setText(list.get(position).getTime());
        if (holders.size() < list.size()) {
//            Log.d("qqqqqqq", "onBindViewHolder: ");
            holders.add(holder);
        }
        Log.d("aaaaaa", "onBindViewHolder: " + holders.size() + " , " + list.size());

        if (position == list.size() - 1)
            holder.binding.homeView.setVisibility(View.GONE);
        else holder.binding.homeView.setVisibility(View.VISIBLE);

        holder.binding.homeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.binding.homeImageViewArrowUp.getVisibility() == View.VISIBLE) {
                    Toast.makeText(context, "DONE", Toast.LENGTH_SHORT).show();
                    closeTabs();
                    holder.binding.homeLinearLayoutOpe.setVisibility(View.GONE);
                    holder.binding.homeTextViewAttendance.setVisibility(View.GONE);
                    holder.binding.homeImageViewArrow.setVisibility(View.VISIBLE);
                    holder.binding.homeImageViewArrowUp.setVisibility(View.GONE);
                } else {
                    closeTabs();
                    holder.binding.homeLinearLayoutOpe.setVisibility(View.VISIBLE);
                    holder.binding.homeTextViewAttendance.setVisibility(View.VISIBLE);
                    holder.binding.homeImageViewArrow.setVisibility(View.GONE);
                    holder.binding.homeImageViewArrowUp.setVisibility(View.VISIBLE);

                }


            }
        });

        holder.binding.homeTextViewAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("fragment", "AttendanceSheetFragment");
                context.startActivity(new Intent(context, ContainerActivity.class)
                        .putExtra("bundle", bundle));
            }
        });
        holder.binding.homeTextViewChDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onChangeDate();

            }
        });

        holder.binding.homeTextViewApologize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onApologize();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

 
    public void closeTabs() {
        if (list != null)
            for (int i = 0; i < holders.size(); i++) {
                holders.get(i).binding.homeLinearLayoutOpe.setVisibility(View.GONE);
                holders.get(i).binding.homeTextViewAttendance.setVisibility(View.GONE);
                holders.get(i).binding.homeImageViewArrowUp.setVisibility(View.GONE);
                holders.get(i).binding.homeImageViewArrow.setVisibility(View.VISIBLE);

            }
    }


    class HomeViewHolder extends RecyclerView.ViewHolder {

        private LayoutHomeBinding binding;

        public HomeViewHolder(LayoutHomeBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
