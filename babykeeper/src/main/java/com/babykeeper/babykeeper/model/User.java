package com.babykeeper.babykeeper.model;

public class User {
    private String Fname;
    private String Lname;
    private String email;
    private String Pass;

    public User(String email, String pass) {
        this.email = email;
        Pass = pass;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
