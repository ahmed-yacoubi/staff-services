package com.alaqsa.edu.ps.staffservices.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.alaqsa.edu.ps.staffservices.database.Cashing;

public class MyService extends Service {
    private String SHARD_PREFS;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Cashing cashing =Cashing.getInstance((Activity) getApplicationContext());

//        insert Data NotChange
        boolean dataStored = getSharedPreferences(SHARD_PREFS, MODE_PRIVATE).getBoolean("dataStored", false);
        if (!dataStored) {
            cashing.insertDataNotChange();

            getSharedPreferences(SHARD_PREFS, MODE_PRIVATE).edit().putBoolean("dataStored", true).apply();
        }

        cashing.insertDataChange();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}