package com.example.rahban3.Model;

public class Service {

    private String driverName;
    private String serviceNumber;
    private String rating;
    private String capacity;
    private String route;
    private boolean active;


    public Service(
            String driverName,
            String serviceNumber,
            String rating,
            String capacity,
            String route,
            boolean active) {

        this.driverName = driverName;
        this.serviceNumber = serviceNumber;
        this.rating = rating;
        this.capacity = capacity;
        this.route = route;
        this.active = active;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public String getRating() {
        return rating;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getRoute() {
        return route;
    }

    public boolean isActive() {
        return active;
    }
}