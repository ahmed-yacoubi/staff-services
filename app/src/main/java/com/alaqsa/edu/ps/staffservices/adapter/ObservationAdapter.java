package com.alaqsa.edu.ps.staffservices.adapter;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutNotificationBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutObservationBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ObservationAdapter extends RecyclerView.Adapter<ObservationAdapter.ObservationViewHolder> {

    private ArrayList<Test> testArrayList;

    public ObservationAdapter(ArrayList<Test> testArrayList) {
        this.testArrayList = testArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ObservationViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ObservationViewHolder(LayoutObservationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ObservationAdapter.ObservationViewHolder holder, int position) {
        Test test = testArrayList.get(position);
        holder.binding.obsTextViewCourse.setText(test.getCourse());
        holder.binding.obsTextViewDate.setText(test.getTime());
        holder.binding.obsTextViewPeriod.setText(test.getClasss());
        holder.binding.obsTextViewHill.setText(test.getHill());

        if (position==0){
            holder.binding.obsLinearLayoutItem.setBackgroundColor(Color.parseColor("#ffffff"));
        }else if(position%2==0){
            holder.binding.obsLinearLayoutItem.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        else{
            holder.binding.obsLinearLayoutItem.setBackgroundColor(Color.parseColor("#A8EDCBCC"));

        }

//        if (position == testArrayList.size() - 1)
//            holder.binding.obsView.setVisibility(View.GONE);
//        else holder.binding.obsView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return testArrayList.size();
    }

    class ObservationViewHolder extends RecyclerView.ViewHolder {

        private LayoutObservationBinding binding;

        public ObservationViewHolder(LayoutObservationBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
