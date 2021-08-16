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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.activity.ContainerActivity;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutMenuBinding;
import com.alaqsa.edu.ps.staffservices.fragment.SchedulesFragment;
import com.alaqsa.edu.ps.staffservices.fragment.ViewStaffFragment;
import com.alaqsa.edu.ps.staffservices.model.MenuItem;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final ArrayList<MenuItem> menuItems;
    private final Context context;

    public MenuAdapter(ArrayList<MenuItem> menuItems, Context context) {
        this.menuItems = menuItems;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(LayoutMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MenuAdapter.MenuViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MenuItem menuItem = menuItems.get(position);
        holder.binding.menuImageViewIcon.setImageResource(menuItem.getIcon());
        holder.binding.menuTextViewTitle.setText(menuItem.getTitle());

        if (menuItem.getSubMenuItems() != null) {
            holder.binding.menuImageViewArrow.setVisibility(View.VISIBLE);

            SubMenuAdapter adapter = new SubMenuAdapter(menuItem.getSubMenuItems(), context);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);

            holder.binding.menuRecyclerViewSub.setHasFixedSize(true);
            holder.binding.menuRecyclerViewSub.setLayoutManager(layoutManager);
            holder.binding.menuRecyclerViewSub.setAdapter(adapter);
        } else {
            holder.binding.menuImageViewArrow.setVisibility(View.GONE);
            holder.binding.menuRecyclerViewSub.setVisibility(View.GONE);
        }

        holder.binding.menuImageViewArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuItem.isExpanded()) {
                    holder.binding.menuRecyclerViewSub.setVisibility(View.GONE);
                    holder.binding.menuImageViewArrow.setImageResource(R.drawable.ic_arrow_down);
                    menuItem.setExpanded(false);
                } else {
                    holder.binding.menuRecyclerViewSub.setVisibility(View.VISIBLE);
                    holder.binding.menuImageViewArrow.setImageResource(R.drawable.ic_arrow_up);
                    menuItem.setExpanded(true);
                }
                notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });

        holder.binding.menuLinearLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fragment", "ViewStaffFragment");
                    context.startActivity(new Intent(context, ContainerActivity.class)
                            .putExtra("bundle", bundle));
                }

                if (position == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fragment", "SettingsFragment");
                    context.startActivity(new Intent(context, ContainerActivity.class)
                            .putExtra("bundle", bundle));
                }
                if (position == 4) {
                    Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {

        private final LayoutMenuBinding binding;

        public MenuViewHolder(LayoutMenuBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
