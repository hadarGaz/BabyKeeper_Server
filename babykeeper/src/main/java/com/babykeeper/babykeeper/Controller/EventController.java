package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.model.SimulationResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
public class EventController {

    @RequestMapping("/startSimulation")
    public SimulationResponse startSimulation() throws Exception {
        if(isThereChildrenInTheCar())
            return new SimulationResponse(true,"https://firebasestorage.googleapis.com/v0/b/babykeeper-b1ae8.appspot.com/o/children.jpg?alt=media&token=667d6ab8-5e30-4ad6-abee-03e873451bda");
        else
            return new SimulationResponse(false,"");

    }

    private boolean isThereChildrenInTheCar()
    {
        String yolopy = "/Users/hgaziel/Documents/FinalProject/BabyKeeper_Server/babykeeper/src/main/java/com/babykeeper/babykeeper/yolo-coco/yolo.py";
        String image = " /Users/hgaziel/Documents/FinalProject/BabyKeeper_Server/babykeeper/src/main/java/com/babykeeper/babykeeper/yolo-coco/Children.jpg";
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
