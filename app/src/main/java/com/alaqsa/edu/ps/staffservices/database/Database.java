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


    //         بدنا ID لل موظف ؟؟
            String createEmployeeTable = "create table  " + TB_EMPLOYEE + "  ( " + EMPLOYEE_COLLEGE_EMAIL + " TEXT PRIMARY KEY  , "
                    + EMPLOYEE_NAME + " TEXT , " + EMPLOYEE_COLLEGE_ID + " TEXT , " + EMPLOYEE_DEPARTMENT_ID + " TEXT , "
                    + EMPLOYEE_SPECIALIZE + " TEXT , " + EMPLOYEE_IMG + " TEXT , " + EMPLOYEE_CITY + " TEXT ,"
                    + EMPLOYEE_PERSONAL_EMAIL + "  TEXT , "
                    + EMPLOYEE_COLLAGE_NAME + "  TEXT , "
                    + EMPLOYEE_DEPARTMENT_NAME + "  TEXT , " + EMPLOYEE_PHONE_NO + " TEXT , " + EMPLOYEE_JOP_TITLE + " TEXT ,"
                    + EMPLOYEE_PASSWORD + " TEXT )";

    //                String jop_title = cursor.getString(cursor.getColumnIndex(EMPLOYEE_COLLAGE_NAME));
    //                String jop_title = cursor.getString(cursor.getColumnIndex(EMPLOYEE_DEPARTMENT_NAME));
            String createStudent_infoTable = "create table  " + TB_STUDENT + "  ( " + STUDENT_ID + " INTEGER PRIMARY KEY  , "
                    + STUDENT_NAME + " TEXT , " + STUDENT_COLLEGE + " TEXT , " + STUDENT_DEPARTMENT + " TEXT , "
                    + STUDENT_PHONE + " TEXT , " + STUDENT_ADDRESS + " TEXT , " + STUDENT_CITY + " TEXT ,"
                    + STUDENT_LEVEL + "  INTEGER , " + STUDENT_ACHIEVEMENT_HOURS + " INTEGER , " + STUDENT_GPA + " REAL ,"
                    + STUDENT_SCHOOL_RATE + " REAL )";


    //        ليش محطوط ال GENDER
            String createSubjectTable = "create table  " + TB_SUBJECT + "  ( " + SUBJECT_ID + " TEXT PRIMARY KEY  , "
                    + SUBJECT_NAME + " TEXT , " + SUBJECT_GENDER + " TEXT , "
                    + SUBJECT_DIVISION + " TEXT , " + SUBJECT_FINALEXAM_DATE + " TEXT , " + SUBJECT_PLACE_TIME + " TEXT ,"
                    + SUBJECT_COLLEGE + "  TEXT , " + SUBJECT_DEPARTMENT + " TEXT )";


            String createRegisterSubjectTable = "create table  " + TB_SUBJECT_REGISTER + "  ( " + SUB_REGISTER_STUDENT_ID + " INTEGER , "
                    + SUB_REGISTER_SUBJECT_ID + " TEXT , " + SUB_REGISTER_DIVISION + " TEXT , " +
                    SUB_REGISTER_MID_MARK + " REAL ," + SUB_REGISTER_FINAL_MARK + " REAL , " +
                    SUB_REGISTER_WORK_MARK + " REAL ," + SUB_REGISTER_TOTAL_MARK + " REAL " +
                    " , FOREIGN KEY( " + SUB_REGISTER_STUDENT_ID + " ) REFERENCES " + TB_STUDENT + " ( " + STUDENT_ID + ")" +
                    " , FOREIGN KEY( " + SUB_REGISTER_SUBJECT_ID + " ) REFERENCES " + TB_SUBJECT + " ( " + SUBJECT_ID + ")" +
                    " , FOREIGN KEY( " + SUB_REGISTER_DIVISION + " ) REFERENCES " + TB_SUBJECT + " ( " + SUBJECT_DIVISION + ")" +
                    " , PRIMARY KEY( " + SUB_REGISTER_STUDENT_ID + " , " + SUB_REGISTER_SUBJECT_ID + " , " + SUB_REGISTER_DIVISION + ")" + ")";

            sqLiteDatabase.execSQL(createCollegeTable);
            sqLiteDatabase.execSQL(createDepartmentTable);
            sqLiteDatabase.execSQL(createEmployeeTable);
            sqLiteDatabase.execSQL(createStudent_infoTable);
            sqLiteDatabase.execSQL(createSubjectTable);
            sqLiteDatabase.execSQL(createRegisterSubjectTable);

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
        contentValues.put(EMPLOYEE_NAME, employee.getName());
        contentValues.put(EMPLOYEE_COLLEGE_ID, employee.getCollegeId());
        contentValues.put(EMPLOYEE_DEPARTMENT_ID, employee.getDepartmentId());
        contentValues.put(EMPLOYEE_SPECIALIZE, employee.getSpecialization());
        contentValues.put(EMPLOYEE_IMG, employee.getImg());
        contentValues.put(EMPLOYEE_CITY, employee.getCity());
        contentValues.put(EMPLOYEE_PERSONAL_EMAIL, employee.getPersonalEmail());
        contentValues.put(EMPLOYEE_PHONE_NO, employee.getPhoneNo());
        contentValues.put(EMPLOYEE_JOP_TITLE, employee.getJobTitle());
        contentValues.put(EMPLOYEE_PASSWORD, employee.getPassword());

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

        contentValues.put(SUBJECT_ID, subject.getSubjectId());
        contentValues.put(SUBJECT_NAME, subject.getSubjectName());
        contentValues.put(SUBJECT_GENDER, subject.getGender());
        contentValues.put(SUBJECT_DIVISION, subject.getDivision());
        contentValues.put(SUBJECT_FINALEXAM_DATE, subject.getFinalExamDate());
        contentValues.put(SUBJECT_PLACE_TIME, subject.getPlaceTimeLecture());
        contentValues.put(SUBJECT_COLLEGE, subject.getCollage());
        contentValues.put(SUBJECT_DEPARTMENT, subject.getDepartment());

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


    public List<Employee> getLastEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TB_EMPLOYEE, null);

        if (cursor.moveToFirst()) {
            do {
                String college_email = cursor.getString(cursor.getColumnIndex(EMPLOYEE_COLLEGE_EMAIL));
                String name = cursor.getString(cursor.getColumnIndex(EMPLOYEE_NAME));
                String employee_college_id = cursor.getString(cursor.getColumnIndex(EMPLOYEE_COLLEGE_ID));
                String department_id = cursor.getString(cursor.getColumnIndex(EMPLOYEE_DEPARTMENT_ID));
                String specialize = cursor.getString(cursor.getColumnIndex(EMPLOYEE_SPECIALIZE));
                String img = cursor.getString(cursor.getColumnIndex(EMPLOYEE_IMG));
                String city = cursor.getString(cursor.getColumnIndex(EMPLOYEE_CITY));
                String personal_email = cursor.getString(cursor.getColumnIndex(EMPLOYEE_PERSONAL_EMAIL));
                String phone = cursor.getString(cursor.getColumnIndex(EMPLOYEE_PHONE_NO));
                String jop_title = cursor.getString(cursor.getColumnIndex(EMPLOYEE_JOP_TITLE));
                String departmentName = cursor.getString(cursor.getColumnIndex(EMPLOYEE_COLLAGE_NAME));
                String collageName = cursor.getString(cursor.getColumnIndex(EMPLOYEE_DEPARTMENT_NAME));

                Employee employee = new Employee(college_email, name, employee_college_id, department_id, specialize,
                        img, city, personal_email, phone, jop_title);
                employee.setCollageName(collageName);
                employee.setDepartmentName(departmentName);
                employees.add(employee);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return employees;
    }


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

    public StudentInfo getStudentByName(String name) {
        StudentInfo studentInfo = new StudentInfo();
        SQLiteDatabase db = getReadableDatabase();
        String[] arg = {name};
        Cursor cursor = db.rawQuery("select * from " + TB_STUDENT + " where " + STUDENT_NAME + " = ?", arg);

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

    public List<StudentInfo> getStudentsByDepartment(String department) {
        ArrayList<StudentInfo> infoArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] arg = {department};
        Cursor cursor = db.rawQuery("select * from " + TB_STUDENT + " where " + STUDENT_DEPARTMENT + " = ?", arg);

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

    public List<Subject> getSubject() {
        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from " + TB_SUBJECT, null);
        if (cursor.moveToFirst()) {
            do {
                String subject_id = cursor.getString(cursor.getColumnIndex(SUBJECT_ID));
                String subject_name = cursor.getString(cursor.getColumnIndex(SUBJECT_NAME));
                String subject_gender = cursor.getString(cursor.getColumnIndex(SUBJECT_GENDER));
                String subject_division = cursor.getString(cursor.getColumnIndex(SUBJECT_DIVISION));
                String subject_final_exam = cursor.getString(cursor.getColumnIndex(SUBJECT_FINALEXAM_DATE));
                String subject_place_time = cursor.getString(cursor.getColumnIndex(SUBJECT_PLACE_TIME));
                String subject_college = cursor.getString(cursor.getColumnIndex(SUBJECT_COLLEGE));
                String subject_department = cursor.getString(cursor.getColumnIndex(SUBJECT_DEPARTMENT));

                Subject subject = new Subject(subject_id, subject_name, subject_gender, subject_division,
                        subject_final_exam, subject_place_time, subject_college, subject_department);
                subjectArrayList.add(subject);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return subjectArrayList;
    }


    public List<MarksDetection> getAllStudentsInSubject(List<Subject> subjectArrayList, List<StudentInfo> infoArrayList) {
        ArrayList<MarksDetection> marksDetections = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] arg = {};

//SELECT  table_student.student_name , table_student.student_id , subject_table.subject_name FROM
//    subject_register_table
//   JOIN table_student , subject_table
//    ON  subject_register_table.subject_register_student_id = table_student.student_id  and subject_register_table.subject_register_subject_id  = subject_table.subject_id ;

        Cursor cursor = db.rawQuery("select " + STUDENT_NAME + SUBJECT_NAME + " from " + TB_SUBJECT_REGISTER + " where "
                + SUB_REGISTER_SUBJECT_ID + " =? and " + SUB_REGISTER_DIVISION + " =? ", arg);

        if (cursor.moveToFirst()) {
            do {
                int studentId = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
//                marksDetections.add(marksDetections);

            } while (cursor.moveToNext());
            cursor.close();
        }
        return marksDetections;
    }
}
