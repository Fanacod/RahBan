package com.example.rahban3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Model.School;
import com.example.rahban3.R;

import java.util.ArrayList;
import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder> {

    private List<School> schoolList;
    private List<School> allSchools;

    public interface OnSchoolClickListener {
        void onSchoolClick(School school);
    }

    private OnSchoolClickListener listener;
    public SchoolAdapter(List<School> schoolList,  OnSchoolClickListener listener) {

        this.schoolList = schoolList;
        this.allSchools = new ArrayList<>(schoolList);
        this.listener = listener;
    }

    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_school, parent, false);

        return new SchoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull SchoolViewHolder holder,
            int position) {

        School school = schoolList.get(position);

        holder.txtSchoolName.setText(school.getName());
        holder.txtSchoolLocation.setText(school.getLocation());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onSchoolClick(school);
            }
        });

    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }


    // جستجو و فیلتر
    public void filter(String text) {

        List<School> filteredList = new ArrayList<>();

        String searchText = text.trim().toLowerCase();

        if (searchText.isEmpty()) {

            filteredList.addAll(allSchools);

        } else {

            for (School school : allSchools) {

                String name = school.getName().toLowerCase();
                String location = school.getLocation().toLowerCase();

                if (name.contains(searchText)
                        || location.contains(searchText)) {

                    filteredList.add(school);
                }
            }
        }

        schoolList.clear();
        schoolList.addAll(filteredList);

        notifyDataSetChanged();
    }


    public static class SchoolViewHolder extends RecyclerView.ViewHolder {

        TextView txtSchoolName;
        TextView txtSchoolLocation;

        public SchoolViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSchoolName = itemView.findViewById(R.id.txtSchoolName);
            txtSchoolLocation = itemView.findViewById(R.id.txtSchoolLocation);
        }
    }
}