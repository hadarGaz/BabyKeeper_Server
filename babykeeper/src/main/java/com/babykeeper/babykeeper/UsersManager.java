package com.babykeeper.babykeeper;

import com.babykeeper.babykeeper.model.SettingInfo;
import com.babykeeper.babykeeper.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UsersManager {
    private Map<String,User> usersMap;

    public UsersManager() {
        usersMap = new HashMap<String,User>();

        FirebaseDatabase.getInstance().getReference("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("data changed");
                Map snapshotValueMap = (Map)dataSnapshot.getValue();
                Gson gson = new Gson();
                JsonElement jsonElement;
                for(Object obj : snapshotValueMap.values())
                {
                    jsonElement = gson.toJsonTree(obj);
                    User user = gson.fromJson(jsonElement, User.class);
                    usersMap.put(user.getEmail(),user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("cancle");
            }
        });
    }

    public void addUserToMap(String email, User user)
    {
        usersMap.put(email, user);
    }

    public String getUserId(String email)
    {
        return usersMap.get(email).getUserId();
    }

    public boolean isUserExisst(String email)
    {
        return usersMap.containsKey(email);
    }
    public boolean isPassCorrect(String email, String pass)
    {
        return usersMap.get(email).getPass().equals(pass);
    }

    public User getUser(String userid)
    {
        for(Object key : usersMap.values())
        {
            User user = (User)key;
            if(user.getUserId().equals(userid))
                return user;
        }
        return null;
    }

    public void updateSettingInfoById(String userid, SettingInfo settingInfo)
    {
        for(Object key : usersMap.values())
        {
            User user = (User)key;
            if((user.getUserId().equals(userid)))
            {
                user.setPhoneNumber(settingInfo.getPhoneNumber());
                user.setContactPersonList(settingInfo.getContactMap());
                user.setFname(settingInfo.getFname());
                user.setLname(settingInfo.getLname());
                break;
            }
        }
    }
    public SettingInfo getSettingInfo(String userid)
    {
        User user = this.getUser(userid);
        SettingInfo settingInfo = new SettingInfo(user.getFname(),user.getLname(),user.getPhoneNumber());
        return settingInfo;
    }
}
