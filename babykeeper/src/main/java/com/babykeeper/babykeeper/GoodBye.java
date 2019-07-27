package com.babykeeper.babykeeper;

public class GoodBye {
    private final String Fname;
    private final String Lname;

    public GoodBye(String Fname, String Lname) {
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
