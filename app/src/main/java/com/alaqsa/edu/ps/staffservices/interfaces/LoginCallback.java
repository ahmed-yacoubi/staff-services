package com.alaqsa.edu.ps.staffservices.interfaces;

public interface LoginCallback {
    void login(boolean status,String accessTocken);
    void logout(boolean status);
}
