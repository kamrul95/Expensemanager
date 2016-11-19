package com.example.mdkamrul.expensemanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mdkamrul.expensemanager.Database.DatabaseHelper;
import com.example.mdkamrul.expensemanager.Model.Registration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    Button buttonAddExpense,buttonAddIncome,buttonExpenseDetailes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAddExpense = (Button) findViewById(R.id.buttonAddExpense);
        buttonAddIncome = (Button)findViewById(R.id.buttonAddIncome);
        buttonExpenseDetailes = (Button)findViewById(R.id.buttonExpenseDetails);

        buttonAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ExpenseActivity.class);
                startActivity(intent);
            }
        });

        buttonExpenseDetailes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ExpenseDetails.class);
                startActivity(intent);
            }
        });
    }

}
