package com.alaqsa.edu.ps.staffservices.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqsa.edu.ps.staffservices.activity.ContainerActivity;
import com.alaqsa.edu.ps.staffservices.data.Client;
import com.alaqsa.edu.ps.staffservices.databinding.FragmentBasicInfoBinding;
import com.alaqsa.edu.ps.staffservices.model.Api;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BasicInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BasicInfoFragment extends Fragment  {

    private FragmentBasicInfoBinding binding;
    Client client;
    SharedPreferences sp;


    public interface onBasicInfoEventListener {
        void basicInfoEvent();
    }

    onBasicInfoEventListener basicInfoEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            basicInfoEventListener = (onBasicInfoEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BasicInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BasicInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BasicInfoFragment newInstance(String param1, String param2) {
        BasicInfoFragment fragment = new BasicInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = Client.getNewInstance();
        sp=getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);

        getUser(new com.alaqsa.edu.ps.staffservices.interfaces.Callback() {
            @Override
            public void getBasicInfo(com.alaqsa.edu.ps.staffservices.model.basicinfo basicinfo) {
                Log.d("employee:",basicinfo.getFname_ar());
                binding.basicInfoTextViewNameV.setText(basicinfo.getFname_ar()+" "+basicinfo.getSname_ar()+" "+basicinfo.getTname_ar()+" "+basicinfo.getLname_ar());
                binding.basicInfoTextViewNameEnV.setText(basicinfo.getFname_en()+" "+basicinfo.getSname_en()+" "+basicinfo.getTname_en()+" "+basicinfo.getLname_en());
                binding.basicInfoTextViewCityV.setText(basicinfo.getBirth_city_name_ar());
                binding.basicInfoTextViewEmailV.setText(basicinfo.getUniversity_email());
                binding.basicInfoTextViewGenderV.setText(basicinfo.getGender_name());
                binding.basicInfoTextViewMobileV.setText(basicinfo.getMobile_no());
                binding.basicInfoTextViewMobileV.setText(basicinfo.getHome_telno());
                binding.basicInfoTextViewMobV.setText(basicinfo.getMobile_key()+basicinfo.getMobile_no());
                binding.basicInfoTextViewPEmailV.setText(basicinfo.getPersonal_email());

            }
        });





        basicInfoEventListener.basicInfoEvent();
    }

    private void getUser(com.alaqsa.edu.ps.staffservices.interfaces.Callback callback){
        Call<Api> apiCall= client.apiCall(sp.getString("AccessToken",null));
        apiCall.enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, Response<Api> response) {
                if (response.isSuccessful()){
                    callback.getBasicInfo(response.body().getBasicinfo()[0]);
                    Log.d("basicinfo",response.body().getBasicinfo()[0].getFname_ar());
                }else{
                    Log.d("basicinfo",response.message());
                }
            }

            @Override
            public void onFailure(Call<Api> call, Throwable t) {
                Log.d("FailedEmployee",t.getMessage());
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBasicInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.basicInfoImageViewEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("fragment", "EditBasicInfoFragment");
                startActivity(new Intent(getContext(), ContainerActivity.class)
                        .putExtra("bundle", bundle));
            }
        });
    }
}