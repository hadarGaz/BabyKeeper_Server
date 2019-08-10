package com.babykeeper.babykeeper.model;

public class User {
    private String fname;
    private String lname;
    private String email;
    private String pass;
    private String userId;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public User(String fname, String lname, String pass, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pass = pass;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
