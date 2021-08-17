package com.alaqsa.edu.ps.staffservices.fragment.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alaqsa.edu.ps.staffservices.R;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    TextView tv_title1, tv_title2;
    Button btn1, btn2;
    String fragment;
    LinearLayout layout,layout2;

    public interface onSomeEventListener {
        void someEvent(boolean state,String fragment);
    }

    onSomeEventListener someEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    public DialogFragment() {

    }

    public static DialogFragment newInstance(String title1, String title2, String btn1, String btn2,String fragment) {

        DialogFragment dialogFragment = new DialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title1", title1);
        bundle.putString("title2", title2);
        bundle.putString("btn1", btn1);
        bundle.putString("btn2", btn2);
        bundle.putString("fragment", fragment);
        dialogFragment.setStyle(DialogFragment.STYLE_NO_FRAME, 0);
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.dialog_design, container, false);
        Window window=getDialog().getWindow();
        getDialog().getWindow().requestFeature(window.FEATURE_NO_TITLE);
        bind(root);
        Bundle bundle = getArguments();

        String title1 = bundle.getString("title1");
        String title2 = bundle.getString("title2");
        String txtbtn1 = bundle.getString("btn1");
        String txtbtn2 = bundle.getString("btn2");

        if (title1==null){
            tv_title1.setVisibility(View.GONE);
        }else{
            tv_title1.setText(title1);
            tv_title2.setVisibility(View.VISIBLE);
        }
        if (title2==null){
            tv_title2.setVisibility(View.GONE);
        }else{
            tv_title2.setText(title2);
            tv_title2.setVisibility(View.VISIBLE);
        }

        btn1.setText(txtbtn1);
        btn2.setText(txtbtn2);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        getDialog().setCanceledOnTouchOutside(true);
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.80);

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onStart() {
        super.onStart();
        fragment=getArguments().getString("fragment");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragment.equalsIgnoreCase("ChangePasswordFragment")){
                    getDialog().dismiss();
                    someEventListener.someEvent(true,"ChangePasswordFragment");
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
    }

    private void bind(View root) {
        tv_title1 = root.findViewById(R.id.dialog_tv_title1);
        tv_title2 = root.findViewById(R.id.dialog_tv_title2);
        btn1 = root.findViewById(R.id.dialog_btn1);
        btn2 = root.findViewById(R.id.dialog_btn2);
        layout=root.findViewById(R.id.dialog_layout);
        layout2=root.findViewById(R.id.dialog_layout2);
    }
}
