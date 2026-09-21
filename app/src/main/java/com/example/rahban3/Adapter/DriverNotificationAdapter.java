package com.example.rahban3.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Model.DriverNotification;
import com.example.rahban3.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class DriverNotificationAdapter
        extends RecyclerView.Adapter<DriverNotificationAdapter.NotificationViewHolder> {

    private final List<DriverNotification> notificationList;

    public DriverNotificationAdapter(
            List<DriverNotification> notificationList) {

        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.driver_item_notification,
                        parent,
                        false
                );

        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull NotificationViewHolder holder,
            int position) {

        DriverNotification notification =
                notificationList.get(position);

        holder.txtTitle.setText(notification.getTitle());
        holder.txtMessage.setText(notification.getMessage());
        holder.txtTime.setText(notification.getTime());
        holder.txtType.setText(notification.getType());

        if (notification.isUnread()) {

            holder.viewUnread.setVisibility(View.VISIBLE);

            holder.notificationCard.setCardBackgroundColor(
                    Color.WHITE
            );

        } else {

            holder.viewUnread.setVisibility(View.GONE);

            holder.notificationCard.setCardBackgroundColor(
                    Color.parseColor("#F8FBFC")
            );
        }

        holder.itemView.setOnClickListener(v -> {

            if (notification.isUnread()) {

                notification.setUnread(false);

                holder.viewUnread.setVisibility(View.GONE);

                holder.notificationCard.setCardBackgroundColor(
                        Color.parseColor("#F8FBFC")
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public void markAllAsRead() {

        for (DriverNotification notification : notificationList) {
            notification.setUnread(false);
        }

        notifyDataSetChanged();
    }

    public int getUnreadCount() {

        int count = 0;

        for (DriverNotification notification : notificationList) {

            if (notification.isUnread()) {
                count++;
            }
        }

        return count;
    }

    public static class NotificationViewHolder
            extends RecyclerView.ViewHolder {

        ImageView imgNotification;

        TextView txtTitle;
        TextView txtMessage;
        TextView txtTime;
        TextView txtType;

        View viewUnread;

        MaterialCardView notificationCard;

        public NotificationViewHolder(
                @NonNull View itemView) {

            super(itemView);

            imgNotification =
                    itemView.findViewById(R.id.imgNotification);

            txtTitle =
                    itemView.findViewById(R.id.txtNotificationTitle);

            txtMessage =
                    itemView.findViewById(R.id.txtNotificationMessage);

            txtTime =
                    itemView.findViewById(R.id.txtNotificationTime);

            txtType =
                    itemView.findViewById(R.id.txtNotificationType);

            viewUnread =
                    itemView.findViewById(R.id.viewUnread);

            notificationCard =
                    itemView.findViewById(R.id.notificationCard);
        }
    }
}