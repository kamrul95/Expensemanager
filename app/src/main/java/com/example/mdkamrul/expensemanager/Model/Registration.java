package com.example.mdkamrul.expensemanager.Model;

import static android.R.attr.password;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by mdkamrul on 12-Nov-16.
 */

public class Registration {
    private String type;
    private  Double cost;
    private  String expenseDate;
    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                "Type: " + type + "\n" +
                        "Cost= " + cost + "\n"+"Expense Date: " + expenseDate;
    }
    public String toStringDialog(){
        return  "Type: " + type + "\n" +
                "Cost: " + cost + "\n";
    }
}
