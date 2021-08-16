package com.alaqsa.edu.ps.staffservices.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutAttendanceBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutObservationBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttViewHolder> {

    private ArrayList<Test> testArrayList;
    private Context context;

    public AttendanceAdapter(ArrayList<Test> testArrayList, Context context) {
        this.testArrayList = testArrayList;
        this.context = context;
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
        holder.binding.found.isSelected();
        holder.binding.toggle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (holder.binding.found.isChecked()) {
                    holder.binding.toggle.setBackground(ContextCompat.getDrawable(context, R.drawable.pink_out_line));

                } else if (holder.binding.notFound.isChecked()) {
                    holder.binding.toggle.setBackground(ContextCompat.getDrawable(context, R.drawable.pink_out_line_red));


                }
            }
        });
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
