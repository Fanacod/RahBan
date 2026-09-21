package com.example.rahban3.Model;

public class DriverTrip {

    private String serviceNumber;
    private String schoolName;
    private String time;
    private String route;
    private String studentCount;
    private String status;
    private boolean morning;

    public DriverTrip(
            String serviceNumber,
            String schoolName,
            String time,
            String route,
            String studentCount,
            String status,
            boolean morning) {

        this.serviceNumber = serviceNumber;
        this.schoolName = schoolName;
        this.time = time;
        this.route = route;
        this.studentCount = studentCount;
        this.status = status;
        this.morning = morning;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getTime() {
        return time;
    }

    public String getRoute() {
        return route;
    }

    public String getStudentCount() {
        return studentCount;
    }

    public String getStatus() {
        return status;
    }

    public boolean isMorning() {
        return morning;
    }
}