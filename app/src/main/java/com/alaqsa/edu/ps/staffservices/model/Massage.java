package com.alaqsa.edu.ps.staffservices.model;

public class Massage {

    int id;
    String type_massage; // هل هيا رساله ولا اشعار
    String title_massage;
    String body_massage;

    public Massage(int id, String type_massage, String title_massage, String body_massage) {
        this.id = id;
        this.type_massage = type_massage;
        this.title_massage = title_massage;
        this.body_massage = body_massage;
    }

    public Massage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_massage() {
        return type_massage;
    }

    public void setType_massage(String type_massage) {
        this.type_massage = type_massage;
    }

    public String getTitle_massage() {
        return title_massage;
    }

    public void setTitle_massage(String title_massage) {
        this.title_massage = title_massage;
    }

    public String getBody_massage() {
        return body_massage;
    }

    public void setBody_massage(String body_massage) {
        this.body_massage = body_massage;
    }
}
