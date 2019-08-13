package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.model.ContactPerson;
import com.babykeeper.babykeeper.model.ResponsObj;
import com.babykeeper.babykeeper.model.SettingInfo;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SettingController {
    SettingInfo settingInfo;

    @RequestMapping("/getUserSettingInfo")
    public SettingInfo getSettingInfo(@RequestParam("userid") String UserDetails) throws Exception {

        //need to bring all the data from the DB
        return new SettingInfo("moshe","levi","0545567382");
    }
    @RequestMapping("/getContactsInfo")
    public List<ContactPerson> getContact(@RequestParam("userid") String UserDetails) throws Exception {

        //need to bring all the data from the DB
        List<ContactPerson> contactMap = new ArrayList<>();
        contactMap.add(new ContactPerson("yoram","levi","0543342617"));
        contactMap.add(new ContactPerson("pol","moshe","0543342699"));
        return contactMap;
    }

    @RequestMapping("/submitSetting")
    public ResponsObj submitSetting(@RequestBody  String UserDetails) throws Exception {

        JSONObject obj = new JSONObject(UserDetails);
        String userId = (obj.getString("userid"));
        settingInfo.setFname(obj.getString("FirstName"));
        settingInfo.setLname(obj.getString("LastName"));
        settingInfo.setPhoneNumber(obj.getString("phoneNumber"));

        //need to save all the data from the DB and get info from the DB
        ResponsObj responsObj = new ResponsObj(true,"",userId);
        responsObj.setSettingInfo(settingInfo);
        return responsObj;
    }
}
