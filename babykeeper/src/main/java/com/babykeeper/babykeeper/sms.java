package com.babykeeper.babykeeper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sms {
    public static void sendSMS(String number){

        number = number.substring(1);
        try {
            // Construct data
            String apiKey = "apikey=" + "7C2DXDGNZ3I-BLZqQhObILNgPXy4fXPhBslXgoEriv\t";
            String message = "&message=" + "Attention! Baby is IN the Car!!!";
            String sender = "&sender=" + "BabyKeeper";
            String numbers = "&numbers=" + "+972545540231";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            System.out.println(stringBuffer.toString());
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            System.out.println( "Error "+e);
        }
    }
}
