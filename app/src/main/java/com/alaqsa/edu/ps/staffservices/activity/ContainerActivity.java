package com.alaqsa.edu.ps.staffservices.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alaqsa.edu.ps.staffservices.R;
import com.alaqsa.edu.ps.staffservices.databinding.ActivityContainerBinding;
import com.alaqsa.edu.ps.staffservices.databinding.ActivityMainBinding;
import com.alaqsa.edu.ps.staffservices.fragment.AgendaFragment;
import com.alaqsa.edu.ps.staffservices.fragment.AttendanceSheetFragment;
import com.alaqsa.edu.ps.staffservices.fragment.BasicInfoFragment;
import com.alaqsa.edu.ps.staffservices.fragment.ChangePasswordFragment;
import com.alaqsa.edu.ps.staffservices.fragment.EditBasicInfoFragment;
import com.alaqsa.edu.ps.staffservices.fragment.FinalObservationFragment;
import com.alaqsa.edu.ps.staffservices.fragment.HomeFragment;
import com.alaqsa.edu.ps.staffservices.fragment.JobInfoFragment;
import com.alaqsa.edu.ps.staffservices.fragment.MenuFragment;
import com.alaqsa.edu.ps.staffservices.fragment.MidtermObservationFragment;
import com.alaqsa.edu.ps.staffservices.fragment.NotificationsFragment;
import com.alaqsa.edu.ps.staffservices.fragment.ReportsFragment;
import com.alaqsa.edu.ps.staffservices.fragment.SchedulesFragment;
import com.alaqsa.edu.ps.staffservices.fragment.SettingsFragment;
import com.alaqsa.edu.ps.staffservices.fragment.StaffInfoFragment;
import com.alaqsa.edu.ps.staffservices.fragment.ViewStaffFragment;

public class ContainerActivity extends AppCompatActivity implements AgendaFragment.onAgendaEventListener ,
        AttendanceSheetFragment.onAttendanceEventListener ,
        BasicInfoFragment.onBasicInfoEventListener ,
        ChangePasswordFragment.onChangePasswordEventListener ,
        EditBasicInfoFragment.onEditBasicInfoEventListener  ,
        FinalObservationFragment.onFinalObservationEventListener ,
        JobInfoFragment.onJobInfoEventListener ,
        MidtermObservationFragment.onMidTermEventListener ,
        ReportsFragment.onReportsEventListener ,
        SettingsFragment.onSettingsEventListener ,
        StaffInfoFragment.onStaffInfoEventListener ,
        ViewStaffFragment.onViewStaffEventListener ,
        SchedulesFragment.onSchedulesEventListener{

    private ActivityContainerBinding binding;

    private Intent intent;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");

        String selectedFragment = bundle.getString("fragment");
        if (selectedFragment != null) {
            switch (selectedFragment) {
                case "ViewStaffFragment":
                    fragment = new ViewStaffFragment();
                    break;
                case "AgendaFragment":
                    fragment = new AgendaFragment();
                    break;
                case "SchedulesFragment":
                    fragment = new SchedulesFragment();
                    break;
                case "ReportsFragment":
                    fragment = new ReportsFragment();
                    break;
                case "MidtermObservationFragment":
                    fragment = new MidtermObservationFragment();
                    break;
                case "FinalObservationFragment":
                    fragment = new FinalObservationFragment();
                    break;
                case "BasicInfoFragment":
                    fragment = new BasicInfoFragment();
                    break;
                case "JobInfoFragment":
                    fragment = new JobInfoFragment();
                    break;
                case "ChangePasswordFragment":
                    fragment = new ChangePasswordFragment();
                    break;
                case "StaffInfoFragment":
                    fragment = new StaffInfoFragment();
                    break;
                case "EditBasicInfoFragment":
                    fragment = new EditBasicInfoFragment();
                    break;
                case "AttendanceSheetFragment":
                    fragment = new AttendanceSheetFragment();
                    break;
                case "SettingsFragment":
                    fragment = new SettingsFragment();
                    break;
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerFrameLayout, fragment).commit();
        } else {

            startActivity(new Intent(getBaseContext(), MainActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.containerImageViewArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void agendaEvent() {
        binding.containerTextViewTitle.setText(R.string.agenda);
    }

    @Override
    public void attendanceEvent() {
        binding.containerTextViewTitle.setText(R.string.Attendance);

    }

    @Override
    public void basicInfoEvent() {
        binding.containerTextViewTitle.setText(R.string.basic_info);

    }

    @Override
    public void changePasswordEvent() {
        binding.containerTextViewTitle.setText(R.string.change_password);

    }

    @Override
    public void editBasicInfoEvent() {
        binding.containerTextViewTitle.setText(R.string.EditBasicInfo);

    }

    @Override
    public void finalObservationEvent() {
        binding.containerTextViewTitle.setText(R.string.final_observation);

    }

    @Override
    public void jobInfoEvent() {
        binding.containerTextViewTitle.setText(R.string.job_info);

    }

    @Override
    public void midTermEvent() {
        binding.containerTextViewTitle.setText(R.string.midterm_observation);

    }

    @Override
    public void reportsEvent() {
        binding.containerTextViewTitle.setText(R.string.reports);
    }

    @Override
    public void settingsEvent() {
        binding.containerTextViewTitle.setText(R.string.settings);
    }

    @Override
    public void staffInfoEvent() {
        binding.containerTextViewTitle.setText(R.string.StaffInfo);
    }

    @Override
    public void viewStaffEvent() {
        binding.containerTextViewTitle.setText(R.string.view_staff);

    }

    @Override
    public void schedulesEvent() {
        binding.containerTextViewTitle.setText(R.string.SchedulesPage);

    }
}