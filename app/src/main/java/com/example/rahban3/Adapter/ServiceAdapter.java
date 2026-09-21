package com.example.rahban3.Adapter;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Model.Service;
import com.example.rahban3.R;
import com.example.rahban3.activity_driver_profile1;

import java.util.List;

public class ServiceAdapter
        extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    private List<Service> serviceList;

    public ServiceAdapter(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service, parent, false);

        return new ServiceViewHolder(view);
    }


    @Override
    public void onBindViewHolder(
            @NonNull ServiceViewHolder holder,
            int position) {

        Service service = serviceList.get(position);

        holder.txtDriverName.setText(
                service.getDriverName()
        );

        holder.txtServiceNumber.setText(
                service.getServiceNumber()
        );

        holder.txtRating.setText(
                "⭐ " + service.getRating()
        );

        holder.txtCapacity.setText(
                service.getCapacity()
        );

        holder.txtRoute.setText(
                service.getRoute()
        );

        holder.btnViewService.setOnClickListener(v -> {

            Intent intent = new Intent(
                    v.getContext(),
                    activity_driver_profile1.class
            );

            intent.putExtra("driver_name", service.getDriverName());
            intent.putExtra("service_number", service.getServiceNumber());
            intent.putExtra("rating", service.getRating());
            intent.putExtra("capacity", service.getCapacity());
            intent.putExtra("route", service.getRoute());

            v.getContext().startActivity(intent);
        });

        if (service.isActive()) {

            holder.txtStatus.setText("● فعال");
            holder.txtStatus.setTextColor(
                    0xFF0B927F
            );

        } else {

            holder.txtStatus.setText("● غیرفعال");
            holder.txtStatus.setTextColor(
                    0xFF9AAEB3
            );
        }


    }


    @Override
    public int getItemCount() {
        return serviceList.size();
    }


    public static class ServiceViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtDriverName;
        TextView txtServiceNumber;
        TextView txtRating;
        TextView txtCapacity;
        TextView txtRoute;
        TextView txtStatus;
        Button btnViewService;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            btnViewService = itemView.findViewById(R.id.btnViewService);
            txtDriverName =
                    itemView.findViewById(R.id.txtDriverName);

            txtServiceNumber =
                    itemView.findViewById(R.id.txtServiceNumber);

            txtRating =
                    itemView.findViewById(R.id.txtRating);

            txtCapacity =
                    itemView.findViewById(R.id.txtCapacity);

            txtRoute =
                    itemView.findViewById(R.id.txtRoute);

            txtStatus =
                    itemView.findViewById(R.id.txtStatus);
        }
    }
}