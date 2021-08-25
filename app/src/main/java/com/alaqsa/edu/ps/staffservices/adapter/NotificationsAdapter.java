package com.alaqsa.edu.ps.staffservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutHomeBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutNotificationBinding;
import com.alaqsa.edu.ps.staffservices.model.Massage;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder> {

    private List<Massage> list;

    public NotificationsAdapter(List<Massage> testArrayList) {
        this.list = testArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public NotificationsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new NotificationsViewHolder(LayoutNotificationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationsAdapter.NotificationsViewHolder holder, int position) {
        holder.binding.notiTextViewTitle.setText(list.get(position).getTitle_massage());
        holder.binding.notiTextViewText.setText(list.get(position).getBody_massage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NotificationsViewHolder extends RecyclerView.ViewHolder {

        private LayoutNotificationBinding binding;

        public NotificationsViewHolder(LayoutNotificationBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
