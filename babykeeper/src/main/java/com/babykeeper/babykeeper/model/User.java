package com.babykeeper.babykeeper.model;

import java.util.List;

public class User {
    private String fname;
    private String lname;
    private String email;
    private String pass;
    private String userId;
    private String phoneNumber;
    private List<ContactPerson> contactPersonList;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public User(String fname, String lname, String email, String pass, String userId) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pass = pass;
        this.userId = userId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ContactPerson> getContactPersonList() {
        return contactPersonList;
    }

    public void setContactPersonList(List<ContactPerson> contactPersonList) {
        this.contactPersonList = contactPersonList;
    }
}
