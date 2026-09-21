package com.example.rahban3.Model;

public class DriverNotification {

    private String title;
    private String message;
    private String time;
    private String type;
    private boolean unread;

    public DriverNotification(
            String title,
            String message,
            String time,
            String type,
            boolean unread) {

        this.title = title;
        this.message = message;
        this.time = time;
        this.type = type;
        this.unread = unread;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }
}