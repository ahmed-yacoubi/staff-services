package com.alaqsa.edu.ps.staffservices.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private ArrayList<Subject> subjects;
    private int res;
    private List<SubjectViewHolder> holders;

    public SubjectAdapter(ArrayList<Subject> subjects, int res) {
        this.subjects = subjects;
        this.res = res;
        holders = new ArrayList<>();
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubjectViewHolder(LayoutInflater.from(parent.getContext()).inflate(res, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, @SuppressLint("RecyclerView") int position) {

        if (holders.size() != subjects.size())
            holders.add(holder);
        holder.tv_subjectName.setText(subjects.get(position).getSubject_name());
        holder.tv_subjectId.setText(subjects.get(position).getSubject_id());
        holder.tv_divisionId.setText(subjects.get(position).getDivision());
        holder.tv_gender.setText(subjects.get(position).getGender());
        holder.tv_students.setText(subjects.get(position).getStudents() + "");


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (holder.iv_arrowUp.getVisibility() == View.GONE) {
                    openOneTab(position);
                } else {

                    closeTabs();
                }

                Log.d("Old position: " , holder.getOldPosition()+"");

                notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });



    }

    private void openOneTab(int currentTab) {


        for (int i = 0; i < holders.size(); i++) {
            if (currentTab == i) {
                holders.get(i).layout.setVisibility(View.VISIBLE);
                holders.get(i).iv_arrow.setVisibility(View.GONE);
                holders.get(i).iv_arrowUp.setVisibility(View.VISIBLE);
            } else {
                holders.get(i).layout.setVisibility(View.GONE);
                holders.get(i).iv_arrow.setVisibility(View.VISIBLE);
                holders.get(i).iv_arrowUp.setVisibility(View.GONE);

            }
        }

    }

    public void closeTabs() {
        if (subjects != null)
            for (int i = 0; i < holders.size(); i++) {
                holders.get(i).layout.setVisibility(View.GONE);
                holders.get(i).iv_arrow.setVisibility(View.VISIBLE);
                holders.get(i).iv_arrowUp.setVisibility(View.GONE);


            }
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView tv_subjectName, tv_subjectId, tv_divisionId, tv_gender, tv_students;
        ImageView iv_arrow, iv_arrowUp;
        LinearLayout layout, linearLayout;


        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            bind(itemView);
        }

        private void bind(View itemView) {
            tv_subjectName = itemView.findViewById(R.id.SubjectLayout_tv_subjectname);
            tv_subjectId = itemView.findViewById(R.id.SubjectLayout_tv_subjectid);
            tv_divisionId = itemView.findViewById(R.id.SubjectLayout_tv_DivisionId);
            tv_gender = itemView.findViewById(R.id.SubjectLayout_tv_gender);
            tv_students = itemView.findViewById(R.id.SubjectLayout_tv_StudentsNum);
            iv_arrow = itemView.findViewById(R.id.SubjectLayout_iv_ArrowDown);
            layout = itemView.findViewById(R.id.SubjectLayout_layout);
            linearLayout = itemView.findViewById(R.id.SubjectLayout_linearLayout);
            iv_arrowUp = itemView.findViewById(R.id.SubjectLayout_iv_ArrowUp);
        }
    }
}
