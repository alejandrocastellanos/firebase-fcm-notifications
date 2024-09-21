package loki.controllers;

import com.google.firebase.messaging.*;
import loki.config.FirebaseInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static loki.services.PushNotificationService.sendSingleNotificationToToken;

@RestController
public class PushNotificationRestController {
    @GetMapping({"/single-push-notification/{token}"})
    public String singlePushNotification(@PathVariable String token){
        try {
            FirebaseInitializer.initialize();
            sendSingleNotificationToToken(token);
        } catch (FirebaseMessagingException | IOException e) {
            e.printStackTrace();
        }
        return "Process Completed";
    }
}
