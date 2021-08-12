package com.alaqsa.edu.ps.staffservices.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.ActivityContainerBinding;
import com.alaqsa.edu.ps.staffservices.databinding.ActivityMainBinding;
import com.alaqsa.edu.ps.staffservices.fragment.HomeFragment;
import com.alaqsa.edu.ps.staffservices.fragment.MenuFragment;
import com.alaqsa.edu.ps.staffservices.fragment.NotificationsFragment;
import com.alaqsa.edu.ps.staffservices.fragment.SchedulesFragment;

public class ContainerActivity extends AppCompatActivity {

    private ActivityContainerBinding binding;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");

        Fragment selectedFragment = (Fragment) bundle.getSerializable("fragment");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerFrameLayout, selectedFragment).commit();
    }
}