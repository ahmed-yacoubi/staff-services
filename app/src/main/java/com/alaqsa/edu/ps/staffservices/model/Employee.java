package com.alaqsa.edu.ps.staffservices.model;

public class Employee {
    private String name_arb;
    private String name_eng;
    private String gender;
    private String citizenship;
    private String date_birth;

    private String governorate;
    private String city;
    private String neighborhood;

    private String collegeEmail;
    private String personalEmail;
    private String phoneNo;

    private String collegeId;
    private String departmentId;
    private String Specialization;
    private String img;
    private String password;
    private String collageName;
    private String departmentName;

    public Employee() {
    }

    public Employee(String name_arb, String name_eng, String gender, String citizenship, String date_birth, String governorate, String city, String neighborhood, String collegeEmail, String personalEmail, String phoneNo, String collegeId, String departmentId, String specialization, String img, String collageName, String departmentName) {
        this.name_arb = name_arb;
        this.name_eng = name_eng;
        this.gender = gender;
        this.citizenship = citizenship;
        this.date_birth = date_birth;
        this.governorate = governorate;
        this.city = city;
        this.neighborhood = neighborhood;
        this.collegeEmail = collegeEmail;
        this.personalEmail = personalEmail;
        this.phoneNo = phoneNo;
        this.collegeId = collegeId;
        this.departmentId = departmentId;
        Specialization = specialization;
        this.img = img;
        this.collageName = collageName;
        this.departmentName = departmentName;
    }

    public Employee(String name_arb, String name_eng, String gender, String citizenship, String date_birth, String governorate, String city, String neighborhood, String collegeEmail, String personalEmail, String phoneNo, String collegeId, String departmentId, String specialization, String img, String password, String collageName, String departmentName) {
        this.name_arb = name_arb;
        this.name_eng = name_eng;
        this.gender = gender;
        this.citizenship = citizenship;
        this.date_birth = date_birth;
        this.governorate = governorate;
        this.city = city;
        this.neighborhood = neighborhood;
        this.collegeEmail = collegeEmail;
        this.personalEmail = personalEmail;
        this.phoneNo = phoneNo;
        this.collegeId = collegeId;
        this.departmentId = departmentId;
        Specialization = specialization;
        this.img = img;
        this.password = password;
        this.collageName = collageName;
        this.departmentName = departmentName;
    }

    public String getName_arb() {
        return name_arb;
    }

    public void setName_arb(String name_arb) {
        this.name_arb = name_arb;
    }

    public String getName_eng() {
        return name_eng;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
