package com.alaqsa.edu.ps.staffservices.model;

public class Agenda {

    String beginning_semester;
    String end_semester;
    String start_final_exam;
    String start_midterm;


    public Agenda(String beginning_semester, String end_semester, String start_final_exam, String start_midterm) {
        this.beginning_semester = beginning_semester;
        this.end_semester = end_semester;
        this.start_final_exam = start_final_exam;
        this.start_midterm = start_midterm;
    }

    public String getBeginning_semester() {
        return beginning_semester;
    }

    public void setBeginning_semester(String beginning_semester) {
        this.beginning_semester = beginning_semester;
    }

    public String getEnd_semester() {
        return end_semester;
    }

    public void setEnd_semester(String end_semester) {
        this.end_semester = end_semester;
    }

    public String getStart_final_exam() {
        return start_final_exam;
    }

    public void setStart_final_exam(String start_final_exam) {
        this.start_final_exam = start_final_exam;
    }

    public String getStart_midterm() {
        return start_midterm;
    }

    public void setStart_midterm(String start_midterm) {
        this.start_midterm = start_midterm;
    }
}
