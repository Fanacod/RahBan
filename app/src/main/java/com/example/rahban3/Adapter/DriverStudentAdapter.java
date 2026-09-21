package com.example.rahban3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Model.DriverStudent;
import com.example.rahban3.R;

import java.util.List;

public class DriverStudentAdapter
        extends RecyclerView.Adapter<DriverStudentAdapter.StudentViewHolder> {

    private final List<DriverStudent> studentList;

    public DriverStudentAdapter(List<DriverStudent> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.driver_item_student, parent, false);

        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull StudentViewHolder holder,
            int position) {

        DriverStudent student = studentList.get(position);

        holder.txtStudentName.setText(student.getName());
        holder.txtStudentGrade.setText(student.getGrade());
        holder.txtStudentSchool.setText(student.getSchool());
        holder.txtStudentAddress.setText(student.getAddress());
        holder.txtParentPhone.setText(student.getParentPhone());
        holder.txtStudentRoute.setText(student.getRoute());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtStudentName;
        TextView txtStudentGrade;
        TextView txtStudentSchool;
        TextView txtStudentAddress;
        TextView txtParentPhone;
        TextView txtStudentRoute;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            txtStudentName =
                    itemView.findViewById(R.id.txtStudentName);

            txtStudentGrade =
                    itemView.findViewById(R.id.txtStudentGrade);

            txtStudentSchool =
                    itemView.findViewById(R.id.txtStudentSchool);

            txtStudentAddress =
                    itemView.findViewById(R.id.txtStudentAddress);

            txtParentPhone =
                    itemView.findViewById(R.id.txtParentPhone);

            txtStudentRoute =
                    itemView.findViewById(R.id.txtStudentRoute);

        }
    }
}