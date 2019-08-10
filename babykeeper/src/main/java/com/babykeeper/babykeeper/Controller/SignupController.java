package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.model.ResponsObj;
import com.babykeeper.babykeeper.model.User;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public class SignupController {

    User user;

    @RequestMapping("/signup")
    public ResponsObj ResponsObj(@RequestBody String UserDetails) throws Exception {
        JSONObject obj = new JSONObject(UserDetails);
        user.setFname(obj.getString("FirstName"));
        user.setLname(obj.getString("LastName"));
        user.setEmail(obj.getString("Email"));
        user.setPass(obj.getString("Password"));

        //need to to save account in the DB and return to the client the user id
        return new ResponsObj(true,"","1234");
        //return new ResponsObj(false,"invalid email","");
    }
}
