package com.example.rahban3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Model.DriverRequest;
import com.example.rahban3.R;

import java.util.List;

public class DriverRequestAdapter
        extends RecyclerView.Adapter<DriverRequestAdapter.RequestViewHolder> {

    private List<DriverRequest> requestList;

    public DriverRequestAdapter(List<DriverRequest> requestList) {
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.driver_item_request, parent, false);

        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RequestViewHolder holder,
            int position) {

        DriverRequest request = requestList.get(position);

        holder.txtStudentName.setText(request.getStudentName());
        holder.txtStudentGrade.setText(request.getGrade());
        holder.txtSchool.setText(request.getSchool());
        holder.txtAddress.setText(request.getAddress());
        holder.txtTime.setText(request.getTime());
        holder.txtRoute.setText(request.getRoute());
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public static class RequestViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtStudentName;
        TextView txtStudentGrade;
        TextView txtSchool;
        TextView txtAddress;
        TextView txtTime;
        TextView txtRoute;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);

            txtStudentName =
                    itemView.findViewById(R.id.txtStudentName);

            txtStudentGrade =
                    itemView.findViewById(R.id.txtStudentGrade);

            txtSchool =
                    itemView.findViewById(R.id.txtSchool);

            txtAddress =
                    itemView.findViewById(R.id.txtAddress);

            txtTime =
                    itemView.findViewById(R.id.txtTime);

            txtRoute =
                    itemView.findViewById(R.id.txtRoute);
        }
    }
}