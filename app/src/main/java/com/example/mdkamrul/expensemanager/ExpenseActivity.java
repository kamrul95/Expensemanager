package com.example.mdkamrul.expensemanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mdkamrul.expensemanager.Database.DatabaseHelper;
import com.example.mdkamrul.expensemanager.Model.Registration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ExpenseActivity extends AppCompatActivity {
    EditText eTUserName, eTPassword;
    Button saveBtn;
    boolean error;
    ListView listView;
    ArrayList<Registration> arrayListStd;
    ArrayAdapter<Registration> adapter;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        eTUserName = (EditText) findViewById(R.id.editTextUsername);
        eTPassword = (EditText) findViewById(R.id.editTextPassword);
        saveBtn = (Button) findViewById(R.id.buttonSave);
        listView = (ListView) findViewById(R.id.listViewResult);

        db = new DatabaseHelper(ExpenseActivity.this);
        //arrayListStd = db.getAllStudents();
        //adapter = new ArrayAdapter<Registration>(ExpenseActivity.this, android.R.layout.simple_list_item_1, arrayListStd);
        //listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ExpenseActivity.this);
                dialog.setTitle("STUDENT DETAILS");
                dialog.setMessage(arrayListStd.get(position).toStringDialog());
                dialog.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error = false;
                String username = eTUserName.getText().toString();
                String password = eTPassword.getText().toString();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c.getTime());
                Toast.makeText(ExpenseActivity.this,formattedDate,Toast.LENGTH_SHORT).show();

                Registration stdObj = new Registration();
                stdObj.setUserName(username);
                stdObj.setPassword(password);
                stdObj.setExpenseDate(formattedDate);
                db.insertStudent(stdObj);
                /*
                arrayListStd = db.getAllStudents();
                adapter = new ArrayAdapter<Registration>(ExpenseActivity.this, android.R.layout.simple_list_item_1, arrayListStd);
                listView.setAdapter(adapter);
                */
                Toast.makeText(ExpenseActivity.this, "Data is saved!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ExpenseActivity.this,MainActivity.class);
                startActivity(intent);
            }

        });

    }
}
