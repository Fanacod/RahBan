package com.example.rahban3.Model;

public class DriverStudent {

    private String name;
    private String grade;
    private String school;
    private String address;
    private String parentPhone;
    private String route;

    private boolean morning;

    public DriverStudent(
            String name,
            String grade,
            String school,
            String address,
            String parentPhone,
            String route,
            boolean morning) {

        this.name = name;
        this.grade = grade;
        this.school = school;
        this.address = address;
        this.parentPhone = parentPhone;
        this.route = route;

        this.morning = morning;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getSchool() {
        return school;
    }

    public String getAddress() {
        return address;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public String getRoute() {
        return route;
    }



    public boolean isMorning() {
        return morning;
    }
}