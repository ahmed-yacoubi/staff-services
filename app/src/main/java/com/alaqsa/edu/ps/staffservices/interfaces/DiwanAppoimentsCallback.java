package com.alaqsa.edu.ps.staffservices.interfaces;

import com.alaqsa.edu.ps.staffservices.model.AppoimentApi;
import com.alaqsa.edu.ps.staffservices.model.appoiment_diwanApi;

public interface DiwanAppoimentsCallback {
    void onGetDiwanInfo(appoiment_diwanApi api);
    void onUnSuccessful(String message);
}
