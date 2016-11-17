package com.example.mdkamrul.expensemanager.Database;

import static android.transition.Fade.IN;

/**
 * Created by mdkamrul on 13-Nov-16.
 */

public class TableAttributes {

    public static final String STUDENT_TABLE_NAME = "Student";
    public static final String STUDENT_NAME = "name";
    public static final String STUDENT_PASSWORD = "password";
    public static final String STUDENT_PHONENO = "phoneNo";
    public static final String STUDENT_AGE = "age";

    public String studentTableCreateQuery(){
        return "CREATE TABLE "+STUDENT_TABLE_NAME+"(student_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                STUDENT_NAME+" TEXT," +
                STUDENT_PASSWORD+" TEXT," +
                STUDENT_PHONENO+" TEXT," +
                STUDENT_AGE+" INTEGER)";
    }
}
