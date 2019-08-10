package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.UsersManager;
import com.babykeeper.babykeeper.model.ResponsObj;
import com.babykeeper.babykeeper.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UsersManager usersManager;
    User user;

    @RequestMapping("/login")
    public ResponsObj login(@RequestBody String UserDetails) throws Exception {

        JSONObject obj = new JSONObject(UserDetails);
        user = new User(obj.getString("Email"),obj.getString("Password"));

        if (usersManager.isUserExisst(user.getEmail())) {
            if(usersManager.isPassCorrect(user.getEmail(),user.getPass()))
            {
                return new ResponsObj(true,"",usersManager.getUserId(user.getEmail()));
            }
            else
            {
                return new ResponsObj(false,"Wrong password","");
            }
        }
        else
        {
            return new ResponsObj(false,"User doesn't exists","");
        }
    }
}
