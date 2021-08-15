package com.alaqsa.edu.ps.staffservices.model;

public class College {
    private String collageName;
    private String collageId;

    public College() {
    }

    public College(String collageName, String collageId) {
        this.collageName = collageName;
        this.collageId = collageId;
    }

    public String getCollageName() {
        return collageName;
    }

    public void setCollageName(String collageName) {
        this.collageName = collageName;
    }

    public String getCollageId() {
        return collageId;
    }

    public void setCollageId(String collageId) {
        this.collageId = collageId;
    }


}
