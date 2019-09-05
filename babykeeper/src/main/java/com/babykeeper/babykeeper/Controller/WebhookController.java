package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.ContactSession;
import com.babykeeper.babykeeper.model.ContactPerson;
import com.babykeeper.babykeeper.twilio;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class WebhookController {

        @RequestMapping("/call")
        @ResponseBody
        public String respondToPhoneCall(@RequestParam Map<String,String> allParams) throws JSONException {
            System.out.println("response from call, call status was: " + allParams.get("CallStatus"));
            ContactSession contactSession = ContactSession.getInstance();
            if(!allParams.get("CallStatus").equals("completed"))
            {
                int index = contactSession.getIndex();
                if(contactSession.getContactMap().size() > index) {
                    ContactPerson contactPerson = contactSession.getContactMap().get(index);
                    System.out.println("Calling to index num: " + index + "To contact: " +contactPerson.getFirstName() + "with number: " + contactPerson.getPhoneNum());
                    twilio.callUser(contactPerson.getPhoneNum());
                    contactSession.setIndex(index + 1);
                }
            }
            System.out.println(allParams);
            return "Welcome to Spring Boot";
        }

}
