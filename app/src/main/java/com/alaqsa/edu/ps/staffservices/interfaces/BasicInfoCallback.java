package com.alaqsa.edu.ps.staffservices.interfaces;

import com.alaqsa.edu.ps.staffservices.model.Api;

public interface BasicInfoCallback {

    void onGetBasicInfo(Api api);
    void onUnSuccessful(String message);

}
