package com.example.mdkamrul.expensemanager;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdkamrul.expensemanager.Database.DatabaseHelper;
import com.example.mdkamrul.expensemanager.Model.Registration;

import java.util.ArrayList;



import static com.example.mdkamrul.expensemanager.R.id.editTextPassword;


public class MainActivity extends AppCompatActivity {
    EditText eTUserName, eTPassword, eTPhone, eTAge;
    Button saveBtn;
    boolean error;
    ListView listView;
    ArrayList<Registration> arrayListStd;
    ArrayAdapter<Registration> adapter;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTUserName = (EditText) findViewById(R.id.editTextUsername);
        eTPassword = (EditText) findViewById(R.id.editTextPassword);
        eTPhone = (EditText) findViewById(R.id.editTextPhoneNumber);
        eTAge = (EditText) findViewById(R.id.editTextAge);
        saveBtn = (Button) findViewById(R.id.buttonSave);
        listView = (ListView) findViewById(R.id.listViewResult);

        db = new DatabaseHelper(MainActivity.this);
        arrayListStd = db.getAllStudents();
        adapter = new ArrayAdapter<Registration>(MainActivity.this, android.R.layout.simple_list_item_1, arrayListStd);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
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
                String phone = eTPhone.getText().toString();
                String password = eTPassword.getText().toString();
                int age = Integer.parseInt(eTAge.getText().toString());

                if (username.trim().equals("")) {
                    error = true;
                    eTUserName.setError("Username is missing!");
                }
                if (username.trim().length()<4) {
                    error = true;
                    eTUserName.setError("Username is too Short!");
                }
                if (age < 16) {
                    error = true;
                    eTAge.setError("Age should be more than 15");
                }

                if (error == false) {
                    /*String data = "Name: " + username + "\nPassword: " + password + "\nPhone: " + phone + "\nAge: " + age;
                    arrayListStd.add(data);*/
                    Registration stdObj = new Registration();
                    stdObj.setUsername(username);
                    stdObj.setPassword(password);
                    stdObj.setPhoneNo(phone);
                    stdObj.setAge(age);
                    db.insertStudent(stdObj);
                    arrayListStd = db.getAllStudents();
                    adapter = new ArrayAdapter<Registration>(MainActivity.this, android.R.layout.simple_list_item_1, arrayListStd);
                    listView.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Data is saved!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data is not saved!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}