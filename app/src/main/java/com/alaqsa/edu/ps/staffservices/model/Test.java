package com.alaqsa.edu.ps.staffservices.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Test implements Serializable
{
    private int id;
    private String course;
    private String classs;
    private String hill;
    private String time;
    private boolean isExpanded;
    private String title;
    private String text;

    public Test(int id, String course, String classs, String hill, String time, boolean isExpanded, String title, String text) {
        this.id = id;
        this.course = course;
        this.classs = classs;
        this.hill = hill;
        this.time = time;
        this.isExpanded = isExpanded;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getHill() {
        return hill;
    }

    public void setHill(String hall) {
        this.hill = hill;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
