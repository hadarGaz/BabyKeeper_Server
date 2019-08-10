package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.model.ResponsObj;
import com.babykeeper.babykeeper.model.User;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    User user;

    @RequestMapping("/login")
    public ResponsObj login(@RequestBody String UserDetails) throws Exception {

        JSONObject obj = new JSONObject(UserDetails);
        user.setEmail(obj.getString("Email"));
        user.setPass(obj.getString("Password"));

        //need to check in the DB if this account exsist, and if yes we need to return userId to the client
        return new ResponsObj(true,"","1234");
        //return new ResponsObj(false,"user not exsits","");
    }
}
