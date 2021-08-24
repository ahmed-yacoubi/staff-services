package com.alaqsa.edu.ps.staffservices.model;

public class Agenda {
    String know_semester;
    String name_agenda;
    String beginning_semester;
    String end_semester;
    String start_final_exam;
    String end_final_exam;
    String start_midterm;
    String end_midterm;
    String entry_start_midterm;
    String entry_end_midterm;
    String entry_start_final_exam;
    String entry_end_final_exam;
    String end_draw;

    public Agenda() {
    }

    public Agenda(String know_semester,  String name_agenda, String beginning_semester, String end_semester, String start_final_exam, String end_final_exam, String start_midterm, String end_midterm, String entry_start_midterm, String entry_end_midterm, String entry_start_final_exam, String entry_end_final_exam, String end_draw) {
        this.name_agenda = name_agenda;
        this.beginning_semester = beginning_semester;
        this.end_semester = end_semester;
        this.start_final_exam = start_final_exam;
        this.end_final_exam = end_final_exam;
        this.start_midterm = start_midterm;
        this.end_midterm = end_midterm;
        this.entry_start_midterm = entry_start_midterm;
        this.entry_end_midterm = entry_end_midterm;
        this.entry_start_final_exam = entry_start_final_exam;
        this.entry_end_final_exam = entry_end_final_exam;
        this.end_draw = end_draw;
        this.know_semester=know_semester;
    }

    public String getKnow_semester() {
        return know_semester;
    }

    public void setKnow_semester(String know_semester) {
        this.know_semester = know_semester;
    }

    public String getName_agenda() {
        return name_agenda;
    }

    public void setName_agenda(String name_agenda) {
        this.name_agenda = name_agenda;
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

    public String getEnd_final_exam() {
        return end_final_exam;
    }

    public void setEnd_final_exam(String end_final_exam) {
        this.end_final_exam = end_final_exam;
    }

    public String getStart_midterm() {
        return start_midterm;
    }

    public void setStart_midterm(String start_midterm) {
        this.start_midterm = start_midterm;
    }

    public String getEnd_midterm() {
        return end_midterm;
    }

    public void setEnd_midterm(String end_midterm) {
        this.end_midterm = end_midterm;
    }

    public String getEntry_start_midterm() {
        return entry_start_midterm;
    }

    public void setEntry_start_midterm(String entry_start_midterm) {
        this.entry_start_midterm = entry_start_midterm;
    }

    public String getEntry_end_midterm() {
        return entry_end_midterm;
    }

    public void setEntry_end_midterm(String entry_end_midterm) {
        this.entry_end_midterm = entry_end_midterm;
    }

    public String getEntry_start_final_exam() {
        return entry_start_final_exam;
    }

    public void setEntry_start_final_exam(String entry_start_final_exam) {
        this.entry_start_final_exam = entry_start_final_exam;
    }

    public String getEntry_end_final_exam() {
        return entry_end_final_exam;
    }

    public void setEntry_end_final_exam(String entry_end_final_exam) {
        this.entry_end_final_exam = entry_end_final_exam;
    }

    public String getEnd_draw() {
        return end_draw;
    }

    public void setEnd_draw(String end_draw) {
        this.end_draw = end_draw;
    }
}
