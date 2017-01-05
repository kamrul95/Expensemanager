package com.example.mdkamrul.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


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
