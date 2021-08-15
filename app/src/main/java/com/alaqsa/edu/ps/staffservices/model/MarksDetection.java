package com.alaqsa.edu.ps.staffservices.model;

public class MarksDetection {
    private int studentNo;
    private String studentName;
    private double midMark;
    private double finalMark;
    private double workMark;
    private double totalMark;

    public MarksDetection() {
    }

    public MarksDetection(int studentNo, String studentName, double midMark, double finalMark, double workMark, double totalMark) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.midMark = midMark;
        this.finalMark = finalMark;
        this.workMark = workMark;
        this.totalMark = totalMark;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMidMark() {
        return midMark;
    }

    public void setMidMark(double midMark) {
        this.midMark = midMark;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    public double getWorkMark() {
        return workMark;
    }

    public void setWorkMark(double workMark) {
        this.workMark = workMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }
}
