package com.alaqsa.edu.ps.staffservices.model;

public class Subject {
    private String subject_name;
    private String subject_id;
    private String division;
    private String gender;
    private int students;
    private boolean isExpanded;

    public Subject(String subject_name, String subject_id, String division, String gender, int students, boolean isExpanded) {
        this.subject_name = subject_name;
        this.subject_id = subject_id;
        this.division = division;
        this.gender = gender;
        this.students = students;
        this.isExpanded = isExpanded;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
}
