package com.alaqsa.edu.ps.staffservices.database;

import android.app.Activity;
import android.content.Context;

import com.alaqsa.edu.ps.staffservices.model.College;
import com.alaqsa.edu.ps.staffservices.model.Department;
import com.alaqsa.edu.ps.staffservices.model.Employee;
import com.alaqsa.edu.ps.staffservices.model.StudentInfo;
import com.alaqsa.edu.ps.staffservices.model.Subject;
import com.alaqsa.edu.ps.staffservices.other.CheckInternet;

import java.util.ArrayList;
import java.util.List;

public class Cashing {

    Activity activity;
    private static Cashing Instance = null;
    static Database database;

    private Cashing(Context activity) {
        this.activity = (Activity) activity;
    }

    public static Cashing getInstance(Activity activity) {
        if (Instance == null) {
            database = Database.getInstance(activity);
            Instance = new Cashing(activity);
        }
        return Instance;
    }


//**************************************** insert Data Not Change      *******************************************

    public  void insertDataNotChange(){

        for (College college : getCollages()) {
            database.insert_college(college);
        }
        for (Department department : getDepartments()) {
            database.insert_department(department);
        }

        database.insert_employee(getEmployeeData());
    }

    private List<College> getCollages(){
        ArrayList<College>collegeArrayList=new ArrayList<>();
        return collegeArrayList;
    }

    private List<Department> getDepartments() {
        ArrayList<Department>departmentArrayList=new ArrayList<>();

        return departmentArrayList;
    }

    private Employee getEmployeeData() {
        Employee employee=new Employee();

        return employee;
    }



//**************************************** insert Data  Change      *******************************************

    public void insertDataChange(){
        database.delete_tableSubject();
        database.delete_tableStudent();
        database.delete_tableSubjectRegister();

        for (StudentInfo studentInfo : getStudentsInfo()) {
            database.insert_student_info(studentInfo);
        }
        for (Subject subject : getSubjects()) {
            database.insert_subject(subject);
        }

//        database.insert_register_subject()
    }




//     كل ما يعمل Get لهدول التنتين بدو يروح يحذف كل جدول تسجيل المواد TB_SUBJECT_REGISTER
//     ويعمل تسجيل الهم من اول وجديد عشان يمكن يكون في طالب سحب المادة أو سجل مادة
//    هيو معمول فوق في داله insertDataChange
    private List<StudentInfo> getStudentsInfo(){
        ArrayList<StudentInfo> infoArrayList=new ArrayList<>();
        return infoArrayList;
    }

    private List<Subject> getSubjects(){
        ArrayList<Subject>arrayList=new ArrayList<>();
        return arrayList;
    }



//    private List<Employee> getEmployees(){
//        ArrayList<Employee>employeeArrayList=new ArrayList<>();
//
//        return employeeArrayList;
//    }
}
