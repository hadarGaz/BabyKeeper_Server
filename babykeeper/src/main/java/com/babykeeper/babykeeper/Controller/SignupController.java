package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.UsersManager;
import com.babykeeper.babykeeper.model.ResponsObj;
import com.babykeeper.babykeeper.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    UsersManager usersManager;

    User user;

    @RequestMapping("/signup")
    public ResponsObj signUp(@RequestBody String UserDetails) throws Exception {
        System.out.println("Start signup call with param: " + UserDetails);

        JSONObject obj = new JSONObject(UserDetails);
        user = new User(obj.getString("Email"),obj.getString("Password"));
        user.setFname(obj.getString("FirstName"));
        user.setLname(obj.getString("LastName"));


        if (usersManager.isUserExisst(user.getEmail())) {
            return new ResponsObj(false, "Email already exists", "");
        } else {
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users").push();
            user.setUserId(userRef.getKey());
            userRef.setValue(user, (databaseError, databaseReference) -> System.out.println("done writing to firebase"));
            Thread.sleep(5000);

            usersManager.addUserToMap(user.getEmail(), user);
            return new ResponsObj(true, "", userRef.getKey());
        }
    }
}
