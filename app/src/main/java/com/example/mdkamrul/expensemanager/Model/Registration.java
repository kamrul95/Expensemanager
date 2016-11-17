package com.example.mdkamrul.expensemanager.Model;

/**
 * Created by mdkamrul on 12-Nov-16.
 */

public class Registration {
    private String username;
    private String password;
    private String phoneNo;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "Username: " + username + "\n" +
                        "PhoneNo='" + phoneNo + "\n";
    }

    public String toStringDialog(){
        return  "Username: " + username + "\n" +
                "Password: " + password + "\n" +
                "PhoneNo='" + phoneNo + "\n" +
                "Age=" + age;
    }
}
