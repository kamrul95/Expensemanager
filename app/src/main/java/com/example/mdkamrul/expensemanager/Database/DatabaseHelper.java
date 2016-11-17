package com.example.mdkamrul.expensemanager.Database;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.mdkamrul.expensemanager.MainActivity;
import com.example.mdkamrul.expensemanager.Model.Registration;
import com.example.mdkamrul.expensemanager.R;

import java.util.ArrayList;

import static android.R.attr.version;

/**
 * Created by mdkamrul on 13-Nov-16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "studentdb.db";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TableAttributes tableAttr = new TableAttributes();
        String query = tableAttr.studentTableCreateQuery();
        try {
            db.execSQL(query);
            Log.i("Create", "Hoise");
        } catch (SQLException e) {
            Log.e("Create Error", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertStudent(Registration stdObj) {

        SQLiteDatabase dbInsert = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableAttributes.STUDENT_NAME, stdObj.getUsername());
        values.put(TableAttributes.STUDENT_PASSWORD, stdObj.getPassword());
        values.put(TableAttributes.STUDENT_PHONENO, stdObj.getPhoneNo());
        values.put(TableAttributes.STUDENT_AGE, stdObj.getAge());
        try {
            dbInsert.insert(TableAttributes.STUDENT_TABLE_NAME, null, values);
            Log.i("Data", values.toString());
        } catch (SQLException e) {
            Log.e("Insert Error", e.toString());
        }
    }

    public ArrayList<Registration> getAllStudents() {
        ArrayList<Registration> arrayList = new ArrayList<Registration>();
        SQLiteDatabase dbFetch = this.getReadableDatabase();
        String query = "SELECT * FROM " + TableAttributes.STUDENT_TABLE_NAME;
        Cursor cur = dbFetch.rawQuery(query, null);
        cur.moveToFirst();
        while(!cur.isAfterLast()){
            Registration stdObj = new Registration();
            stdObj.setUsername(cur.getString(cur.getColumnIndex(TableAttributes.STUDENT_NAME)));
            stdObj.setPassword(cur.getString(cur.getColumnIndex(TableAttributes.STUDENT_PASSWORD)));
            stdObj.setPhoneNo(cur.getString(cur.getColumnIndex(TableAttributes.STUDENT_PHONENO)));
            stdObj.setAge(cur.getInt(cur.getColumnIndex(TableAttributes.STUDENT_AGE)));

            arrayList.add(stdObj);
            cur.moveToNext();
        }
        return arrayList;
    }
}
