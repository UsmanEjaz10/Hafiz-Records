package com.usmanejaz.hafiz_records;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Android.db";
    private static final String TABLE_NAME = "Profile";
    private static final String TABLE_NAME2 = "Progress";
    private static final String COLUMN_NAME = "name";

    private static final String COLUMN_SECTION = "section";

    private static final String COLUMN_Id = "id";

    private static final String COLUMN_SURAH = "surah";

    private static final String COLUMN_MANZIL = "manzil";

    private static final String COLUMN_SABQI = "sabqi";

    private static final String COLUMN_AYATSTART = "ayatStart";

    private static final String COLUMN_AYATEND = "ayatEnd";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_NAME + " TEXT,"
                + COLUMN_Id + " INTEGER,"
                + COLUMN_SECTION + " INTEGER"
                + ")";
        db.execSQL(sql);


        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "("
                + COLUMN_Id + " INTEGER,"
                + COLUMN_SURAH + " TEXT,"
                + COLUMN_SABQI + " INTEGER,"
                + COLUMN_AYATSTART + " INTEGER,"
                + COLUMN_AYATEND + " INTEGER,"
                + COLUMN_MANZIL + " INTEGER"
                + ")";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        String sql2 = "DROP TABLE IF EXISTS " + TABLE_NAME2;
        db.execSQL(sql2);
        onCreate(db);
    }


    public void editDetails(Progress det){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_Id, det.id);
        values.put(COLUMN_SURAH, det.para_sabaq);
        values.put(COLUMN_MANZIL, det.manzil);
        values.put(COLUMN_SABQI, det.sabqi);
        values.put(COLUMN_AYATSTART, det.starting_sabaq);
        values.put(COLUMN_AYATEND, det.ending_sabaq);

        db.update(TABLE_NAME2, values, COLUMN_Id + " = ?", new String[] {String.valueOf(det.id)});
        db.close();

    }

    public void insertStudent(Profile student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.name);
        values.put(COLUMN_SECTION, student.section);
        values.put(COLUMN_Id, student.id);


        db.insert(TABLE_NAME, null, values);


        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "("
                + COLUMN_Id + " INTEGER,"
                + COLUMN_SURAH + " TEXT,"
                + COLUMN_SABQI + " INTEGER,"
                + COLUMN_AYATSTART + " INTEGER,"
                + COLUMN_AYATEND + " INTEGER,"
                + COLUMN_MANZIL + " INTEGER"
                + ")";
        db.execSQL(sql2);

        ContentValues values2 = new ContentValues();
        values2.put(COLUMN_Id, student.id);
        values2.put(COLUMN_SURAH, "");
        values2.put(COLUMN_MANZIL, 1);
        values2.put(COLUMN_SABQI, 1);
        values2.put(COLUMN_AYATSTART, 0);
        values2.put(COLUMN_AYATEND, 1);

        db.insert(TABLE_NAME2, null, values2);



        db.close();
    }

    public void updateStudent(Profile student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.name);
        values.put(COLUMN_SECTION, student.section);
        values.put(COLUMN_Id, student.id);

        db.update(TABLE_NAME, values, COLUMN_Id + " = ?", new String[] {String.valueOf(student.id)});
        db.close();
    }

    public void deleteStudent(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_Id + " = ?", new String[] {rollNo});
        db.close();
    }


    public List<Profile> selectAllStudents() {
        List<Profile> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }
        * */

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range")  int id = cursor.getInt(cursor.getColumnIndex(COLUMN_Id));
                @SuppressLint("Range")  String section = cursor.getString(cursor.getColumnIndex(COLUMN_SECTION));
                students.add(new Profile(id,name, section ));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }

    public List<Progress> selectAllProgress() {
        List<Progress> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME2;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }
        * */

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") int sabq_para = cursor.getInt(cursor.getColumnIndex(COLUMN_SURAH));
                @SuppressLint("Range")  int id = cursor.getInt(cursor.getColumnIndex(COLUMN_Id));
                @SuppressLint("Range")  int s_start = cursor.getInt(cursor.getColumnIndex(COLUMN_AYATSTART));
                @SuppressLint("Range")  int s_end = cursor.getInt(cursor.getColumnIndex(COLUMN_AYATEND));
                @SuppressLint("Range")  int sabqi = cursor.getInt(cursor.getColumnIndex(COLUMN_SABQI));
                @SuppressLint("Range")  int manzil = cursor.getInt(cursor.getColumnIndex(COLUMN_MANZIL));



                students.add(new Progress(id,s_start, s_end, sabq_para, sabqi, manzil));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }





    public Progress getDetails(int roll) {

        String sql = "SELECT * FROM " + TABLE_NAME2;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }
        * */
        Progress studentdet = null;
        if(cursor == null){
            Log.d("cursor checker", "cursor is null");
        }
        else{
            Log.d("cursor checker", "cursor is not null");
        }
        if (cursor.moveToFirst()) {
            do {


                @SuppressLint("Range")  int rollNo = cursor.getInt(cursor.getColumnIndex(COLUMN_Id));
                @SuppressLint("Range")  int surah = cursor.getInt(cursor.getColumnIndex(COLUMN_SURAH));
                @SuppressLint("Range")  int sabqi = cursor.getInt(cursor.getColumnIndex(COLUMN_SABQI));
                @SuppressLint("Range")  int manzil = cursor.getInt(cursor.getColumnIndex(COLUMN_MANZIL));
                @SuppressLint("Range")  int ayatend = cursor.getInt(cursor.getColumnIndex(COLUMN_AYATEND));
                @SuppressLint("Range")  int ayatstart = cursor.getInt(cursor.getColumnIndex(COLUMN_AYATSTART));
                if(roll == rollNo) {
                    studentdet = new Progress(rollNo, surah, sabqi, manzil, ayatstart, ayatend);
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();


        return studentdet;
    }
}
