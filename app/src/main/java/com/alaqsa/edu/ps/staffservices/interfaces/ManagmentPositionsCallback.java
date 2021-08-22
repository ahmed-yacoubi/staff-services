package com.alaqsa.edu.ps.staffservices.interfaces;

import com.alaqsa.edu.ps.staffservices.model.Api;
import com.alaqsa.edu.ps.staffservices.model.AppoimentApi;

public interface ManagmentPositionsCallback {
    void onGetPositionInfo(AppoimentApi api);

    void onUnSuccessful(String message);
}
