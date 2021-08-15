package com.alaqsa.edu.ps.staffservices.model;

public class StudentInfo {
    private int studentId;
    private String studentName;
    private String department;
    private int achievementHours;
    private double schoolRate;
    private double GPA;
    private String city;
    private String phoneNo;
    private String address;
    private int level;
    private String collage;


    public StudentInfo() {
    }

    public StudentInfo(int studentId, String studentName, String department, int achievementHours,
                       double schoolRate, double GPA, String city, String phoneNo, String address, int level,   String collage) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.achievementHours = achievementHours;
        this.schoolRate = schoolRate;
        this.GPA = GPA;
        this.city = city;
        this.phoneNo = phoneNo;
        this.address = address;
        this.level = level;
        this.collage = collage;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAchievementHours() {
        return achievementHours;
    }

    public void setAchievementHours(int achievementHours) {
        this.achievementHours = achievementHours;
    }

    public double getSchoolRate() {
        return schoolRate;
    }

    public void setSchoolRate(double schoolRate) {
        this.schoolRate = schoolRate;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
