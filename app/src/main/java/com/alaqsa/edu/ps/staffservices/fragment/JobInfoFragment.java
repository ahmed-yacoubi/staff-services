package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.data.Client;
import com.alaqsa.edu.ps.staffservices.model.AppoimentApi;
import com.alaqsa.edu.ps.staffservices.model.appoiment_diwanApi;
import com.alaqsa.edu.ps.staffservices.model.appoiment_university;
import com.alaqsa.edu.ps.staffservices.model.appoiment_universityApi;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobInfoFragment extends Fragment  {

    Client client;

    public interface onJobInfoEventListener {
        void jobInfoEvent();
    }

    onJobInfoEventListener jobInfoEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            jobInfoEventListener = (onJobInfoEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    SharedPreferences sp;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JobInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobInfoFragment newInstance(String param1, String param2) {
        JobInfoFragment fragment = new JobInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client=Client.getNewInstance();
        sp=getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);

        String accessToken=sp.getString("AccessToken",null);
//المناصب
        client.EmployeePositions(accessToken).enqueue(new Callback<AppoimentApi>() {
            @Override
            public void onResponse(Call<AppoimentApi> call, Response<AppoimentApi> response) {
                if (response.isSuccessful()){
                    Log.d("JobInfo",response.body().getAppoiment_positions()[0].getStructure_name_ar());
                }else{
                    Log.d("JobInfo2",response.message());
                }
            }

            @Override
            public void onFailure(Call<AppoimentApi> call, Throwable t) {
                Log.d("JobInfoFailed",t.getMessage());
            }
        });



        client.appoiment_universityInfo(accessToken).enqueue(new Callback<appoiment_universityApi>() {
            @Override
            public void onResponse(Call<appoiment_universityApi> call, Response<appoiment_universityApi> response) {
                if (response.isSuccessful()){
                    Log.d("isssuccess",response.isSuccessful()+"");
                    Log.d("University info:",response.headers().get("accessToken"));
                    Log.d("University info:",response.body().getAppoiment_universities()[0].getRegion_name_ar());
                }else{
                    Log.d("isssuccess",response.isSuccessful()+"");
                }
            }

            @Override
            public void onFailure(Call<appoiment_universityApi> call, Throwable t) {
                Log.d("isFailed",t.getMessage());

            }
        });

        client.appoiment_diwanApiCall(accessToken).enqueue(new Callback<appoiment_diwanApi>() {
            @Override
            public void onResponse(Call<appoiment_diwanApi> call, Response<appoiment_diwanApi> response) {
                Log.d("University info:",response.body().getAppoiment_diwan()[0].getJob_category_name()+"\n"+response.body().getAppoiment_diwan()[0].getAppointment_type_name());

            }

            @Override
            public void onFailure(Call<appoiment_diwanApi> call, Throwable t) {

            }
        });

        jobInfoEventListener.jobInfoEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job_info, container, false);
    }
}