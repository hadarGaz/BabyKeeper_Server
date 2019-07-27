package com.babykeeper.babykeeper;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    String Fname;
    String Lname;
    String email;
    String Pass;
    String greet;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestBody String UserDetails) throws Exception {
        JSONObject obj = new JSONObject(UserDetails);
        this.Fname = obj.getString("FirstName");
        this.Lname = obj.getString("LastName");
        this.Pass = obj.getString("Password");
        this.email = obj.getString("Email");
        return new Greeting(email, Lname);
    }

    @RequestMapping("/goodbye")
    public GoodBye goodbye(@RequestBody String UserDetails) throws Exception {
        JSONObject obj = new JSONObject(UserDetails);
        this.Fname = obj.getString("FirstName");
        this.Lname = obj.getString("LastName");
        this.Pass = obj.getString("Password");
        this.email = obj.getString("Email");
        return new GoodBye(Fname, Lname);
    }
}
