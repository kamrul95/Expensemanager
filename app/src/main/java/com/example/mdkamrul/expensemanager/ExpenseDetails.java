package com.example.mdkamrul.expensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mdkamrul.expensemanager.Database.DatabaseHelper;
import com.example.mdkamrul.expensemanager.Model.Registration;

import java.util.ArrayList;

public class ExpenseDetails extends AppCompatActivity {
    DatabaseHelper db;
    ListView listViewExpenseDetails;
    ArrayAdapter<Registration> arrayAdapterExpenseDetails;
    ArrayList<Registration> arrayListExpenseDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_details);
        listViewExpenseDetails = (ListView)findViewById(R.id.listViewExpenseDetails);
        db = new DatabaseHelper(ExpenseDetails.this);
        arrayListExpenseDetails =db.getAllStudents();
        arrayAdapterExpenseDetails= new ArrayAdapter<Registration>(ExpenseDetails.this,android.R.layout.simple_list_item_1,arrayListExpenseDetails);
        listViewExpenseDetails.setAdapter(arrayAdapterExpenseDetails);


    }
}
