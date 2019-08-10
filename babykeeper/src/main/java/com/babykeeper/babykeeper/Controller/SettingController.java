package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.model.ResponsObj;
import com.babykeeper.babykeeper.model.SettingInfo;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SettingController {
    SettingInfo settingInfo;

    @RequestMapping("/getSettingInfo")
    public SettingInfo getSettingInfo(@RequestBody String UserDetails) throws Exception {

        JSONObject obj = new JSONObject(UserDetails);
        String userId = (obj.getString("user-id"));

        //need to bring all the data from the DB
        Map<String,String> contactMap = new HashMap<>();
        contactMap.put("yoram","0543342617");
        contactMap.put("pol","0543342699");
        return new SettingInfo("moshe","levi","0545567382",contactMap);
    }

    @RequestMapping("/submitSetting")
    public ResponsObj submitSetting(@RequestBody String UserDetails) throws Exception {

        JSONObject obj = new JSONObject(UserDetails);
        String userId = (obj.getString("user-id"));
        settingInfo.setFname(obj.getString("FirstName"));
        settingInfo.setLname(obj.getString("LastName"));
        settingInfo.setPhoneNumber(obj.getString("phoneNumber"));

        //need to save all the data from the DB and get info from the DB
        ResponsObj responsObj = new ResponsObj(true,"",userId);
        responsObj.setSettingInfo(settingInfo);
        return responsObj;
    }
}
