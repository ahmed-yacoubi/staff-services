package com.alaqsa.edu.ps.staffservices.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.activity.ContainerActivity;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutMenuSubBinding;
import com.alaqsa.edu.ps.staffservices.fragment.AgendaFragment;
import com.alaqsa.edu.ps.staffservices.fragment.SchedulesFragment;
import com.alaqsa.edu.ps.staffservices.fragment.ViewStaffFragment;
import com.alaqsa.edu.ps.staffservices.model.SubMenuItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SubMenuAdapter extends RecyclerView.Adapter<SubMenuAdapter.SubMenuViewHolder> {

    private final ArrayList<SubMenuItem> subMenuItems;
    private final Context context;

    public SubMenuAdapter(ArrayList<SubMenuItem> subMenuItems, Context context) {
        this.subMenuItems = subMenuItems;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public SubMenuViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new SubMenuViewHolder(LayoutMenuSubBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SubMenuAdapter.SubMenuViewHolder holder, int position) {
        SubMenuItem subMenuItem = subMenuItems.get(position);
        holder.binding.menuImageViewSubIcon.setImageResource(subMenuItem.getIcon());
        holder.binding.menuTextViewSubTitle.setText(subMenuItem.getTitle());

//        holder.binding.menuLinearLayoutSubItem.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("NonConstantResourceId")
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                switch (subMenuItem.getIcon()) {
//                    case R.drawable.ic_agenda: bundle.putSerializable("fragment", new AgendaFragment());
//                        break;
//                    case R.drawable.ic_schedules2: bundle.putSerializable("fragment", new ViewStaffFragment());
//                        break;
//                    case R.drawable.ic_reports: bundle.putSerializable("fragment", new SchedulesFragment());
//                        break;
//
//                }
//                context.startActivity(new Intent(context, ContainerActivity.class)
//                        .putExtra("bundle", bundle));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return subMenuItems.size();
    }

    static class SubMenuViewHolder extends RecyclerView.ViewHolder {

        private final LayoutMenuSubBinding binding;

        public SubMenuViewHolder(LayoutMenuSubBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
