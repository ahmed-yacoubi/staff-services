package com.alaqsa.edu.ps.staffservices.interfaces;

import com.alaqsa.edu.ps.staffservices.model.appoiment_universityApi;

public interface UniversityAppoimentsCallback {
     void onGetUniversityAppoiments(appoiment_universityApi api);
    void onUnSuccessful(String message);

}
