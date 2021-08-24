package com.alaqsa.edu.ps.staffservices.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alaqsa.edu.ps.staffservices.api.Response;
import com.alaqsa.edu.ps.staffservices.data.Client;
import com.alaqsa.edu.ps.staffservices.databinding.ActivityLoginBinding;
import com.alaqsa.edu.ps.staffservices.interfaces.LoginCallback;
import com.alaqsa.edu.ps.staffservices.model.LoginData;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    Client client;
    Response response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        response= Response.newInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();



        new Thread(new Runnable() {
            @Override
            public void run() {
                client = Client.getNewInstance();
                binding.loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LoginData data = new LoginData(binding.loginEditTextUsername.getText().toString(), binding.loginEditTextPassword.getText().toString());

                       new Thread(new Runnable() {
                           @Override
                           public void run() {
                               response.login(data, new LoginCallback() {
                                   @Override
                                   public void login(boolean status, String accessTocken) {
                                       if (status){
                                           Log.d("isSuccess", accessTocken);
                                           editor.putBoolean("isLogin", true);
                                           editor.putString("AccessToken", accessTocken);
                                           editor.apply();
                                           editor.commit();
                                           startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                           finish();
                                           Toast.makeText(getBaseContext(), "Login Successfully.", Toast.LENGTH_SHORT).show();
                                       }else{
                                           Log.d("isSuccess", false+"\n"+accessTocken);
                                       }
                                   }

                                   @Override
                                   public void logout(boolean status) {

                                   }
                               });
                           }
                       }).start();
                    }
                });
            }
        }).start();


        binding.loginTextViewForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RetrievePasswordActivity.class));
                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

}