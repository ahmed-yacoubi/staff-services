package com.alaqsa.edu.ps.staffservices.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.activity.ContainerActivity;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutHomeBinding;
import com.alaqsa.edu.ps.staffservices.interfaces.OnClick;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<Test> list;
    private Context context;
    private List<HomeAdapter.HomeViewHolder> holders;
    OnClick click;

    public HomeAdapter(ArrayList<Test> list, Context context, OnClick click)  {
        this.list = list;
        this.context = context;
        this.holders = new ArrayList<>();
        this.click=click;
    }

    @NonNull
    @NotNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeAdapter.HomeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Test test = list.get(position);
        holder.binding.homeTextViewCourse.setText(test.getCourse());
        holder.binding.homeTextViewClass.setText(test.getClasss());
        holder.binding.homeTextViewHill.setText(test.getHill());
        holder.binding.homeTextViewTime.setText(test.getTime());
        if (holders.size() != list.size())
            holders.add(holder);

        if (position == list.size() - 1)
            holder.binding.homeView.setVisibility(View.GONE);
        else holder.binding.homeView.setVisibility(View.VISIBLE);

        holder.binding.homeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.binding.homeImageViewArrowUp.getVisibility() == View.VISIBLE) {
                    closeTabs();
                } else {
                    openOneTab(position);
                }
                notifyDataSetChanged();

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

    private void openOneTab(int currentTab) {


        for (int i = 0; i < holders.size(); i++) {
            if (currentTab != i) {
                holders.get(i).binding.homeLinearLayoutOpe.setVisibility(View.GONE);
                holders.get(i).binding.homeTextViewAttendance.setVisibility(View.GONE);
                holders.get(i).binding.homeImageViewArrow.setImageResource(R.drawable.ic_arrow_down_black);
                holders.get(i).binding.homeImageViewArrowUp.setVisibility(View.GONE);
                holders.get(i).binding.homeImageViewArrow.setVisibility(View.VISIBLE);
            } else {

                holders.get(i).binding.homeLinearLayoutOpe.setVisibility(View.VISIBLE);
                holders.get(i).binding.homeTextViewAttendance.setVisibility(View.VISIBLE);
                holders.get(i).binding.homeImageViewArrow.setImageResource(R.drawable.ic_arrow_black);
                holders.get(i).binding.homeImageViewArrow.setVisibility(View.GONE);
                holders.get(i).binding.homeImageViewArrowUp.setVisibility(View.VISIBLE);
            }
        }

    }

    public void closeTabs() {
        if (list != null)
            for (int i = 0; i < holders.size(); i++) {
                holders.get(i).binding.homeLinearLayoutOpe.setVisibility(View.GONE);
                holders.get(i).binding.homeTextViewAttendance.setVisibility(View.GONE);
                holders.get(i).binding.homeImageViewArrowUp.setVisibility(View.GONE);
                holders.get(i).binding.homeImageViewArrow.setVisibility(View.VISIBLE);
                holders.get(i).binding.homeImageViewArrow.setImageResource(R.drawable.ic_arrow_down_black);

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
