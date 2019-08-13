package com.babykeeper.babykeeper.model;

import java.util.List;
import java.util.Map;

public class SettingInfo {
    private String Fname;
    private String Lname;
    private String phoneNumber;
    private List<ContactPerson> contactMap;

    public SettingInfo(String fname, String lname, String phoneNumber) {
        Fname = fname;
        Lname = lname;
        this.phoneNumber = phoneNumber;
        //this.contactMap = contactMap;
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

    public List<ContactPerson> getContactMap() {
        return contactMap;
    }

    public void setContactMap(List<ContactPerson> contactMap) {
        this.contactMap = contactMap;
    }
}
