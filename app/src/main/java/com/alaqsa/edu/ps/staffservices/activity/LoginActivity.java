package com.alaqsa.edu.ps.staffservices.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alaqsa.edu.ps.staffservices.data.Client;
import com.alaqsa.edu.ps.staffservices.databinding.ActivityLoginBinding;
import com.alaqsa.edu.ps.staffservices.model.Login;
import com.alaqsa.edu.ps.staffservices.model.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
                        login(data);
                    }
                });
            }
        }).start();


        binding.loginTextViewForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RetrievePasswordActivity.class));
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

    private void login(LoginData data) {

        Call<Login> call = client.isSuccess(data);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {


                if (response.isSuccessful()) {
                    Log.d("isSuccess", response.body().getAccessToken());
                    editor.putBoolean("isLogin", true);
                    editor.putString("AccessToken", response.body().getAccessToken());
                    editor.apply();
                    editor.commit();

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Log.d("isSuccess", "false  "+response.message());
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Log.d("LoginFailed", "Login Failed." + t.getMessage());

            }
        });
    }
}