package com.alaqsa.edu.ps.staffservices.service;

import static com.alaqsa.edu.ps.staffservices.util.Utils.SharedPref.SHARED_PREF_NAME;
import static com.alaqsa.edu.ps.staffservices.util.Utils.SharedPref.STORAGE_DAY;

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

    public MyService() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Cashing cashing = Cashing.getInstance((Activity) getApplicationContext());
        if (CheckInternet.isConnected()) {

//                       insert Data NotChange
            boolean dataStored = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE).getBoolean("dataStored", false);
            if (!dataStored) {
                cashing.insertDataNotChange();
                getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE).edit().putBoolean("dataStored", true).apply();
            }
            long currentTime = System.currentTimeMillis() / 1000;// 1628542800
            //90000
            long oldTime = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE).getLong(STORAGE_DAY, currentTime);
            //                          1628542800      -       1628512800
            //20000
            //111521516 - 0 =5156161
            if (currentTime - oldTime >= 86400) {
                getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE).edit().putLong(STORAGE_DAY, currentTime).apply();
                cashing.insertDataChange();
            }
            //86400
            //86400
            //20000
            //1628542800        11
            //1628629200        12
            //1628715600        13
            //1628802000        14
            //                 insert Data Change
//            بدي اعمل هان فحص  يعمل اضافة مرة في اليوم

//        Calendar calendar = Calendar.getInstance();
//        calendar.add(MINUTE, 30);
//        System.out.println(System.currentTimeMillis()*2);
//        System.out.println(System.currentTimeMillis());
////        System.out.println(calendar.getTimeInMillis());
//        while (true){
//            if (calendar.getTimeInMillis() == System.currentTimeMillis()){
//                System.out.println(System.currentTimeMillis());
//                break;
//            }
//        }

        }
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}