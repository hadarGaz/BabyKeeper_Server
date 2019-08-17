package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.UsersManager;
import com.babykeeper.babykeeper.model.ContactPerson;
import com.babykeeper.babykeeper.model.ResponsObj;
import com.babykeeper.babykeeper.model.SettingInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.*;

@RestController
public class SettingController {
    SettingInfo settingInfo;

    @Autowired
    UsersManager usersManager;

    @RequestMapping("/getUserSettingInfo")
    public SettingInfo getSettingInfo(@RequestParam("userid") String UserDetails) throws Exception {

        SettingInfo settingInfo = usersManager.getSettingInfo(UserDetails);
        if(settingInfo.getPhoneNumber() == null)
            settingInfo.setPhoneNumber("");
        return settingInfo;
    }
    @RequestMapping("/getContactsInfo")
    public List<ContactPerson> getContact(@RequestParam("userid") String UserDetails) throws Exception {

      List<ContactPerson> contactPersonList =  usersManager.getUser(UserDetails).getContactPersonList();
      if(contactPersonList == null)
          return new ArrayList<ContactPerson>();
      else
        return contactPersonList;
    }

    @RequestMapping("/submitSetting")
    public ResponsObj submitSetting(@RequestBody  String UserDetails) throws Exception {

        JSONObject obj = new JSONObject(UserDetails);
        String userId = (obj.getString("userid"));
        settingInfo = new SettingInfo(obj.getString("FirstName"),obj.getString("LastName"),obj.getString("phoneNumber"));

        settingInfo.setContactMap(getContactPersonFromJson(obj));
        usersManager.updateSettingInfoById(userId,settingInfo);

        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);
        userRef.setValue(usersManager.getUser(userId), (databaseError, databaseReference) -> System.out.println("done writing to firebase"));
        Thread.sleep(5000);

        ResponsObj responsObj = new ResponsObj(true,"",userId);
        return responsObj;
    }

    private List<ContactPerson> getContactPersonFromJson(JSONObject obj) throws JSONException {
        Gson gson = new Gson();
        Type type = new TypeToken<List<ContactPerson>>(){}.getType();
        List<ContactPerson> contactList = gson.fromJson(obj.getString("contactPersons"), type);
        return contactList;
    }
}
