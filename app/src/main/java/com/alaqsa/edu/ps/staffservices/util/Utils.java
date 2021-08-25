package com.alaqsa.edu.ps.staffservices.util;

public class Utils {

    public static class SharedPref {
        public static final String SHARED_PREF_NAME = "main";
        public static final String TEMP_DATA = "tempData";
        public static final String STORAGE_DAY = "day_story";
        public static final String CHANGE_LANG="change_lang";

    }

    public static class Database {
        public static final String DB_NAME = "servesDB";
        public static final int VERSION = 5;

        //****************************************  table_college   *******************************************
        public static final String TB_COLLEGE = "table_college";
        public static final String COLLEGE_ID = "college_id";
        public static final String COLLEGE_NAME = "college_name";

        //****************************************  table_department   *******************************************
        public static final String TB_DEPARTMENT = "table_department";
        public static final String DEPARTMENT_ID = "department_id";
        public static final String DEPARTMENT_NAME = "department_name";
        public static final String DEPARTMENT_COLLEGE_ID = "department_college_id";

        //****************************************  table_employee   *******************************************

        public static final String TB_EMPLOYEE = "table_employee";
        public static final String EMPLOYEE_NAME_ARB = "employee_name_arb";
        public static final String EMPLOYEE_NAME_ENG = "employee_name_eng";
        public static final String EMPLOYEE_GENDER = "employee_gender";
        public static final String EMPLOYEE_CITIZENSHIP = "employee_citizenship";
        public static final String EMPLOYEE_DATE_BIRTH = "employee_date_birth";
        public static final String EMPLOYEE_GOVERNORATE = "employee_governorate";
        public static final String EMPLOYEE_CITY = "employee_city";
        public static final String EMPLOYEE_NEIGHBORHOOD = "employee_neighborhood";
        public static final String EMPLOYEE_COLLEGE_EMAIL = " employee_college_email";
        public static final String EMPLOYEE_PERSONAL_EMAIL = "employee_personal_email";
        public static final String EMPLOYEE_PHONE_NO = "employee_phone_no";
        public static final String EMPLOYEE_COLLEGE_ID = "employee_college_id";
        public static final String EMPLOYEE_DEPARTMENT_ID = "employee_department_id";
        public static final String EMPLOYEE_SPECIALIZE = "employee_specialize";
        public static final String EMPLOYEE_IMG = "employee_img";
        public static final String EMPLOYEE_PASSWORD = "employee_password";
        public static final String EMPLOYEE_COLLAGE_NAME = "employee_collageName";
        public static final String EMPLOYEE_DEPARTMENT_NAME = "employee_departmentName";

        //**************************************** table_student    *******************************************
        public static final String TB_STUDENT = "table_student";
        public static final String STUDENT_ID = "student_id";
        public static final String STUDENT_NAME = "student_name";
        public static final String STUDENT_COLLEGE = "student_college";
        public static final String STUDENT_DEPARTMENT = "student_department";
        public static final String STUDENT_PHONE = "student_pone";
        public static final String STUDENT_ADDRESS = "student_address";
        public static final String STUDENT_CITY = "student_city";
        public static final String STUDENT_LEVEL = "student_level";
        public static final String STUDENT_ACHIEVEMENT_HOURS = "student_achievementHours";
        public static final String STUDENT_GPA = "student_gpa";
        public static final String STUDENT_SCHOOL_RATE = "student_school_rate";


        //****************************************  subject_table   *******************************************
        public static final String TB_SUBJECT = "subject_table";
        public static final String SUBJECT_ID = "subject_id";
        public static final String SUBJECT_NAME = "subject_name";
        public static final String SUBJECT_GENDER = "subject_gender";
        public static final String SUBJECT_DIVISION = "subject_division";
        public static final String SUBJECT_FINALEXAM_DATE = "subject_final_exam_date";
        public static final String SUBJECT_COLLEGE = "subject_college";
        public static final String SUBJECT_DEPARTMENT = "subject_department";
        public static final String SUBJECT_DATE = "subject_date";
        public static final String SUBJECT_TIME = "subject_time";
        public static final String SUBJECT_HALL = "subject_hall";
        public static final String SUBJECT_SEMESTER = "subject_semester";

        //**************************************** subject_register_table    *******************************************
        public static final String TB_SUBJECT_REGISTER = "subject_register_table";
        public static final String SUB_REGISTER_ID = "subject_register_id";
        public static final String SUB_REGISTER_STUDENT_ID = "subject_register_student_id";
        public static final String SUB_REGISTER_SUBJECT_ID = "subject_register_subject_id";
        public static final String SUB_REGISTER_DIVISION = "subject_register_division";
        public static final String SUB_REGISTER_MID_MARK = "subject_register_mid_mark";
        public static final String SUB_REGISTER_FINAL_MARK = "subject_register_final_mark";
        public static final String SUB_REGISTER_WORK_MARK = "subject_register_work_mark";
        public static final String SUB_REGISTER_TOTAL_MARK = "subject_register_total_mark";

        //**************************************** Agenda_table    *******************************************
        public static final String TB_AGENDA = "agenda_table";
        public static final String AGENDA_NAME = "agenda_name";
        public static final String AGENDA_KNOW_SEMESTER = "agenda_knowSemester";
        public static final String AGENDA_BEG_SEMESTER = "agenda_beginning_semester";
        public static final String AGENDA_END_SEMESTER = "agenda_end_semester";
        public static final String AGENDA_START_MIDTERM = "agenda_start_midterm";
        public static final String AGENDA_END_MIDTERM = "agenda_end_midterm";
        public static final String AGENDA_START_FINAL_EXAM = "agenda_start_final_exam";
        public static final String AGENDA_END_FINAL_EXAM = "agenda_end_final_exam";
        public static final String AGENDA_ENTRY_START_MIDTERM = "agenda_entry_start_midterm";
        public static final String AGENDA_ENTRY_END_MIDTERM = "agenda_entry_end_midterm";
        public static final String AGENDA_ENTRY_START_FINAL_EXAM = "agenda_entry_start_final_exam";
        public static final String AGENDA_ENTRY_END_FINAL_EXAM = "agenda_entry_end_final_exam";
        public static final String AGENDA_END_DRAW = "agenda_end_draw";

        //**************************************** Observation_table    *******************************************
        public static final String TB_OBSERVATION = "observation_table";
        public static final String OBSERVATION_NAME_TABLE = "observation_name";
        public static final String OBSERVATION_NAME_SUBJECT = "observation_name_subject";
        public static final String OBSERVATION_DATE = "observation_date";
        public static final String OBSERVATION_PERIOD = "observation_period";
        public static final String OBSERVATION_HALL = "observation_hall";

        //**************************************** Attendance_Absence_table    *******************************************
        public static final String  TB_ATTENDANCE_ABSENCE= "attendance_absence_table";
        public static final String  ATTENDANCE_ABSENCE_ID= "attendance_absence_id";
        public static final String  ATTENDANCE_ABSENCE_DATE= "attendance_absence_date";
        public static final String  ATTENDANCE_ABSENCE_DAY= "attendance_absence_day";
        public static final String  ATTENDANCE_ABSENCE_STATES= "attendance_absence_states";

        public static final String TB_MASSAGE = "table_massage";
        public static final String MASSAGE_ID = "massage_id";
        public static final String  MASSAGE_TYPE= "massage_type";
        public static final String  MASSAGE_TITLE= "massage_title";
        public static final String MASSAGE_BODY= "massage_body";





    }
}
