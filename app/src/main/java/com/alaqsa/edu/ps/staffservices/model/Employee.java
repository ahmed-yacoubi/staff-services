package com.alaqsa.edu.ps.staffservices.model;

public class Employee {
    private String collegeEmail;
    private String name;
    private String collegeId;
    private String departmentId;
    private String Specialization;
    private String img;
    private String city;
    private String personalEmail;
    private String phoneNo;
    private String jobTitle;
    private String password;
    private String collageName;
    private String departmentName;

    public Employee() {
    }

    public Employee(String collegeEmail, String name, String collegeId, String departmentId, String specialization, String img, String city, String personalEmail, String phoneNo, String jobTitle) {
        this.collegeEmail = collegeEmail;
        this.name = name;
        this.collegeId = collegeId;
        this.departmentId = departmentId;
        Specialization = specialization;
        this.img = img;
        this.city = city;
        this.personalEmail = personalEmail;
        this.phoneNo = phoneNo;
        this.jobTitle = jobTitle;
    }

    public Employee(String collegeEmail, String name, String collegeId, String departmentId, String specialization, String img, String city, String personalEmail, String phoneNo, String jobTitle, String password, String collageName, String departmentName) {
        this.collegeEmail = collegeEmail;
        this.name = name;
        this.collegeId = collegeId;
        this.departmentId = departmentId;
        Specialization = specialization;
        this.img = img;
        this.city = city;
        this.personalEmail = personalEmail;
        this.phoneNo = phoneNo;
        this.jobTitle = jobTitle;
        this.password = password;
        this.collageName = collageName;
        this.departmentName = departmentName;
    }

    public String getCollageName() {
        return collageName;
    }

    public void setCollageName(String collageName) {
        this.collageName = collageName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


}
