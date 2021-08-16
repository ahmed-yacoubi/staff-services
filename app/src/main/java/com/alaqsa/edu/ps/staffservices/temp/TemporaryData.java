package com.alaqsa.edu.ps.staffservices.temp;

import android.app.Activity;
import android.content.SharedPreferences;

import com.alaqsa.edu.ps.staffservices.database.Database;
import com.alaqsa.edu.ps.staffservices.model.Agenda;
import com.alaqsa.edu.ps.staffservices.model.College;
import com.alaqsa.edu.ps.staffservices.model.Department;
import com.alaqsa.edu.ps.staffservices.model.Employee;
import com.alaqsa.edu.ps.staffservices.model.StudentInfo;
import com.alaqsa.edu.ps.staffservices.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TemporaryData {
    Activity activity;
    SharedPreferences sp;
    Database database;

    public TemporaryData(Activity activity) {
        this.activity = activity;
    }

    public void dataGeneration() {
        database = Database.getInstance(activity);

        for (College college : setCollages()) {
            database.insert_college(college);
        }
        for (Department department : setDepartments()) {
            database.insert_department(department);
        }

//        insert employee user
        database.insert_employee(setEmployeeData());

        for (Employee employee : setEmployees()) {
            database.insert_employee(employee);
        }
        for (StudentInfo studentInfo : setStudentsInfo()) {
            database.insert_student_info(studentInfo);
        }
        for (Subject subject : setSubjects()) {
            database.insert_subject(subject);
        }
        registrationSubjectStudent(database.getSubject(), database.getAllStudents());

        for (Agenda agenda : setAgenda()){
            database.insert_agenda(agenda);
        }
    }


    private List<College> setCollages() {

        List<College> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            College college = new College();
            college.setCollageId("c" + i);
            college.setCollageName("collage" + i);
            list.add(college);
        }
        return list;
    }

    private List<Department> setDepartments() {
        List<Department> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Department department = new Department();
            department.setCollageId("c2");
            department.setDepartmentId("dep" + i);
            department.setDepartmentName("department " + i);
            list.add(department);
        }
        return list;
    }

    private Employee setEmployeeData() {
        Employee employee = new Employee();
        employee.setCity("Gaza");
        employee.setName("ahmed");
        employee.setImg(null);
        employee.setJobTitle("Doctor");
        employee.setCollegeId("c2");
        employee.setDepartmentId("dep1");
        employee.setPhoneNo("0599967638");
        employee.setPersonalEmail("ahmeddev1999@gmail.com");
        employee.setCollegeEmail("ahmed@aqsa.com");
        employee.setPassword("123123123");

        return employee;
    }

    private List<Employee> setEmployees() {
        List<Employee> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Employee employee = new Employee();
            employee.setCity("Gaza");
            employee.setName("ahmed");
            employee.setImg(null);
            employee.setJobTitle("Doctor");
            employee.setCollegeId("c2");
            employee.setDepartmentId("dep1");
            employee.setPhoneNo("05999676" + i);
            employee.setPersonalEmail("ahmeddev1999@gmail.com");
            employee.setCollegeEmail("ahmed@aqsa.com");
            employee.setPassword(null);
            list.add(employee);
        }
        return list;
    }

    private List<StudentInfo> setStudentsInfo() {
        List<StudentInfo> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setCity("Rafah" + i);
            studentInfo.setAddress("My Address" + i);
            studentInfo.setAchievementHours(100 + i);
            studentInfo.setGPA(80 + i);
            studentInfo.setLevel(4);
            studentInfo.setPhoneNo("059996668" + i);
            studentInfo.setSchoolRate(85 + i);
            studentInfo.setStudentName("Student " + i);
            studentInfo.setStudentId(130118120 + i);
            studentInfo.setDepartment("dep1");
            studentInfo.setCollage("c2");
            list.add(studentInfo);
        }
        return list;

    }

    private List<Subject> setSubjects() {
        List<Subject> list = new ArrayList<>();
        for (int i = 100; i <= 105; i++) {
            Subject subject = new Subject();
            subject.setFinalExamDate("2021/12/29");
            subject.setDivision("Division" + i);
            subject.setCollage("c2");
            subject.setDivision("dep1");
            if (i % 2 == 0)
                subject.setGender("male");
            else
                subject.setGender("female");

            //            List<String[]> place = new ArrayList<>();
//            place.add(new String[]{"غزة-مبنى الوحدة P230", "12-14PM"});
//            place.add(new String[]{"خان يونس البحر - L301", "10-12PM"});
            subject.setPlaceTimeLecture("خان يونس البحر - L301" + "/10-12PM" + "غزة-مبنى الوحدة P230/" + "/12-14PM");
            subject.setSubjectId("TCIS3" + i);
            subject.setSubjectName("Java" + i);
            list.add(subject);
        }
        return list;
    }

    private void registrationSubjectStudent(List<Subject> subjects, List<StudentInfo> students) {

        Random randomGenerator = new Random();


        for (StudentInfo studentInfo : students) {
            int index = randomGenerator.nextInt(subjects.size());
            database.insert_register_subject(studentInfo.getStudentId(), subjects.get(index).getSubjectId(), subjects.get(index).getDivision());
        }
    }


    private List<Agenda> setAgenda() {
        List<Agenda> list = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Agenda agenda = new Agenda();
            agenda.setName_agenda("System\t" + i);
            int m = i;
            agenda.setBeginning_semester("2020/" + m + "/15");
            agenda.setEnd_semester("2021/" + m * 2 + "/20");
            agenda.setStart_final_exam("2021/" + m * 2 + "/" + 20 + i);
            agenda.setEnd_final_exam("2021/" + m * 2 + "/" + 20 + i);
            agenda.setStart_midterm("2020/" + m*2 + "/15");
            agenda.setEnd_midterm("2020/" + m *2 + "/"+15+i);
            agenda.setEntry_start_midterm("un enable");
            agenda.setEntry_start_final_exam("un enable");
            agenda.setEntry_end_midterm("un enable");
            agenda.setEntry_end_final_exam("un enable");
            agenda.setEnd_draw("un enable");
            list.add(agenda);
        }
        return list;
    }


}
