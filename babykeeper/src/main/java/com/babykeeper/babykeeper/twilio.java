package com.babykeeper.babykeeper;

// Install the Java helper library from twilio.com/docs/libraries/java
import java.net.URI;

import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

public class twilio {
    public static final String ACCOUNT_SID = "ACc0c1ecbdb86d66ce6100c6b753806fb3";
    public static final String AUTH_TOKEN = "5a427e2aa69d0e418ff73b562509c872";

    public static void callUser(String callTo)
   {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

       callTo = "+972" + callTo.substring(1);

        String from = "+97293741446";
       System.out.println("Calling to: " + callTo);

        Call call = Call.creator(
                new PhoneNumber(callTo),
                new PhoneNumber(from),
                URI.create("https://handler.twilio.com/twiml/EH9ba4f0c1297fad4c37ffade149560760"))
                .setMethod(HttpMethod.GET)
                .setStatusCallback(URI.create("http://b73b6c75.ngrok.io/call"))
                .setStatusCallbackEvent("completed")
                .setStatusCallbackMethod(HttpMethod.POST)
                .create();
//
        System.out.println(call.getSid());
    }
}
