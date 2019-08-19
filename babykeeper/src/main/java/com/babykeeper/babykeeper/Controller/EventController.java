package com.babykeeper.babykeeper.Controller;

import com.babykeeper.babykeeper.model.SimulationResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
public class EventController {

    @RequestMapping("/startSimulation")
    public SimulationResponse startSimulation(@RequestParam("simulationID") String simulationID) throws Exception {
        int simulationIDInt = Integer.parseInt(simulationID);
        SimulationResponse simulationResponse = null;
        String imageUrl = null;
        switch (simulationIDInt)
        {
            case 0:
                simulationResponse =  new SimulationResponse(false,"https://firebasestorage.googleapis.com/v0/b/babykeeper-b1ae8.appspot.com/o/noChildren.jpg?alt=media&token=f0b3db58-89b7-4a45-96b2-1e575ee612de");
            break;
            case 1:
                simulationResponse =  new SimulationResponse(true,"https://firebasestorage.googleapis.com/v0/b/babykeeper-b1ae8.appspot.com/o/oneChildren.jpg?alt=media&token=a2c6b310-531f-45fa-bf86-b830aac3a38e");
                break;
            case 2:
                simulationResponse =  new SimulationResponse(true,"https://firebasestorage.googleapis.com/v0/b/babykeeper-b1ae8.appspot.com/o/children.jpg?alt=media&token=667d6ab8-5e30-4ad6-abee-03e873451bda");
            break;

        }
        return simulationResponse;

//        if(isThereChildrenInTheCar(imageUrl))
//            return new SimulationResponse(true,"https://firebasestorage.googleapis.com/v0/b/babykeeper-b1ae8.appspot.com/o/children.jpg?alt=media&token=667d6ab8-5e30-4ad6-abee-03e873451bda");
//        else
//            return new SimulationResponse(false,"");

    }

    private boolean isThereChildrenInTheCar(String imageUrl)
    {

        String yolopy = "/Users/hgaziel/Documents/FinalProject/BabyKeeper_Server/babykeeper/src/main/java/com/babykeeper/babykeeper/yolo-coco/yolo.py";
        //String image = " /Users/hgaziel/Documents/FinalProject/BabyKeeper_Server/babykeeper/src/main/java/com/babykeeper/babykeeper/yolo-coco/Children.jpg";
        String image = "https://firebasestorage.googleapis.com/v0/b/babykeeper-b1ae8.appspot.com/o/children.jpg?alt=media&token=667d6ab8-5e30-4ad6-abee-03e873451bda";
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
