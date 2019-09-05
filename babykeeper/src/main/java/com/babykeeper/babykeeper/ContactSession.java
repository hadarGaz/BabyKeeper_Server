package com.babykeeper.babykeeper;

import com.babykeeper.babykeeper.model.ContactPerson;

import java.util.ArrayList;
import java.util.List;

public class ContactSession {
    private List<ContactPerson> contactMap;
    private int index = 0;

    private ContactSession() {
        this.contactMap = new ArrayList<>();
    }

    // static variable single_instance of type Singleton
    private static ContactSession single_instance = null;


    // static method to create instance of Singleton class
    public static ContactSession getInstance()
    {
        if (single_instance == null)
            single_instance = new ContactSession();

        return single_instance;
    }


    public List<ContactPerson> getContactMap() {
        return contactMap;
    }

    public void setContactMap(List<ContactPerson> contactMap) {
        this.contactMap = contactMap;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
