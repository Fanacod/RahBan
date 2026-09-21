package com.example.rahban3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Model.Trip;
import com.example.rahban3.R;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    private List<Trip> tripList;

    public TripAdapter(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trip, parent, false);

        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull TripViewHolder holder,
            int position) {

        Trip trip = tripList.get(position);

        holder.txtTripDate.setText(trip.getDate());
        holder.txtTripRoute.setText(trip.getRoute());
        holder.txtTripTime.setText(trip.getTime());
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }


    public static class TripViewHolder
            extends RecyclerView.ViewHolder {

        TextView txtTripDate;
        TextView txtTripRoute;
        TextView txtTripTime;


        public TripViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTripDate =
                    itemView.findViewById(R.id.txtTripDate);

            txtTripRoute =
                    itemView.findViewById(R.id.txtTripRoute);

            txtTripTime =
                    itemView.findViewById(R.id.txtTripTime);


        }
    }
}