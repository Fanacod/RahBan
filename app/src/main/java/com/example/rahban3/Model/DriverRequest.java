package com.example.rahban3.Model;

public class DriverRequest {

    private String studentName;
    private String grade;
    private String school;
    private String address;
    private String time;
    private String route;

    public DriverRequest(
            String studentName,
            String grade,
            String school,
            String address,
            String time,
            String route) {

        this.studentName = studentName;
        this.grade = grade;
        this.school = school;
        this.address = address;
        this.time = time;
        this.route = route;
    }

    public String getStudentName() {
        return studentName;
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

    public String getTime() {
        return time;
    }

    public String getRoute() {
        return route;
    }
}