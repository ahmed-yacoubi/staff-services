package com.alaqsa.edu.ps.staffservices.model;

import java.io.Serializable;

public class Subject implements Serializable {

    private String subject_id;
    private String date;
    private String time;
    private String collage;
    private String department;
    private String subject_name;
    private String gender;
    private String division;
    private String finalExamDate;
    private String hall;
    private int students;
    private String semester;

    public Subject() {
    }

    public Subject(String subject_id, String date, String time, String collage, String department, String subject_name, String gender, String division, String finalExamDate, String hall, int students, String semester) {
        this.subject_id = subject_id;
        this.date = date;
        this.time = time;
        this.collage = collage;
        this.department = department;
        this.subject_name = subject_name;
        this.gender = gender;
        this.division = division;
        this.finalExamDate = finalExamDate;
        this.hall = hall;
        this.students = students;
        this.semester = semester;
    }
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getFinalExamDate() {
        return finalExamDate;
    }

    public void setFinalExamDate(String finalExamDate) {
        this.finalExamDate = finalExamDate;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }
}
