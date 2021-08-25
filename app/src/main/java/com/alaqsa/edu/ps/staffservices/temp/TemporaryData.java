package com.alaqsa.edu.ps.staffservices.temp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import com.alaqsa.edu.ps.staffservices.database.Database;
import com.alaqsa.edu.ps.staffservices.model.Agenda;
import com.alaqsa.edu.ps.staffservices.model.College;
import com.alaqsa.edu.ps.staffservices.model.Department;
import com.alaqsa.edu.ps.staffservices.model.Employee;
import com.alaqsa.edu.ps.staffservices.model.Massage;
import com.alaqsa.edu.ps.staffservices.model.Observation;
import com.alaqsa.edu.ps.staffservices.model.StudentInfo;
import com.alaqsa.edu.ps.staffservices.model.StudentsInSubject;
import com.alaqsa.edu.ps.staffservices.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_CITIZENSHIP;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_CITY;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_COLLAGE_NAME;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_COLLEGE_EMAIL;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_COLLEGE_ID;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_DATE_BIRTH;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_DEPARTMENT_ID;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_DEPARTMENT_NAME;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_GENDER;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_GOVERNORATE;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_IMG;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_NAME_ARB;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_NAME_ENG;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_NEIGHBORHOOD;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_PERSONAL_EMAIL;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_PHONE_NO;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.EMPLOYEE_SPECIALIZE;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.MASSAGE_BODY;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.MASSAGE_TITLE;
import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.MASSAGE_TYPE;


public class TemporaryData {
    Activity activity;
    Database database;

    public TemporaryData(Activity activity) {
        this.activity = activity;
        database = Database.getInstance(activity);
    }

