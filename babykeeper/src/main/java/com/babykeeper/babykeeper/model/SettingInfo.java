package com.babykeeper.babykeeper.model;

import java.util.Map;

public class SettingInfo {
    private String Fname;
    private String Lname;
    private String phoneNumber;
    private Map<String,String> contactMap;

    public SettingInfo(String fname, String lname, String phoneNumber, Map<String, String> contactMap) {
        Fname = fname;
        Lname = lname;
        this.phoneNumber = phoneNumber;
        this.contactMap = contactMap;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getContactMap() {
        return contactMap;
    }

    public void setContactMap(Map<String, String> contactMap) {
        this.contactMap = contactMap;
    }
}
