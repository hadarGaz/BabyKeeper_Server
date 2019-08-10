package com.babykeeper.babykeeper;

import com.babykeeper.babykeeper.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class UsersManager {
    private Map<String,User> usersMap;

    public UsersManager() {
        usersMap = new HashMap<>();

        FirebaseDatabase.getInstance().getReference("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("data changed");
                Map dd = (Map)dataSnapshot.getValue();
                usersMap = dd;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("cancle");
            }
        });
    }

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    public void setUsersMap(Map<String, User> usersMap) {
        this.usersMap = usersMap;
    }

    public void addUserToMap(String email, User user)
    {
        usersMap.put(email, user);
    }

    public String getUserId(String email)
    {
        for(Object key : usersMap.values())
        {
            if(((HashMap)key).get("email").equals(email))
                return (String)((HashMap)key).get("userId");
        }
        return null;
    }

    public boolean isUserExisst(String email)
    {
        for(Object key : usersMap.values())
        {
            if(((HashMap)key).get("email").equals(email))
                return true;
        }
        return false;
    }
    public boolean isPassCorrect(String email, String pass)
    {
        for(Object key : usersMap.values())
        {
            if(((HashMap)key).get("email").equals(email)) {
                if(((HashMap)key).get("pass").equals(pass))
                    return true;
            }
        }
        return false;
    }
}
