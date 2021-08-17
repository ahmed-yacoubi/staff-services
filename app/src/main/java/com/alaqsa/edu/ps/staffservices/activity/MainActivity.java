package com.alaqsa.edu.ps.staffservices.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.ActivityMainBinding;
import com.alaqsa.edu.ps.staffservices.fragment.dialog.DialogFragment;
import com.alaqsa.edu.ps.staffservices.fragment.EditBasicInfoFragment;
import com.alaqsa.edu.ps.staffservices.fragment.HomeFragment;
import com.alaqsa.edu.ps.staffservices.fragment.MenuFragment;
import com.alaqsa.edu.ps.staffservices.fragment.NotificationsFragment;
import com.alaqsa.edu.ps.staffservices.fragment.SchedulesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements DialogFragment.onSomeEventListener,
        HomeFragment.onHomeEventListener,
        SchedulesFragment.onSchedulesEventListener,
        NotificationsFragment.onNotificationEventListener,
        MenuFragment.onMenuEventListener{

    private ActivityMainBinding binding;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        fragmentTransaction.replace(R.id.mainFrameLayout, new HomeFragment()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.item_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.item_schedules:
                    selectedFragment = new SchedulesFragment();
                    break;
                case R.id.item_notifications:
                    selectedFragment = new NotificationsFragment();
                    break;
                case R.id.item_menu:
                    selectedFragment = new MenuFragment();
                    break;
            }

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.mainFrameLayout, selectedFragment).commit();
            return true;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }


    @Override
    public void someEvent(boolean state, String fragment) {

    }

    @Override
    public void homeEvent() {
        binding.mainTextViewTitle.setText(R.string.HomePage);
    }

    @Override
    public void schedulesEvent() {
        binding.mainTextViewTitle.setText(R.string.SchedulesPage);
    }

    @Override
    public void notificationEvent() {
        binding.mainTextViewTitle.setText(R.string.NotificationPage);
    }

    @Override
    public void menuEvent() {
        if (getBaseContext()==this)
        binding.mainTextViewTitle.setText(R.string.AlaqsaUniversity);
    }
}