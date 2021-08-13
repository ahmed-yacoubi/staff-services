package com.alaqsa.edu.ps.staffservices.adapter;

import android.content.Context;
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

public class SubjectAdapter  extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private ArrayList<Subject>subjects;
    private int res;

    public SubjectAdapter(ArrayList<Subject> subjects, int res) {
        this.subjects = subjects;
        this.res = res;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubjectViewHolder(LayoutInflater.from(parent.getContext()).inflate(res,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        holder.tv_subjectName.setText(subjects.get(position).getSubject_name());
        holder.tv_subjectId.setText(subjects.get(position).getSubject_id());
        holder.tv_divisionId.setText(subjects.get(position).getDivision());
        holder.tv_gender.setText(subjects.get(position).getGender());
        holder.tv_students.setText(subjects.get(position).getStudents()+"");



        holder.iv_arrow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (subjects.get(position).isExpanded()){
                    holder.layout.setVisibility(View.GONE);
                    holder.iv_arrow.setImageResource(R.drawable.ic_arrow_down);
                    subjects.get(position).setExpanded(false);
                }else{
                    holder.layout.setVisibility(View.VISIBLE);
                    holder.iv_arrow.setImageResource(R.drawable.ic_arrow_up);
                    subjects.get(position).setExpanded(true);
                }

                notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder {
        TextView tv_subjectName,tv_subjectId,tv_divisionId,tv_gender,tv_students;
        ImageView iv_arrow;
        LinearLayout layout;


        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            bind(itemView);
        }

        private void bind(View itemView) {
            tv_subjectName=itemView.findViewById(R.id.SubjectLayout_tv_subjectname);
            tv_subjectId=itemView.findViewById(R.id.SubjectLayout_tv_subjectid);
            tv_divisionId=itemView.findViewById(R.id.SubjectLayout_tv_DivisionId);
            tv_gender=itemView.findViewById(R.id.SubjectLayout_tv_gender);
            tv_students=itemView.findViewById(R.id.SubjectLayout_tv_StudentsNum);
            iv_arrow=itemView.findViewById(R.id.SubjectLayout_iv_ArrowDown);
            layout=itemView.findViewById(R.id.SubjectLayout_layout);
        }
    }
}
