package com.alaqsa.edu.ps.staffservices.api;

import android.util.Log;

import com.alaqsa.edu.ps.staffservices.data.Client;
import com.alaqsa.edu.ps.staffservices.interfaces.BasicInfoCallback;
import com.alaqsa.edu.ps.staffservices.interfaces.DiwanAppoimentsCallback;
import com.alaqsa.edu.ps.staffservices.interfaces.LoginCallback;
import com.alaqsa.edu.ps.staffservices.interfaces.ManagmentPositionsCallback;
import com.alaqsa.edu.ps.staffservices.interfaces.UniversityAppoimentsCallback;
import com.alaqsa.edu.ps.staffservices.model.Api;
import com.alaqsa.edu.ps.staffservices.model.AppoimentApi;
import com.alaqsa.edu.ps.staffservices.model.Login;
import com.alaqsa.edu.ps.staffservices.model.LoginData;
import com.alaqsa.edu.ps.staffservices.model.appoiment_diwanApi;
import com.alaqsa.edu.ps.staffservices.model.appoiment_universityApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class Response {
    Client client = Client.getNewInstance();
    
    private static Response response;


    public static Response newInstance(){
        if (response==null){
            response=new Response();
        }
        return response;
    }

    public void login(LoginData data, LoginCallback callback) {
        Call<Login> call = client.isSuccess(data);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, retrofit2.Response<Login> response) {


                if (response.isSuccessful()) {
                    Log.d("isSuccess", response.body().getAccessToken());
                    callback.login(true, response.body().getAccessToken());

                } else {
                    Log.d("isSuccess", "false  " + response.message());
                    callback.login(false, response.message());

                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Log.d("LoginFailed", "Login Failed." + t.getMessage());
                callback.login(false, t.getMessage());
            }
        });
    }

    public void logout(String accessToken,LoginCallback callback) {
        client.logout(accessToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    callback.logout(true);
                }else{
                    callback.logout(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.logout(false);
            }
        });
    }

    public void getBaseInfo(String accessToken, BasicInfoCallback callback) {
        client.apiCall(accessToken).enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, retrofit2.Response<Api> response) {
                if (response.isSuccessful()) {
                    callback.onGetBasicInfo(response.body());
                } else {
                    callback.onUnSuccessful(response.message());

                }
            }

            @Override
            public void onFailure(Call<Api> call, Throwable t) {
                callback.onUnSuccessful(t.getMessage());
            }
        });
    }

    public void getManagementPositions(String accessToken, ManagmentPositionsCallback callback) {
        client.EmployeePositions(accessToken).enqueue(new Callback<AppoimentApi>() {
            @Override
            public void onResponse(Call<AppoimentApi> call, retrofit2.Response<AppoimentApi> response) {
                if (response.isSuccessful()) {
                    callback.onGetPositionInfo(response.body());
                } else {
                    callback.onUnSuccessful(response.message());
                }
            }

            @Override
            public void onFailure(Call<AppoimentApi> call, Throwable t) {
                callback.onUnSuccessful(t.getMessage());
            }
        });
    }

    public void getUniversityAppointmentData(String accessToken, UniversityAppoimentsCallback callback){
        client.appoiment_universityInfo(accessToken).enqueue(new Callback<appoiment_universityApi>() {
            @Override
            public void onResponse(Call<appoiment_universityApi> call, retrofit2.Response<appoiment_universityApi> response) {
                if (response.isSuccessful()){
                    callback.onGetUniversityAppoiments(response.body());
                }else{
                    callback.onUnSuccessful(response.message());
                }
            }

            @Override
            public void onFailure(Call<appoiment_universityApi> call, Throwable t) {
                callback.onUnSuccessful(t.getMessage());
            }
        });
    }

    public void getDiwanAppointmentData(String accessToken, DiwanAppoimentsCallback callback){
        client.appoiment_diwanApiCall(accessToken).enqueue(new Callback<appoiment_diwanApi>() {
            @Override
            public void onResponse(Call<appoiment_diwanApi> call, retrofit2.Response<appoiment_diwanApi> response) {
                if (response.isSuccessful()){
                    callback.onGetDiwanInfo(response.body());
                }else{
                    callback.onUnSuccessful(response.message());

                }
            }

            @Override
            public void onFailure(Call<appoiment_diwanApi> call, Throwable t) {
                callback.onUnSuccessful(t.getMessage());
            }
        });
    }
}
