package com.alaqsa.edu.ps.staffservices.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.alaqsa.edu.ps.staffservices.database.Cashing;
import com.alaqsa.edu.ps.staffservices.other.CheckInternet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyService extends Service {
    private String SHARD_PREFS = "Shard_Pref";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String date_today="";

        Cashing cashing = Cashing.getInstance((Activity) getApplicationContext());
        if (CheckInternet.isConnected()) {

//                       insert Data NotChange
            boolean dataStored = getSharedPreferences(SHARD_PREFS, MODE_PRIVATE).getBoolean("dataStored", false);
            if (!dataStored) {
                cashing.insertDataNotChange();
                getSharedPreferences(SHARD_PREFS, MODE_PRIVATE).edit().putBoolean("dataStored", true).apply();

                dateFormat.format(date);
                String today= dateFormat.format(date);
                 date_today = getSharedPreferences(SHARD_PREFS, MODE_PRIVATE).getString("dateToday", today);
            }


            if (!date_today.equals(date_today)||!date_today.equals("")){

            }
//                 insert Data Change
//            بدي اعمل هان فحص  يعمل اضافة مرة في اليوم
            cashing.insertDataChange();
        }
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}