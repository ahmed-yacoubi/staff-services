package com.alaqsa.edu.ps.staffservices.model;

public class Observation {
    String name ;
    String name_subject ;
    String date ;
    String period ;
    String hall ;

    public Observation() {
    }

    public Observation(String name, String name_subject, String date, String period, String hall) {
        this.name = name;
        this.name_subject = name_subject;
        this.date = date;
        this.period = period;
        this.hall = hall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }
}
