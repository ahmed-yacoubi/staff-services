package com.alaqsa.edu.ps.staffservices.data;

import com.alaqsa.edu.ps.staffservices.model.Api;
import com.alaqsa.edu.ps.staffservices.model.AppoimentApi;
import com.alaqsa.edu.ps.staffservices.model.Login;
import com.alaqsa.edu.ps.staffservices.model.LoginData;
import com.alaqsa.edu.ps.staffservices.model.appoiment_diwanApi;
import com.alaqsa.edu.ps.staffservices.model.appoiment_universityApi;
import com.alaqsa.edu.ps.staffservices.model.basicinfo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface EmployeeApi {

    //Login by username and password.
    @POST("login")
    Call<Login> isSuccess(@Body LoginData data);


    //Get basic information for employee.
    @GET("basicinfo?act=all&sortPassport_no=asc&rowCount=1000")
    Call<Api> getBasicInfo(@Header("accessToken") String accessToken);


    //Get management positions for the employee.
    @GET("appoiment?act=positions&page=1&rowCount=10&sortEmp_jobno=asc")
    Call<AppoimentApi> getEmployeeAppoiments(@Header("accessToken") String accessToken);


    //Get University appointment data for the employee.
    @GET("appoiment?act=university&page=1&rowCount=10&sortEmp_jobno=asc")
    Call<appoiment_universityApi> getEmployeeAppoimentsUniversity(@Header("accessToken") String accessToken);


    //Get diwan appointment data for the employee.
    @GET("appoiment?act=diwan&page=1&rowCount=10&sortEmp_jobno=asc")
    Call<appoiment_diwanApi> getAppoimentDiwanApiCall(@Header("accessToken") String accessToken);

    //Logout the user.
    @GET("logout")
    Call<ResponseBody> logOutUser(@Header("accessToken") String accessToken);
}
