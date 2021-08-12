package com.alaqsa.edu.ps.staffservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutHomeBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<Test> testArrayList;

    public HomeAdapter(ArrayList<Test> testArrayList) {
        this.testArrayList = testArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutHomeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeAdapter.HomeViewHolder holder, int position) {
        Test test = testArrayList.get(position);
        holder.binding.homeTextViewCourse.setText(test.getCourse());
        holder.binding.homeTextViewClass.setText(test.getClasss());
        holder.binding.homeTextViewHill.setText(test.getHill());
        holder.binding.homeTextViewTime.setText(test.getTime());

        if (position == testArrayList.size() - 1)
            holder.binding.homeView.setVisibility(View.GONE);
        else holder.binding.homeView.setVisibility(View.VISIBLE);

        holder.binding.homeImageViewArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (test.isExpanded()) {
                    holder.binding.homeLinearLayoutOpe.setVisibility(View.GONE);
                    holder.binding.homeTextViewAttendance.setVisibility(View.GONE);
                    holder.binding.homeImageViewArrow.setImageResource(R.drawable.ic_arrow_down);
                    test.setExpanded(false);
                } else {
                    holder.binding.homeLinearLayoutOpe.setVisibility(View.VISIBLE);
                    holder.binding.homeTextViewAttendance.setVisibility(View.VISIBLE);
                    holder.binding.homeImageViewArrow.setImageResource(R.drawable.ic_arrow_up);
                    test.setExpanded(true);
                }
                notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return testArrayList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        private LayoutHomeBinding binding;

        public HomeViewHolder(LayoutHomeBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
