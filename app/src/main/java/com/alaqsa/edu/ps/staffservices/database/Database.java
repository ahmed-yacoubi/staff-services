package com.alaqsa.edu.ps.staffservices.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.alaqsa.edu.ps.staffservices.util.Utils;

import static com.alaqsa.edu.ps.staffservices.util.Utils.Database.*;

import com.alaqsa.edu.ps.staffservices.model.*;

import java.util.ArrayList;
import java.util.List;


public class Database extends SQLiteOpenHelper {
    private static Database Instance = null;
    SQLiteDatabase sqLiteDatabase;

    public static Database getInstance(Context context) {
        if (Instance == null) {
            Instance = new Database(context);
        }
        return Instance;
    }

    private Database(Context context) {
        super(context, Utils.Database.DB_NAME, null, Utils.Database.VERSION);// pass a context and name of database and version
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String createCollegeTable = "create table  " + TB_COLLEGE + "  ( " + COLLEGE_ID + " TEXT PRIMARY KEY  , "
                + COLLEGE_NAME + " TEXT  )";

        String createDepartmentTable = "create table  " + TB_DEPARTMENT + "  ( " + DEPARTMENT_ID + " TEXT , "
                + DEPARTMENT_NAME + " TEXT , " + DEPARTMENT_COLLEGE_ID + " TEXT " +
                " , PRIMARY KEY (" + DEPARTMENT_ID + " , " + DEPARTMENT_COLLEGE_ID + ")" + ")";


        String createEmployeeTable = "create table  " + TB_EMPLOYEE + "  ( " + EMPLOYEE_COLLEGE_EMAIL + " TEXT PRIMARY KEY  , "
                + EMPLOYEE_COLLEGE_ID + " TEXT , " + EMPLOYEE_DEPARTMENT_ID + " TEXT , "
                + EMPLOYEE_SPECIALIZE + " TEXT , " + EMPLOYEE_IMG + " TEXT , " + EMPLOYEE_CITY + " TEXT ,"
                + EMPLOYEE_PERSONAL_EMAIL + "  TEXT , " + EMPLOYEE_COLLAGE_NAME + "  TEXT , "
                + EMPLOYEE_DEPARTMENT_NAME + "  TEXT , " + EMPLOYEE_PHONE_NO + " TEXT , " + EMPLOYEE_NAME_ARB + " TEXT ,"
                + EMPLOYEE_NAME_ENG + "  TEXT , " + EMPLOYEE_GENDER + " TEXT , " + EMPLOYEE_CITIZENSHIP + " TEXT ,"
                + EMPLOYEE_DATE_BIRTH + "  TEXT , " + EMPLOYEE_GOVERNORATE + " TEXT , " + EMPLOYEE_NEIGHBORHOOD + " TEXT ,"
                + EMPLOYEE_PASSWORD + " TEXT )";

        //                String jop_title = cursor.getString(cursor.getColumnIndex(EMPLOYEE_COLLAGE_NAME));
        //                String jop_title = cursor.getString(cursor.getColumnIndex(EMPLOYEE_DEPARTMENT_NAME));
        String createStudent_infoTable = "create table  " + TB_STUDENT + "  ( " + STUDENT_ID + " INTEGER PRIMARY KEY  , "
                + STUDENT_NAME + " TEXT , " + STUDENT_COLLEGE + " TEXT , " + STUDENT_DEPARTMENT + " TEXT , "
                + STUDENT_PHONE + " TEXT , " + STUDENT_ADDRESS + " TEXT , " + STUDENT_CITY + " TEXT ,"
                + STUDENT_LEVEL + "  INTEGER , " + STUDENT_ACHIEVEMENT_HOURS + " INTEGER , " + STUDENT_GPA + " REAL ,"
                + STUDENT_SCHOOL_RATE + " REAL )";



        String createSubjectTable = "create table  " + TB_SUBJECT + "  ( " + SUBJECT_ID + " TEXT , "
                + SUBJECT_NAME + " TEXT , " + SUBJECT_GENDER + " TEXT , "
                + SUBJECT_DIVISION + " TEXT , " + SUBJECT_FINALEXAM_DATE + " TEXT , "
                + SUBJECT_COLLEGE + " TEXT , " + SUBJECT_DEPARTMENT + " TEXT  ,"
                + SUBJECT_SEMESTER + " text , "
                + SUBJECT_DATE + " TEXT , " + SUBJECT_TIME + " TEXT , "
                + SUBJECT_HALL + "  TEXT "
                + " , PRIMARY KEY( " + SUBJECT_SEMESTER + "," + SUBJECT_ID + " , " + SUBJECT_DIVISION + " , " + SUBJECT_TIME + ")" + ")";


        String createRegisterSubjectTable = "create table  " + TB_SUBJECT_REGISTER + "  ( "
                + SUB_REGISTER_ID + " INTEGER PRIMARY KEY autoincrement , " + SUB_REGISTER_STUDENT_ID + " INTEGER , "
                + SUB_REGISTER_SUBJECT_ID + " TEXT , " + SUB_REGISTER_DIVISION + " TEXT , " +
                SUB_REGISTER_MID_MARK + " REAL ," + SUB_REGISTER_FINAL_MARK + " REAL , " +
                SUB_REGISTER_WORK_MARK + " REAL ," + SUB_REGISTER_TOTAL_MARK + " REAL " +
                " , FOREIGN KEY( " + SUB_REGISTER_STUDENT_ID + " ) REFERENCES " + TB_STUDENT + " ( " + STUDENT_ID + ")" +
                " , FOREIGN KEY( " + SUB_REGISTER_SUBJECT_ID + " ) REFERENCES " + TB_SUBJECT + " ( " + SUBJECT_ID + ")" +
                " , FOREIGN KEY( " + SUB_REGISTER_DIVISION + " ) REFERENCES " + TB_SUBJECT + " ( " + SUBJECT_DIVISION + ")" + ")";


        String createAttendanceTable = "create table  " + TB_ATTENDANCE_ABSENCE + "  ( "
                + ATTENDANCE_ABSENCE_ID + " INTEGER    , " + ATTENDANCE_ABSENCE_DATE + " TEXT , "
                + ATTENDANCE_ABSENCE_DAY + " TEXT , " + ATTENDANCE_ABSENCE_STATES + " integer " +
                " , FOREIGN KEY( " + ATTENDANCE_ABSENCE_ID + " ) REFERENCES " + TB_SUBJECT_REGISTER + " ( " + SUB_REGISTER_ID + ")" +
                " , PRIMARY KEY( " + ATTENDANCE_ABSENCE_ID + " , " + ATTENDANCE_ABSENCE_DATE + " , " + ATTENDANCE_ABSENCE_DAY + ")" + ")";


        String createAgendaTable = "create table  " + TB_AGENDA + "  ( " +

                AGENDA_BEG_SEMESTER + " TEXT , " + AGENDA_END_SEMESTER + " TEXT , " +
                AGENDA_START_FINAL_EXAM + " TEXT ," + AGENDA_END_FINAL_EXAM + " TEXT ," +
                AGENDA_START_MIDTERM + " TEXT ," + AGENDA_END_MIDTERM + " TEXT ," +
                AGENDA_ENTRY_START_MIDTERM + " TEXT ," + AGENDA_ENTRY_END_MIDTERM + " TEXT ," +
                AGENDA_ENTRY_START_FINAL_EXAM + " TEXT ," + AGENDA_ENTRY_END_FINAL_EXAM + " TEXT ," +
                AGENDA_END_DRAW + " TEXT, " + AGENDA_NAME + " TEXT , " + AGENDA_KNOW_SEMESTER + " TEXT , " +
                "  PRIMARY KEY( " + AGENDA_KNOW_SEMESTER + " , " +  AGENDA_NAME +   ")" + ")";


        String createObservationTable = "create table  " + TB_OBSERVATION + "  ( " +
                OBSERVATION_NAME_TABLE + " TEXT PRIMARY KEY  , "
                + OBSERVATION_NAME_SUBJECT + " TEXT , " + OBSERVATION_DATE + " TEXT , "
                + OBSERVATION_PERIOD + " TEXT , " + OBSERVATION_HALL + " TEXT )";

        String createMassageTable = "create table  " + TB_MASSAGE + "  ( " +
                MASSAGE_ID + " INTEGER PRIMARY KEY  autoincrement  , "
                + MASSAGE_TYPE + " TEXT , " + MASSAGE_TITLE + " TEXT , "
                + MASSAGE_BODY + " TEXT  )";


        sqLiteDatabase.execSQL(createCollegeTable);
        sqLiteDatabase.execSQL(createDepartmentTable);
        sqLiteDatabase.execSQL(createEmployeeTable);
        sqLiteDatabase.execSQL(createStudent_infoTable);
        sqLiteDatabase.execSQL(createSubjectTable);
        sqLiteDatabase.execSQL(createRegisterSubjectTable);
        sqLiteDatabase.execSQL(createAgendaTable);
        sqLiteDatabase.execSQL(createObservationTable);
        sqLiteDatabase.execSQL(createAttendanceTable);
        sqLiteDatabase.execSQL(createMassageTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
//****************************************  INSERT   *******************************************

    public Boolean insert_college(College college) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLLEGE_ID, college.getCollageId());
        contentValues.put(COLLEGE_NAME, college.getCollageName());
        long result = query.insert(TB_COLLEGE, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Boolean insert_department(Department department) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DEPARTMENT_ID, department.getDepartmentId());
        contentValues.put(DEPARTMENT_NAME, department.getDepartmentName());
        contentValues.put(DEPARTMENT_COLLEGE_ID, department.getCollageId());
        long result = query.insert(TB_DEPARTMENT, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean insert_employee(Employee employee) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(EMPLOYEE_COLLEGE_EMAIL, employee.getCollegeEmail());
        contentValues.put(EMPLOYEE_COLLEGE_ID, employee.getCollegeId());
        contentValues.put(EMPLOYEE_COLLAGE_NAME, employee.getCollageName());
        contentValues.put(EMPLOYEE_DEPARTMENT_ID, employee.getDepartmentId());
        contentValues.put(EMPLOYEE_DEPARTMENT_NAME, employee.getDepartmentName());
        contentValues.put(EMPLOYEE_SPECIALIZE, employee.getSpecialization());
        contentValues.put(EMPLOYEE_IMG, employee.getImg());
        contentValues.put(EMPLOYEE_CITY, employee.getCity());
        contentValues.put(EMPLOYEE_PERSONAL_EMAIL, employee.getPersonalEmail());
        contentValues.put(EMPLOYEE_PHONE_NO, employee.getPhoneNo());
        contentValues.put(EMPLOYEE_PASSWORD, employee.getPassword());
        contentValues.put(EMPLOYEE_NAME_ARB, employee.getName_arb());
        contentValues.put(EMPLOYEE_NAME_ENG, employee.getName_eng());
        contentValues.put(EMPLOYEE_GENDER, employee.getGender());
        contentValues.put(EMPLOYEE_CITIZENSHIP, employee.getCitizenship());
        contentValues.put(EMPLOYEE_DATE_BIRTH, employee.getDate_birth());
        contentValues.put(EMPLOYEE_GOVERNORATE, employee.getGovernorate());
        contentValues.put(EMPLOYEE_NEIGHBORHOOD, employee.getNeighborhood());

        long result = query.insert(TB_EMPLOYEE, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean insert_student_info(StudentInfo studentInfo) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(STUDENT_ID, studentInfo.getStudentId());
        contentValues.put(STUDENT_NAME, studentInfo.getStudentName());
        contentValues.put(STUDENT_COLLEGE, studentInfo.getCollage());
        contentValues.put(STUDENT_DEPARTMENT, studentInfo.getDepartment());
        contentValues.put(STUDENT_PHONE, studentInfo.getPhoneNo());
        contentValues.put(STUDENT_ADDRESS, studentInfo.getAddress());
        contentValues.put(STUDENT_CITY, studentInfo.getCity());
        contentValues.put(STUDENT_LEVEL, studentInfo.getLevel());
        contentValues.put(STUDENT_ACHIEVEMENT_HOURS, studentInfo.getAchievementHours());
        contentValues.put(STUDENT_GPA, studentInfo.getGPA());
        contentValues.put(STUDENT_SCHOOL_RATE, studentInfo.getSchoolRate());


        long result = query.insert(TB_STUDENT, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean insert_subject(Subject subject) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SUBJECT_SEMESTER, subject.getSemester());
        contentValues.put(SUBJECT_ID, subject.getSubject_id());
        contentValues.put(SUBJECT_NAME, subject.getSubject_name());
        contentValues.put(SUBJECT_GENDER, subject.getGender());
        contentValues.put(SUBJECT_DIVISION, subject.getDivision());
        contentValues.put(SUBJECT_FINALEXAM_DATE, subject.getFinalExamDate());
        contentValues.put(SUBJECT_COLLEGE, subject.getCollage());
        contentValues.put(SUBJECT_DEPARTMENT, subject.getDepartment());
        contentValues.put(SUBJECT_DATE, subject.getDate());
        contentValues.put(SUBJECT_TIME, subject.getTime());
        contentValues.put(SUBJECT_HALL, subject.getHall());

        long result = query.insert(TB_SUBJECT, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean insert_register_subject(int student_id, String subject_id, String division) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SUB_REGISTER_STUDENT_ID, student_id);
        contentValues.put(SUB_REGISTER_SUBJECT_ID, subject_id);
        contentValues.put(SUB_REGISTER_DIVISION, division);
//        contentValues.put(SUB_REGISTER_MID_MARK, marksDetection.getMidMark() );
//        contentValues.put(SUB_REGISTER_WORK_MARK, marksDetection.getWorkMark());
//        contentValues.put(SUB_REGISTER_FINAL_MARK, marksDetection.getFinalMark());
//        contentValues.put(SUB_REGISTER_TOTAL_MARK, marksDetection.getTotalMark());

        long result = query.insert(TB_SUBJECT_REGISTER, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean insert_attendance(int id_attendance, String attendance_date, String attendance_day, int states) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ATTENDANCE_ABSENCE_ID, id_attendance);
        contentValues.put(ATTENDANCE_ABSENCE_DATE, attendance_date);
        contentValues.put(ATTENDANCE_ABSENCE_DAY, attendance_day);
        contentValues.put(ATTENDANCE_ABSENCE_STATES, states);
//        if states == 0  غائب
//        if states == 1  حاضر

        long result = query.insert(TB_ATTENDANCE_ABSENCE, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

//know
    public Boolean insert_agenda(Agenda agenda) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AGENDA_KNOW_SEMESTER, agenda.getKnow_semester());
        contentValues.put(AGENDA_BEG_SEMESTER, agenda.getBeginning_semester());
        contentValues.put(AGENDA_END_SEMESTER, agenda.getEnd_semester());
        contentValues.put(AGENDA_START_FINAL_EXAM, agenda.getStart_final_exam());
        contentValues.put(AGENDA_END_FINAL_EXAM, agenda.getEnd_final_exam());
        contentValues.put(AGENDA_START_MIDTERM, agenda.getStart_midterm());
        contentValues.put(AGENDA_END_MIDTERM, agenda.getEnd_midterm());
        contentValues.put(AGENDA_ENTRY_START_MIDTERM, agenda.getEntry_start_midterm());
        contentValues.put(AGENDA_ENTRY_END_MIDTERM, agenda.getEntry_end_midterm());
        contentValues.put(AGENDA_ENTRY_START_FINAL_EXAM, agenda.getEntry_start_final_exam());
        contentValues.put(AGENDA_ENTRY_END_FINAL_EXAM, agenda.getEntry_end_final_exam());
        contentValues.put(AGENDA_END_DRAW, agenda.getEnd_draw());
        contentValues.put(AGENDA_NAME, agenda.getName_agenda());

        long result = query.insert(TB_AGENDA, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public Boolean insert_observation(Observation observation) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(OBSERVATION_NAME_TABLE, observation.getName());
        contentValues.put(OBSERVATION_NAME_SUBJECT, observation.getName_subject());
        contentValues.put(OBSERVATION_HALL, observation.getHall());
        contentValues.put(OBSERVATION_PERIOD, observation.getPeriod());
        contentValues.put(OBSERVATION_DATE, observation.getDate());
        long result = query.insert(TB_OBSERVATION, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Boolean insert_massage(Massage massage) {
        SQLiteDatabase query = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(MASSAGE_TYPE, massage.getType_massage());
        contentValues.put(MASSAGE_TITLE, massage.getTitle_massage());
        contentValues.put(MASSAGE_BODY, massage.getBody_massage());
        long result = query.insert(TB_MASSAGE, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }


    //****************************************  GET   *******************************************

    public ArrayList<College> getColleges() {
        ArrayList<College> colleges = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TB_COLLEGE, null);

        if (cursor.moveToFirst()) {
            do {
//                id
                String id = cursor.getString(cursor.getColumnIndex(COLLEGE_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLLEGE_NAME));

                College college = new College(name, id);

                colleges.add(college);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return colleges;
    }
    //        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TB_FOOD + " where " +
//                FOOD_CLN6_category + " =? and " + FOOD_CLN2_name + " LIKE? ", args);

    public List<Department> getDepartmentByCollege(String college_id) {
        ArrayList<Department> departments = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] arg = {college_id};
        Cursor cursor = db.rawQuery("select * from " + TB_DEPARTMENT + " where " + DEPARTMENT_COLLEGE_ID + " = ?", arg);

        if (cursor.moveToFirst()) {
            do {
//                id
                String id = cursor.getString(cursor.getColumnIndex(DEPARTMENT_ID));
                String name = cursor.getString(cursor.getColumnIndex(DEPARTMENT_NAME));
                String depart_college_id = cursor.getString(cursor.getColumnIndex(DEPARTMENT_COLLEGE_ID));

                Department department = new Department(id, name, depart_college_id);

                departments.add(department);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return departments;
    }

//    public List<Employee> getLastEmployees() {
//        ArrayList<Employee> employees = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from " + TB_EMPLOYEE, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                String college_email = cursor.getString(cursor.getColumnIndex(EMPLOYEE_COLLEGE_EMAIL));
//                String name_arb = cursor.getString(cursor.getColumnIndex(EMPLOYEE_NAME_ARB));
//                String name_eng = cursor.getString(cursor.getColumnIndex(EMPLOYEE_NAME_ENG));
//                String employee_college_id = cursor.getString(cursor.getColumnIndex(EMPLOYEE_COLLEGE_ID));
//                String department_id = cursor.getString(cursor.getColumnIndex(EMPLOYEE_DEPARTMENT_ID));
//                String specialize = cursor.getString(cursor.getColumnIndex(EMPLOYEE_SPECIALIZE));
//                String img = cursor.getString(cursor.getColumnIndex(EMPLOYEE_IMG));
//                String city = cursor.getString(cursor.getColumnIndex(EMPLOYEE_CITY));
//                String personal_email = cursor.getString(cursor.getColumnIndex(EMPLOYEE_PERSONAL_EMAIL));
//                String phone = cursor.getString(cursor.getColumnIndex(EMPLOYEE_PHONE_NO));
//                String departmentName = cursor.getString(cursor.getColumnIndex(EMPLOYEE_COLLAGE_NAME));
//                String collageName = cursor.getString(cursor.getColumnIndex(EMPLOYEE_DEPARTMENT_NAME));
//                String gender = cursor.getString(cursor.getColumnIndex(EMPLOYEE_GENDER));
//                String citizenship = cursor.getString(cursor.getColumnIndex(EMPLOYEE_CITIZENSHIP));
//                String date_birth = cursor.getString(cursor.getColumnIndex(EMPLOYEE_DATE_BIRTH));
//                String governorate = cursor.getString(cursor.getColumnIndex(EMPLOYEE_GOVERNORATE));
//                String neighborhood = cursor.getString(cursor.getColumnIndex(EMPLOYEE_NEIGHBORHOOD));
//
//                Employee employee = new Employee(name_arb, name_eng, gender, citizenship, date_birth,
//                        governorate, city, neighborhood, college_email, personal_email,
//                        phone, employee_college_id, department_id, specialize, img,
//                        collageName, departmentName);
//                employees.add(employee);
//            } while (cursor.moveToNext());
//            cursor.close();
//        }
//        return employees;
//    }

    public StudentInfo getStudentById(int id) {
        StudentInfo studentInfo = new StudentInfo();
        SQLiteDatabase db = getReadableDatabase();
        String[] arg = {id + ""};
        Cursor cursor = db.rawQuery("select * from " + TB_STUDENT + " where " + STUDENT_ID + " = ?", arg);

        if (cursor.moveToFirst()) {
            int studentId = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
            String studentName = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
            String department = cursor.getString(cursor.getColumnIndex(STUDENT_DEPARTMENT));
            int achievementHours = cursor.getInt(cursor.getColumnIndex(STUDENT_ACHIEVEMENT_HOURS));
            double schoolRate = cursor.getDouble(cursor.getColumnIndex(STUDENT_SCHOOL_RATE));
            double GPA = cursor.getDouble(cursor.getColumnIndex(STUDENT_GPA));
            String city = cursor.getString(cursor.getColumnIndex(STUDENT_CITY));
            String phoneNo = cursor.getString(cursor.getColumnIndex(STUDENT_PHONE));
            String address = cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS));
            int level = cursor.getInt(cursor.getColumnIndex(STUDENT_LEVEL));
            String collage = cursor.getString(cursor.getColumnIndex(STUDENT_COLLEGE));

            studentInfo = new StudentInfo(studentId, studentName, department, achievementHours,
                    schoolRate, GPA, city, phoneNo, address, level, collage);
        }
        cursor.close();
        return studentInfo;
    }

//    public StudentInfo getStudentByName(String name) {
//        StudentInfo studentInfo = new StudentInfo();
//        SQLiteDatabase db = getReadableDatabase();
//        String[] arg = {name};
//        Cursor cursor = db.rawQuery("select * from " + TB_STUDENT + " where " + STUDENT_NAME + " = ?", arg);
//
//        if (cursor.moveToFirst()) {
//            int studentId = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
//            String studentName = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
//            String department = cursor.getString(cursor.getColumnIndex(STUDENT_DEPARTMENT));
//            int achievementHours = cursor.getInt(cursor.getColumnIndex(STUDENT_ACHIEVEMENT_HOURS));
//            double schoolRate = cursor.getDouble(cursor.getColumnIndex(STUDENT_SCHOOL_RATE));
//            double GPA = cursor.getDouble(cursor.getColumnIndex(STUDENT_GPA));
//            String city = cursor.getString(cursor.getColumnIndex(STUDENT_CITY));
//            String phoneNo = cursor.getString(cursor.getColumnIndex(STUDENT_PHONE));
//            String address = cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS));
//            int level = cursor.getInt(cursor.getColumnIndex(STUDENT_LEVEL));
//            String collage = cursor.getString(cursor.getColumnIndex(STUDENT_COLLEGE));
//
//            studentInfo = new StudentInfo(studentId, studentName, department, achievementHours,
//                    schoolRate, GPA, city, phoneNo, address, level, collage);
//        }
//        cursor.close();
//        return studentInfo;
//    }

//    public List<StudentInfo> getStudentsByDepartment(String department) {
//        ArrayList<StudentInfo> infoArrayList = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        String[] arg = {department};
//        Cursor cursor = db.rawQuery("select * from " + TB_STUDENT + " where " + STUDENT_DEPARTMENT + " = ?", arg);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int studentId = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
//                String studentName = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
//                String studentDepartment = cursor.getString(cursor.getColumnIndex(STUDENT_DEPARTMENT));
//                int achievementHours = cursor.getInt(cursor.getColumnIndex(STUDENT_ACHIEVEMENT_HOURS));
//                double schoolRate = cursor.getDouble(cursor.getColumnIndex(STUDENT_SCHOOL_RATE));
//                double GPA = cursor.getDouble(cursor.getColumnIndex(STUDENT_GPA));
//                String city = cursor.getString(cursor.getColumnIndex(STUDENT_CITY));
//                String phoneNo = cursor.getString(cursor.getColumnIndex(STUDENT_PHONE));
//                String address = cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS));
//                int level = cursor.getInt(cursor.getColumnIndex(STUDENT_LEVEL));
//                String collage = cursor.getString(cursor.getColumnIndex(STUDENT_COLLEGE));
//
//                StudentInfo studentInfo = new StudentInfo(studentId, studentName, studentDepartment, achievementHours,
//                        schoolRate, GPA, city, phoneNo, address, level, collage);
//                infoArrayList.add(studentInfo);
//
//            } while (cursor.moveToNext());
//            cursor.close();
//        }
//        return infoArrayList;
//    }

//   to   Temporary
    public List<StudentInfo> getAllStudents() {
        ArrayList<StudentInfo> infoArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TB_STUDENT, null);

        if (cursor.moveToFirst()) {
            do {
                int studentId = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
                String studentName = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
                String studentDepartment = cursor.getString(cursor.getColumnIndex(STUDENT_DEPARTMENT));
                int achievementHours = cursor.getInt(cursor.getColumnIndex(STUDENT_ACHIEVEMENT_HOURS));
                double schoolRate = cursor.getDouble(cursor.getColumnIndex(STUDENT_SCHOOL_RATE));
                double GPA = cursor.getDouble(cursor.getColumnIndex(STUDENT_GPA));
                String city = cursor.getString(cursor.getColumnIndex(STUDENT_CITY));
                String phoneNo = cursor.getString(cursor.getColumnIndex(STUDENT_PHONE));
                String address = cursor.getString(cursor.getColumnIndex(STUDENT_ADDRESS));
                int level = cursor.getInt(cursor.getColumnIndex(STUDENT_LEVEL));
                String collage = cursor.getString(cursor.getColumnIndex(STUDENT_COLLEGE));

                StudentInfo studentInfo = new StudentInfo(studentId, studentName, studentDepartment, achievementHours,
                        schoolRate, GPA, city, phoneNo, address, level, collage);
                infoArrayList.add(studentInfo);

            } while (cursor.moveToNext());
            cursor.close();
        }
        return infoArrayList;
    }

    public List<Subject> getSubject(String semester) {
        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        List<String> idSubjects = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + TB_SUBJECT + " where " + SUBJECT_SEMESTER + " =? ", new String[]{semester});
//     Caused by: android.database.sqlite.SQLiteException: no such column: subject_semester (code 1 SQLITE_ERROR[1]): , while compiling: select * from subject_table where subject_semester =?
        if (cursor.moveToFirst()) {
            do {
                String subject_id = cursor.getString(cursor.getColumnIndex(SUBJECT_ID));
                String date = cursor.getString(cursor.getColumnIndex(SUBJECT_DATE));
                String time = cursor.getString(cursor.getColumnIndex(SUBJECT_TIME));
                String collage = cursor.getString(cursor.getColumnIndex(SUBJECT_COLLEGE));
                String department = cursor.getString(cursor.getColumnIndex(SUBJECT_DEPARTMENT));
                String subject_name = cursor.getString(cursor.getColumnIndex(SUBJECT_NAME));
                String gender = cursor.getString(cursor.getColumnIndex(SUBJECT_GENDER));
                String division = cursor.getString(cursor.getColumnIndex(SUBJECT_DIVISION));
                String finalExamDate = cursor.getString(cursor.getColumnIndex(SUBJECT_FINALEXAM_DATE));
                String hall = cursor.getString(cursor.getColumnIndex(SUBJECT_HALL));

//                Students

                Cursor cursor1 = db.rawQuery("select " + STUDENT_NAME
                                + " from " + TB_SUBJECT_REGISTER + " join " + TB_STUDENT + " ON "
                                + SUB_REGISTER_STUDENT_ID + " = " + STUDENT_ID +
                                " AND  "
                                + SUB_REGISTER_SUBJECT_ID + " =  '" + subject_id + "'"
                        , null);

                Subject subject = new Subject(subject_id, date, time, collage, department,
                        subject_name, gender, division, finalExamDate, hall,
                        cursor1.getCount(), semester);

                if (!idSubjects.contains(subject_id)) {
                    idSubjects.add(subject_id);
                    subjectArrayList.add(subject);


                }
            } while (cursor.moveToNext());
            cursor.close();
        }
        return subjectArrayList;
    }

    public ArrayList<StudentsInSubject> getAllStudentsInSubjectWithoutAttendance(String id_subject , String subjectDivision) { //String division
        ArrayList<StudentsInSubject> studentsInSubjects = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
//SELECT  table_student.student_name , table_student.student_id , subject_table.subject_name FROM
//    subject_register_table
//    JOIN table_student , subject_table
//    ON  subject_register_table.subject_register_student_id = table_student.student_id  and subject_register_table.subject_register_subject_id  = subject_table.subject_id ;
/*
    SELECT  table_student.student_name , subject_register_table.subject_register_subject_id FROM
    subject_register_table
    JOIN table_student
    ON  subject_register_table.subject_register_student_id = table_student.student_id  and subject_register_table.subject_register_subject_id  = "TCIS3103";
*/
        Cursor cursor = db.rawQuery("select " + STUDENT_NAME + "," + SUB_REGISTER_ID + ","
                        + SUB_REGISTER_SUBJECT_ID + "," + SUB_REGISTER_DIVISION
                        + " from " + TB_SUBJECT_REGISTER + " join " + TB_STUDENT + " ON "
                        + SUB_REGISTER_STUDENT_ID + " = " + STUDENT_ID +
                        " AND  "
                        + SUB_REGISTER_SUBJECT_ID + " =  '" + id_subject + "'" +
                        " AND "
                        + SUB_REGISTER_DIVISION + " =  '" + subjectDivision + "'"

                , null);

        if (cursor.moveToFirst()) {
            do {
                int id_register = cursor.getInt(cursor.getColumnIndex(SUB_REGISTER_ID));
                String student_name = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
                String subject_id = cursor.getString(cursor.getColumnIndex(SUB_REGISTER_SUBJECT_ID));
                String division = cursor.getString(cursor.getColumnIndex(SUB_REGISTER_DIVISION));

                StudentsInSubject studentsInSubject = new StudentsInSubject();
                studentsInSubject.setId_attendance(id_register);
                studentsInSubject.setStudent_name(student_name);
                studentsInSubject.setSubject_id(subject_id);
                studentsInSubject.setDivision(division);
                studentsInSubjects.add(studentsInSubject);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return studentsInSubjects;
    }


    public ArrayList<StudentsInSubject> getAllStudentsInSubjectWithAttendance(String id_subject , String subjectDivision) { //String division
        ArrayList<StudentsInSubject> studentsInSubjects = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
//SELECT  table_student.student_name , table_student.student_id , subject_table.subject_name FROM
//    subject_register_table
//    JOIN table_student , subject_table
//    ON  subject_register_table.subject_register_student_id = table_student.student_id  and subject_register_table.subject_register_subject_id  = subject_table.subject_id ;
/*
    SELECT  table_student.student_name , subject_register_table.subject_register_subject_id FROM
    subject_register_table
    JOIN table_student
    ON  subject_register_table.subject_register_student_id = table_student.student_id  and subject_register_table.subject_register_subject_id  = "TCIS3103";
*/
        Cursor cursor = db.rawQuery("select " + STUDENT_NAME + "," + SUB_REGISTER_ID + ","
                        + SUB_REGISTER_SUBJECT_ID + "," + SUB_REGISTER_DIVISION
                        + " from " + TB_SUBJECT_REGISTER + " join " + TB_STUDENT + " ON "
                        + SUB_REGISTER_STUDENT_ID + " = " + STUDENT_ID +
                        " AND  "
                        + SUB_REGISTER_SUBJECT_ID + " =  '" + id_subject + "'" +
                        " AND "
                        + SUB_REGISTER_DIVISION + " =  '" + subjectDivision + "'"

                , null);

        if (cursor.moveToFirst()) {
            do {
                int id_register = cursor.getInt(cursor.getColumnIndex(SUB_REGISTER_ID));
                String student_name = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
                String subject_id = cursor.getString(cursor.getColumnIndex(SUB_REGISTER_SUBJECT_ID));
                String division = cursor.getString(cursor.getColumnIndex(SUB_REGISTER_DIVISION));

                StudentsInSubject studentsInSubject = new StudentsInSubject();
                studentsInSubject.setId_attendance(id_register);
                studentsInSubject.setStudent_name(student_name);
                studentsInSubject.setSubject_id(subject_id);
                studentsInSubject.setDivision(division);
                studentsInSubjects.add(studentsInSubject);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return studentsInSubjects;
    }

    public ArrayList<Agenda> getAgenda(String type_system ,String knowSemester) {
        ArrayList<Agenda> agendaArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TB_AGENDA + " where "+ AGENDA_NAME + "=? and " + AGENDA_KNOW_SEMESTER + "=?" ,
                 new String[]{type_system  , knowSemester});

        if (cursor.moveToFirst()) {
            do {
                String know_semester = cursor.getString(cursor.getColumnIndex(AGENDA_KNOW_SEMESTER));
                String name_agenda = cursor.getString(cursor.getColumnIndex(AGENDA_NAME));
                String beginning_semester = cursor.getString(cursor.getColumnIndex(AGENDA_BEG_SEMESTER));
                String end_semester = cursor.getString(cursor.getColumnIndex(AGENDA_END_SEMESTER));
                String start_final_exam = cursor.getString(cursor.getColumnIndex(AGENDA_START_FINAL_EXAM));
                String start_midterm = cursor.getString(cursor.getColumnIndex(AGENDA_START_MIDTERM));
                String end_final_exam = cursor.getString(cursor.getColumnIndex(AGENDA_END_FINAL_EXAM));
                String end_midterm = cursor.getString(cursor.getColumnIndex(AGENDA_END_MIDTERM));
                String entry_start_midterm = cursor.getString(cursor.getColumnIndex(AGENDA_ENTRY_START_MIDTERM));
                String entry_end_midterm = cursor.getString(cursor.getColumnIndex(AGENDA_ENTRY_END_MIDTERM));
                String entry_start_final_exam = cursor.getString(cursor.getColumnIndex(AGENDA_ENTRY_START_FINAL_EXAM));
                String entry_end_final_exam = cursor.getString(cursor.getColumnIndex(AGENDA_ENTRY_END_FINAL_EXAM));
                String end_draw = cursor.getString(cursor.getColumnIndex(AGENDA_END_DRAW));

                Agenda agenda = new Agenda(know_semester ,name_agenda,
                        beginning_semester, end_semester, start_final_exam, end_final_exam, start_midterm,
                        end_midterm, entry_start_midterm, entry_end_midterm,
                        entry_start_final_exam, entry_end_final_exam, end_draw);

                agendaArrayList.add(agenda);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return agendaArrayList;
    }

    //    احضار جدول المراقبة من خلال اددخال اسم المراقبة (نصفي او ,نهائي)
    public ArrayList<Observation> getObservation(String name_observation) {
        ArrayList<Observation> observations = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] arg = {name_observation};
        Cursor cursor = db.rawQuery
                ("select * from " + TB_OBSERVATION + " where " + OBSERVATION_NAME_TABLE + " = ?", arg);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(OBSERVATION_NAME_TABLE));
                String subject_name = cursor.getString(cursor.getColumnIndex(OBSERVATION_NAME_SUBJECT));
                String hall = cursor.getString(cursor.getColumnIndex(OBSERVATION_HALL));
                String period = cursor.getString(cursor.getColumnIndex(OBSERVATION_PERIOD));
                String date = cursor.getString(cursor.getColumnIndex(OBSERVATION_DATE));
                Observation observation = new Observation(name, subject_name, date, period, hall);
                observations.add(observation);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return observations;
    }

    public ArrayList<Massage> getMassage(String type_massage) {
        ArrayList<Massage> massageArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] arg = {type_massage};
        Cursor cursor = db.rawQuery
                ("select * from " + TB_OBSERVATION + " where " + OBSERVATION_NAME_TABLE + " = ?", arg);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MASSAGE_ID));
                String type = cursor.getString(cursor.getColumnIndex(MASSAGE_TYPE));
                String title = cursor.getString(cursor.getColumnIndex(MASSAGE_TITLE));
                String body = cursor.getString(cursor.getColumnIndex(MASSAGE_BODY));
                Massage massage = new Massage(id, type, title, body);

                massageArrayList.add(massage);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return massageArrayList;
    }


//****************************************  Delete Table   *******************************************


    public void delete_tableSubject() {
        sqLiteDatabase.execSQL("drop Table if exists " + TB_SUBJECT);
//        sqLiteDatabase.execSQL("delete from " + TB_SUBJECT);
    }

    public void delete_tableStudent() {
        sqLiteDatabase.execSQL("drop Table if exists " + TB_STUDENT);
//        sqLiteDatabase.execSQL("delete from " + TB_STUDENT);
    }

    public void delete_tableSubjectRegister() {
        sqLiteDatabase.execSQL("drop Table if exists " + TB_SUBJECT_REGISTER);
//        sqLiteDatabase.execSQL("delete from " + TB_SUBJECT_REGISTER);
    }
}
