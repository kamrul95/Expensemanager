package com.example.mdkamrul.expensemanager.Model;

/**
 * Created by mdkamrul on 12-Nov-16.
 */

public class Registration {
    private String userName;
    private  String password;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "Username: " + userName + "\n" +
                        "Password= " + password + "\n";
    }
    public String toStringDialog(){
        return  "Username: " + userName + "\n" +
                "Password: " + password + "\n";
    }
}
