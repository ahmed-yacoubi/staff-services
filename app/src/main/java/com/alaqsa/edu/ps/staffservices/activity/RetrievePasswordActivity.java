package com.alaqsa.edu.ps.staffservices.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alaqsa.edu.ps.staffservices.databinding.ActivityRetrievePasswordBinding;

public class RetrievePasswordActivity extends AppCompatActivity {

    private ActivityRetrievePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrievePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.retrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}