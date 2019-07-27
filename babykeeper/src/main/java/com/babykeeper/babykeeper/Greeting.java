package com.babykeeper.babykeeper;

public class Greeting {

    private final String Fname;
    private final String Lname;

    public Greeting(String Fname, String Lname) {
        this.Fname = Fname;
        this.Lname = Lname;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }
}