    public void dataGeneration() {
        for (College college : setCollages()) {
            Log.e("myError", "dataGeneration: " + college.getCollageId());
            database.insert_college(college);
        }
        for (Department department : setDepartments()) {
            database.insert_department(department);
        }

        for (Subject subject : setSubjects()) {
            database.insert_subject(subject);
        }

        database.insert_employee(setEmployeeData());

        for (Employee employee : setEmployees()) {
            database.insert_employee(employee);
        }
        for (StudentInfo studentInfo : setStudentsInfo()) {
            database.insert_student_info(studentInfo);
        }

        registrationSubjectStudent(database.getSubject("First semester "), database.getAllStudents());


        setAttendance();  // insert Attendance

        for (Agenda agenda : setAgenda()) {
            database.insert_agenda(agenda);
        }

        for (Observation observation : setObservations()) {
            database.insert_observation(observation);
        }

        for (Massage massage : setMassages()) {
            database.insert_massage(massage);
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
        employee.setCollegeEmail("Mustafa_Mohammed@aqsa.com");
        employee.setName_arb("احمد علي اليعقوبي");
        employee.setName_eng("Ahmed Ali");
        employee.setCollegeId("c2");
        employee.setDepartmentId("dep1");
        employee.setSpecialization("IT");
        employee.setImg("");
        employee.setCity("Gaza");
        employee.setPersonalEmail("Ahmed@gmail.com");
        employee.setPhoneNo("0599967638");
        employee.setDepartmentName("department " + 1);
        employee.setCollageName("collage" + 1);
        employee.setGender("male");
        employee.setCitizenship("لاجيء");
        employee.setDate_birth("1999/2/12");
        employee.setGovernorate("Rafah");
        employee.setNeighborhood("BARAZEL");
        employee.setPassword("123123123");
        return employee;
    }

    private List<Employee> setEmployees() {
        List<Employee> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {

            Employee employee = new Employee();
            employee.setCollegeEmail("AHMED" + i + "@aqsa.com");
            employee.setName_arb("احمد اليعقوبي");
            employee.setName_eng("Ahmed ali");

            if (i % 2 == 0) {
                employee.setCollegeId("c1");
                employee.setDepartmentId("dep1");
                employee.setDepartmentName("department " + 1);
                employee.setCollageName("collage" + 1);

            } else {
                employee.setCollegeId("c2");
                employee.setDepartmentId("dep2");
                employee.setDepartmentName("department " + 2);
                employee.setCollageName("collage" + 2);

            }
            employee.setSpecialization("IT");
            employee.setImg("");
            employee.setCity("Gaza");
            employee.setPersonalEmail("ahemd@gmail.com");
            employee.setPhoneNo("0599967638");
            employee.setGender("male");
            employee.setCitizenship("لاجيء");
            employee.setDate_birth("1999/21/12");
            employee.setGovernorate("RAFAH");
            employee.setNeighborhood("BARAZEL");
            employee.setPassword("123123123");

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
            subject.setSemester("First semester ");
            subject.setSubject_id("TCIS3" + i);
            subject.setSubject_name("Java" + i);
            subject.setFinalExamDate("2021/12/29");
            subject.setDivision("10" + i);
            subject.setCollage("c2");
            subject.setDepartment("dep1");
            if (i % 2 == 0) {
                subject.setGender("male");
                subject.setTime("10-12PM");
                subject.setHall("L301");
            } else {
                subject.setGender("female");
                subject.setTime("12-14PM");
                subject.setHall("P230");
            }
            subject.setDate("2021/8/17");
//            List<String[]> place = new ArrayList<>();
//            place.add(new String[]{"غزة-مبنى الوحدة P230", "12-14PM"});
//            place.add(new String[]{"خان يونس البحر - L301", "10-12PM"});
//            subject.setPlaceTimeLecture("خان يونس البحر - L301" + "/" + "غزة-مبنى الوحدة P230/" + "/12-14PM");
            list.add(subject);
        }
        return list;
    }


    private void registrationSubjectStudent(List<Subject> subjects, List<StudentInfo> students) {

        Random randomGenerator = new Random();


        for (StudentInfo studentInfo : students) {
            int index = randomGenerator.nextInt(subjects.size());
            database.insert_register_subject(studentInfo.getStudentId(), subjects.get(index).getSubject_id(), subjects.get(index).getDivision());
        }
    }

    private void setAttendance() {
        for (int i = 100; i <= 105; i++) {
            try {                                                                                    //TCIS3100
//                    public Boolean insert_attendance(int id_attendance, String attendance_date, String attendance_day, int states) {
                for (StudentsInSubject studentsInSubject : database.getAllStudentsInSubjectWithAttendance("TCIS3" + i, "Division102")) {
                    Log.d("TAGzxzx", "setAttendance: " + studentsInSubject);
                    database.insert_attendance(studentsInSubject.getId_attendance(),
                            "2021/8/1", "sat", 0);
                }
            } catch (Exception e) {

            }
        }
    }

    private List<Agenda> setAgenda() {
        List<Agenda> list = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Agenda agenda = new Agenda();

//             String know_semester;
//    String name_agenda;
//    String beginning_semester;
//    String end_semester;
//    String start_final_exam;
//    String end_final_exam;
//    String start_midterm;
//    String end_midterm;
//    String entry_start_midterm;
//    String entry_end_midterm;
//    String entry_start_final_exam;
//    String entry_end_final_exam;
//    String end_draw;

            agenda.setName_agenda("System\t" + i);
            agenda.setKnow_semester("2021-2022");
            int m = i;
            agenda.setBeginning_semester("2020/" + m + "/15");
            agenda.setEnd_semester("2021/" + m * 2 + "/20");
            agenda.setStart_final_exam("2021/" + m * 2 + "/" + 20 + i);
            agenda.setEnd_final_exam("2021/" + m * 2 + "/" + 20 + i);
            agenda.setStart_midterm("2020/" + m * 2 + "/15");
            agenda.setEnd_midterm("2020/" + m * 2 + "/" + 15 + i);
            agenda.setEntry_start_midterm("un enable");
            agenda.setEntry_start_final_exam("un enable");
            agenda.setEntry_end_midterm("un enable");
            agenda.setEntry_end_final_exam("un enable");
            agenda.setEnd_draw("un enable");
            list.add(agenda);
        }
        return list;
    }

    private List<Observation> setObservations() {
        List<Observation> observations = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            Observation observation = new Observation();
            observation.setName("Semester" + i);
            observation.setName_subject("Java" + i);
            observation.setHall("A821" + i);

            if (i % 2 == 0) {
                observation.setPeriod("first");
            } else {
                observation.setPeriod("second");
            }
            observation.setDate("2021/8/" + i);
            observations.add(observation);
        }
        return observations;
    }


    private List<Massage> setMassages() {
        List<Massage> massages = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            Massage massage = new Massage();
            if (i % 2 == 0) {
                massage.setType_massage("Massages");
                massage.setBody_massage("رقم الطالب 130011999 برمجة تطبيقات الهواتف =100");
            } else {
                massage.setType_massage("notification");
                massage.setBody_massage("يوم الخميس زووم الساعه 6:15 id 22231556 الدكتور يوسف حمودة");
            }
            massage.setTitle_massage("ALAQSA-REG");
            massages.add(massage);
        }
        return massages;
    }


}
