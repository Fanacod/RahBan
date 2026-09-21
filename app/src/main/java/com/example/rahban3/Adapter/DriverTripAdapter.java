package com.example.rahban3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Model.DriverTrip;
import com.example.rahban3.R;

import java.util.List;

public class DriverTripAdapter
        extends RecyclerView.Adapter<DriverTripAdapter.TripViewHolder> {

    private List<DriverTrip> tripList;

    public DriverTripAdapter(List<DriverTrip> tripList) {
        this.tripList = tripList;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.driver_item_today_trip, parent, false);

        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull TripViewHolder holder,
            int position) {

        DriverTrip trip = tripList.get(position);

        holder.txtTripService.setText(trip.getServiceNumber());
        holder.txtSchoolName.setText(trip.getSchoolName());
        holder.txtTripTime.setText(trip.getTime());
        holder.txtTripRoute.setText(trip.getRoute());
        holder.txtStudentCount.setText(trip.getStudentCount());
        holder.txtTripStatus.setText(trip.getStatus());

        if (trip.isMorning()) {
            holder.imgTripIcon.setImageResource(R.drawable.ic_sun);
        } else {
            holder.imgTripIcon.setImageResource(R.drawable.ic_moon);
        }
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public static class TripViewHolder
            extends RecyclerView.ViewHolder {

        ImageView imgTripIcon;
        TextView txtTripService;
        TextView txtSchoolName;
        TextView txtTripTime;
        TextView txtTripRoute;
        TextView txtStudentCount;
        TextView txtTripStatus;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTripIcon = itemView.findViewById(R.id.imgTripIcon);
            txtTripService = itemView.findViewById(R.id.txtTripService);
            txtSchoolName = itemView.findViewById(R.id.txtSchoolName);
            txtTripTime = itemView.findViewById(R.id.txtTripTime);
            txtTripRoute = itemView.findViewById(R.id.txtTripRoute);
            txtStudentCount = itemView.findViewById(R.id.txtStudentCount);
            txtTripStatus = itemView.findViewById(R.id.txtTripStatus);
        }
    }
}