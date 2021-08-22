package com.alaqsa.edu.ps.staffservices.model;

public class StudentsInSubject {

    int  id_attendance ;   //  الايديه هادا بيجينا من جدول تسجيل المادة  من خلالوا هحط الحضور والغياب للطالب
//  من دون ما يكون اي ديه الطالب في الجدول نفسوا . اذا بدي ايديه الطالب باخد الايديه هادا و بروح على جدول تسجيل المادة وببحث عن الايديه بلاقي اي ديه الطالب
    int student_id;
    String subject_id;
    String division;
    String attendance_date ;
    String attendance_day ;
    String states ;
    String student_name;


    public StudentsInSubject() {
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getId_attendance() {
        return id_attendance;
    }

    public void setId_attendance(int id_attendance) {
        this.id_attendance = id_attendance;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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

    public String getAttendance_date() {
        return attendance_date;
    }

    public void setAttendance_date(String attendance_date) {
        this.attendance_date = attendance_date;
    }

    public String getAttendance_day() {
        return attendance_day;
    }

    public void setAttendance_day(String attendance_day) {
        this.attendance_day = attendance_day;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }
}
