package com.example.mdkamrul.expensemanager.Database;

import static android.transition.Fade.IN;

/**
 * Created by mdkamrul on 13-Nov-16.
 */

public class TableAttributes {
    public static final String STUDENTTABLENAME = "Student";
    public static final String USERNAME = "name";
    public static final String PASSWORD = "password";


    public String studentTableCreateQuery(){
        return "CREATE TABLE "+STUDENTTABLENAME+"(student_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                USERNAME+" TEXT," +
                PASSWORD+" TEXT)";
    }
}