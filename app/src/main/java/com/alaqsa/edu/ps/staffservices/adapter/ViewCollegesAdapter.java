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
import com.alaqsa.edu.ps.staffservices.databinding.LayoutObservationBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutStaffBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutcollegesBinding;
import com.alaqsa.edu.ps.staffservices.model.Employee;

import java.util.List;

public class ViewCollegesAdapter extends RecyclerView.Adapter<ViewCollegesAdapter.CollegesViewHolder> {

    private List<String> list;
    private Context context;


    public ViewCollegesAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CollegesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CollegesViewHolder(LayoutcollegesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CollegesViewHolder holder, int position) {
        holder.binding.tvAdapterCollege.setText(list.get(position));

        holder.binding.adapterViewCollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("fragment", "ViewStaffFragment");
                context.startActivity(new Intent(context, ContainerActivity.class)
                        .putExtra("bundle", bundle));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CollegesViewHolder extends RecyclerView.ViewHolder {

        LayoutcollegesBinding binding;
        public CollegesViewHolder( LayoutcollegesBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
