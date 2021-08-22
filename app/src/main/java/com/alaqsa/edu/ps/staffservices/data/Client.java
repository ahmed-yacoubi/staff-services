package com.alaqsa.edu.ps.staffservices.data;

import android.util.Log;

import com.alaqsa.edu.ps.staffservices.model.Api;
import com.alaqsa.edu.ps.staffservices.model.AppoimentApi;
import com.alaqsa.edu.ps.staffservices.model.Login;
import com.alaqsa.edu.ps.staffservices.model.LoginData;
import com.alaqsa.edu.ps.staffservices.model.appoiment_diwanApi;
import com.alaqsa.edu.ps.staffservices.model.appoiment_universityApi;
import com.alaqsa.edu.ps.staffservices.model.basicinfo;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static String BASE_URL = "http://10.100.1.10/public/android/employees/v1/";

    private EmployeeApi employeeApi;
    private static Client newInstance;


    public Client(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getUnsafeOkHttpClient().build())
                .build();
        employeeApi=retrofit.create(EmployeeApi.class);
        Log.d("client","client");

    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient() {

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Client getNewInstance() {
        if (newInstance==null){
            newInstance=new Client();

        }
        Log.d("instance","instance");


        return newInstance;
    }


    //Login by username and password.
    public Call<Login> isSuccess(LoginData data){
        return employeeApi.isSuccess(data);
    }



    //Logout the user.
    public Call<ResponseBody> logout(String accessToken){
        return employeeApi.logOutUser(accessToken);
    }

    //Get basic information for employee.
    public  Call<Api> apiCall (String accessToken){
        return employeeApi.getBasicInfo(accessToken);
    }

    //Get management positions for the employee.
    public  Call<AppoimentApi> EmployeePositions (String accessToken){
        return employeeApi.getEmployeeAppoiments(accessToken);
    }

    //Get University appointment data for the employee.
    public  Call<appoiment_universityApi> appoiment_universityInfo(String accessToken){
        return employeeApi.getEmployeeAppoimentsUniversity(accessToken);
    }

    //Get diwan appointment data for the employee.
    public  Call<appoiment_diwanApi> appoiment_diwanApiCall(String accessToken){
        return employeeApi.getAppoimentDiwanApiCall(accessToken);
    }



}
