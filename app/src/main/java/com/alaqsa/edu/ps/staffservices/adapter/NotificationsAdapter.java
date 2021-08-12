package com.alaqsa.edu.ps.staffservices.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutHomeBinding;
import com.alaqsa.edu.ps.staffservices.databinding.LayoutNotificationBinding;
import com.alaqsa.edu.ps.staffservices.model.Test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder> {

    private ArrayList<Test> testArrayList;

    public NotificationsAdapter(ArrayList<Test> testArrayList) {
        this.testArrayList = testArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public NotificationsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new NotificationsViewHolder(LayoutNotificationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotificationsAdapter.NotificationsViewHolder holder, int position) {
        Test test = testArrayList.get(position);
        holder.binding.notiTextViewTitle.setText(test.getTitle());
        holder.binding.notiTextViewText.setText(test.getText());
    }

    @Override
    public int getItemCount() {
        return testArrayList.size();
    }

    class NotificationsViewHolder extends RecyclerView.ViewHolder {

        private LayoutNotificationBinding binding;

        public NotificationsViewHolder(LayoutNotificationBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
