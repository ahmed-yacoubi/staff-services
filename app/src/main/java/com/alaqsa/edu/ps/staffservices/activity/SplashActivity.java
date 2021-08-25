package com.alaqsa.edu.ps.staffservices.activity;

import static com.alaqsa.edu.ps.staffservices.util.Utils.SharedPref.CHANGE_LANG;
import static com.alaqsa.edu.ps.staffservices.util.Utils.SharedPref.SHARED_PREF_NAME;
import static com.alaqsa.edu.ps.staffservices.util.Utils.SharedPref.TEMP_DATA;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.activity.LoginActivity;
import com.alaqsa.edu.ps.staffservices.activity.MainActivity;
import com.alaqsa.edu.ps.staffservices.databinding.ActivitySplashBinding;
import com.alaqsa.edu.ps.staffservices.service.MyService;
import com.alaqsa.edu.ps.staffservices.temp.TemporaryData;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    private Animation anim;

    private SharedPreferences sharedPreferences;
    private String currentLang = "ar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        currentLang = sharedPreferences.getString(CHANGE_LANG, "ar");
        if (!sharedPreferences.getBoolean(TEMP_DATA, false)) {
            Log.d("qqqq", "onCreate: ");
            sharedPreferences.edit().putBoolean(TEMP_DATA, true).apply();
            TemporaryData temporaryData = new TemporaryData(this);
            temporaryData.dataGeneration();


        }

        if (currentLang.equals("ar")) {
            setLocale("ar");

        } else {

            setLocale("en");

        }


//        Intent serviceIntent = new Intent(getBaseContext(), MyService.class);
//        startService(serviceIntent);

        // Declare an imageView to show the animation.
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


        // Create the animation.
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // MainActivity.class is the activity to go after showing the splash screen.
                if (sharedPreferences.getBoolean("shared_prefs", true))
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                else startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        binding.splashImageView.startAnimation(anim);
        binding.splashTextView.startAnimation(anim);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void setLocale(String lang) {

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();

        Configuration conf = res.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            conf.setLocale(new Locale(lang.toLowerCase()));

        } else {
            conf.locale = new Locale(lang.toLowerCase());

        }

        res.updateConfiguration(conf, dm);
    }
}