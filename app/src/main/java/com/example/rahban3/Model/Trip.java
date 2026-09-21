package com.example.rahban3.Model;

public class Trip {

    private String date;
    private String route;
    private String time;
    private String status;

    public Trip(String date, String route, String time, String status) {
        this.date = date;
        this.route = route;
        this.time = time;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public String getRoute() {
        return route;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}