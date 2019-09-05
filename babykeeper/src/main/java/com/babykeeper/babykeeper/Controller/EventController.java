package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.ContactSession;
import com.babykeeper.babykeeper.UsersManager;
import com.babykeeper.babykeeper.model.SimulationResponse;
import com.babykeeper.babykeeper.model.User;
import com.babykeeper.babykeeper.twilio;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

@RestController
public class EventController {

    @Autowired
    UsersManager usersManager;

    @RequestMapping("/uploadImg")
    public SimulationResponse uploadImg(@RequestBody String UserDetails) throws Exception {

        System.out.println("Start uploadImg call");
        JSONObject obj = new JSONObject(UserDetails);
        String image = (obj.getString("img"));
        String userId = (obj.getString("userId"));

        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(image);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));

        // write the image to a file
        File outputfile = new File("imageFromUI.png");
        ImageIO.write(img, "png", outputfile);

        //for hadar
        boolean res =  isThereChildrenInTheCar();

        //for nofar
//        boolean res = true;

        if(res)
        {
            User user = usersManager.getUser(userId);
            ContactSession contactSession = ContactSession.getInstance();
            contactSession.setContactMap(user.getContactPersonList());
            twilio.callUser(user.getPhoneNumber());
        }

        return new SimulationResponse(res);
    }

    private boolean isThereChildrenInTheCar()
    {

        String yolopy = "/Users/hgaziel/Documents/FinalProject/BabyKeeper_Server/babykeeper/src/main/java/com/babykeeper/babykeeper/yolo-coco/yolo.py";
        String image = "/Users/hgaziel/Documents/FinalProject/BabyKeeper_Server/babykeeper/imageFromUI.png";
        String yolococo = "/Users/hgaziel/Documents/FinalProject/BabyKeeper_Server/babykeeper/src/main/java/com/babykeeper/babykeeper/yolo-coco";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("python3.7 "+ yolopy + " --image "+image +" --yolo " + yolococo);

        } catch (Exception e) {
            System.out.println("Exception Raised" + e.toString());
        }
        InputStream stdout = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout, StandardCharsets.UTF_8));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println("There are : " + line + " children in the car");
                int result = Integer.parseInt(line);
                if(result > 0)
                    return true;

            }
        } catch (IOException e) {
            System.out.println("Exception in reading output" + e.toString());
        }
        return false;
    }
}
