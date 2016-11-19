package com.example.mdkamrul.expensemanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.mdkamrul.expensemanager.MainActivity;
import com.example.mdkamrul.expensemanager.Model.Registration;

import java.util.ArrayList;

/**
 * Created by mdkamrul on 13-Nov-16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public  static final String DB_NAME="studentdb.db";
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TableAttributes tableAttributes = new TableAttributes();
        String query = tableAttributes.studentTableCreateQuery();
        try {
            db.execSQL(query);
            Log.i("Create ","Table Created");
        }catch (SQLiteException e){
            Log.i("Create Error ",e.toString());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertStudent(Registration studentObject) {
        SQLiteDatabase dbInsert = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableAttributes.USERNAME,studentObject.getUserName());
        values.put(TableAttributes.PASSWORD,studentObject.getPassword());
        values.put(TableAttributes.EXPENSEDATE,studentObject.getExpenseDate());
        //Toast.makeText(MainActivity.this,studentObject.getExpenseDate(),Toast.LENGTH_SHORT).show();
        try {
            dbInsert.insert(TableAttributes.STUDENTTABLENAME, null, values);
            Log.i("Create: ", "Table Created");
        }catch (SQLiteException e){
            Log.i("Create Error: ",e.toString());
        }

    }

    public ArrayList<Registration> getAllStudents() {
        SQLiteDatabase fetchStudent = this.getReadableDatabase();
        ArrayList<Registration> arrayListAllStudent = new ArrayList<Registration>();
        String query = "SELECT * FROM " + TableAttributes.STUDENTTABLENAME;
        Cursor cursor= fetchStudent.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Registration studentObject = new Registration();
            studentObject.setUserName(cursor.getString(cursor.getColumnIndex(TableAttributes.USERNAME)));
            studentObject.setPassword(cursor.getString(cursor.getColumnIndex(TableAttributes.PASSWORD)));
            studentObject.setExpenseDate(cursor.getString(cursor.getColumnIndex(TableAttributes.EXPENSEDATE)));
            arrayListAllStudent.add(studentObject);
            cursor.moveToNext();
        }
        return arrayListAllStudent;
    }
}
