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
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final ArrayList<MenuItem> menuItems;
    private final Context context;
    private List<MenuAdapter.MenuViewHolder> holders;

    public MenuAdapter(ArrayList<MenuItem> menuItems, Context context) {
        this.menuItems = menuItems;
        this.context = context;
        this.holders = new ArrayList<>();

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
        if (holders.size() != menuItems.size())
            holders.add(holder);
        if (menuItem.getSubMenuItems() != null) {

            SubMenuAdapter adapter = new SubMenuAdapter(menuItem.getSubMenuItems(), context);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);

            holder.binding.menuRecyclerViewSub.setHasFixedSize(true);
            holder.binding.menuRecyclerViewSub.setLayoutManager(layoutManager);
            holder.binding.menuRecyclerViewSub.setAdapter(adapter);
        } else {
            holder.binding.menuImageViewArrow.setVisibility(View.INVISIBLE);
            holder.binding.menuRecyclerViewSub.setVisibility(View.GONE);
        }


        holder.binding.menuLinearLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (position == 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fragment", "ViewStaffFragment");
                    context.startActivity(new Intent(context, ContainerActivity.class)
                            .putExtra("bundle", bundle));
                } else if (position == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fragment", "SettingsFragment");
                    context.startActivity(new Intent(context, ContainerActivity.class)
                            .putExtra("bundle", bundle));
                } else if (position == 4) {
                    Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show();
                } else {
                    if (holder.binding.menuImageViewArrowUp.getVisibility() == View.VISIBLE) {

                        closeTabs();


                    } else {

                        openOneTab(position);
                    }
                    notifyDataSetChanged();

                }

            }
        });
    }

    private void openOneTab(int currentTab) {


        for (int i = 0; i < holders.size(); i++) {
            if (currentTab != i) {
                holders.get(i).binding.menuRecyclerViewSub.setVisibility(View.GONE);
                holders.get(i).binding.menuImageViewArrowUp.setVisibility(View.GONE);

            } else {
                holders.get(i).binding.menuRecyclerViewSub.setVisibility(View.VISIBLE);
                holders.get(i).binding.menuImageViewArrow.setVisibility(View.GONE);
                holders.get(i).binding.menuImageViewArrowUp.setVisibility(View.VISIBLE);

            }
            notifyDataSetChanged();
        }

    }

    public void closeTabs() {

        for (int i = 0; i < holders.size(); i++) {
            if (i != 2 && i != 4 && i != 3) {
                holders.get(i).binding.menuRecyclerViewSub.setVisibility(View.GONE);
                holders.get(i).binding.menuImageViewArrow.setVisibility(View.VISIBLE);
                holders.get(i).binding.menuImageViewArrowUp.setVisibility(View.GONE);
            }
        }
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
