package com.alaqsa.edu.ps.staffservices.model;

import java.io.Serializable;

public class SubMenuItem  implements Serializable
{
    private int icon;
    private String title;

    public SubMenuItem(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
