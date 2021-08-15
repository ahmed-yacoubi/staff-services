package com.alaqsa.edu.ps.staffservices.model;

import java.io.Serializable;

public class Subject implements Serializable {

    private String subject_id;
    private String subject_name;
    private String gender;
    private String division;
    private String finalExamDate;
    private String placeTimeLecture;
    private String collage;
    private String department;
    private int students;
    private boolean isExpanded;
    public Subject() {
    }

    public Subject(String subjectId, String subjectName, String gender, String division,
                   String finalExamDate, String placeTimeLecture, String collage, String department) {
        this.subject_id = subjectId;
        this.subject_name = subjectName;
        this.gender = gender;
        this.division = division;
        this.finalExamDate = finalExamDate;
        this.placeTimeLecture = placeTimeLecture;
        this.collage = collage;
        this.department = department;
    }

    public Subject(String subject_id, String subject_name, String gender, String division, String finalExamDate, String placeTimeLecture, String collage, String department, int students, boolean isExpanded) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.gender = gender;
        this.division = division;
        this.finalExamDate = finalExamDate;
        this.placeTimeLecture = placeTimeLecture;
        this.collage = collage;
        this.department = department;
        this.students = students;
        this.isExpanded = isExpanded;
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

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public String getSubjectId() {
        return subject_id;
    }

    public void setSubjectId(String subjectId) {
        this.subject_id = subjectId;
    }

    public String getSubjectName() {
        return subject_name;
    }

    public void setSubjectName(String subjectName) {
        this.subject_name = subjectName;
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

    public String getPlaceTimeLecture() {
        return placeTimeLecture;
    }

    public void setPlaceTimeLecture(String placeTimeLecture) {
        this.placeTimeLecture = placeTimeLecture;
    }
}
