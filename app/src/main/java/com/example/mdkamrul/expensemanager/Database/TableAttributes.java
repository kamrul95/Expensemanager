package com.example.mdkamrul.expensemanager.Database;

import static android.provider.Telephony.Carriers.PASSWORD;
import static android.transition.Fade.IN;

/**
 * Created by mdkamrul on 13-Nov-16.
 */

public class TableAttributes {
    public static final String ADDEXPENSETABLENAME = "AddExpense";
    public static final String EXPENSETYPE = "type";
    public static final String COST = "cost";
    public static final String EXPENSEDATE="expenseDate";

    public String studentTableCreateQuery(){
        return "CREATE TABLE "+ADDEXPENSETABLENAME+"(student_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                EXPENSETYPE+" TEXT," +
                COST+" Double,"+
                EXPENSEDATE+" TEXT)";
    }
}