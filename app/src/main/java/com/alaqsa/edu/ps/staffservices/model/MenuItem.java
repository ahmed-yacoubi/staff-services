package com.alaqsa.edu.ps.staffservices.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuItem  implements Serializable {
    private int icon;
    private String title;
    private boolean isExpanded;
    private ArrayList<SubMenuItem> subMenuItems;

    public MenuItem(int icon, String title, boolean isExpanded, ArrayList<SubMenuItem> subMenuItems) {
        this.icon = icon;
        this.title = title;
        this.isExpanded = isExpanded;
        this.subMenuItems = subMenuItems;
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

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public ArrayList<SubMenuItem> getSubMenuItems() {
        return subMenuItems;
    }

    public void setSubMenuItems(ArrayList<SubMenuItem> subMenuItems) {
        this.subMenuItems = subMenuItems;
    }
}
