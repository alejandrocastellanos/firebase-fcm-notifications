package loki.controllers;

import com.google.firebase.messaging.*;
import loki.config.FirebaseInitializer;
import loki.domain.TokensRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static loki.services.PushNotificationService.batchNotificationToTokens;
import static loki.services.PushNotificationService.sendSingleNotificationToToken;

@RestController
public class PushNotificationRestController {
    @PostMapping({"/single-push-notification"})
    public String singlePushNotification(@RequestBody TokensRequest tokens){
        try {
            FirebaseInitializer.initialize();
            sendSingleNotificationToToken( tokens.getToken(), tokens.getTitle(), tokens.getBody());
        } catch (FirebaseMessagingException | IOException e) {
            e.printStackTrace();
            return "Error Notification Token";
        }
        return "Process Completed";
    }

    @PostMapping({"/batch-push-notifications"})
    public String batchPushNotifications(@RequestBody TokensRequest tokens){
        List<String> newTokens = new ArrayList<>(Arrays.asList(tokens.getTokens()));
        try {
            FirebaseInitializer.initialize();
            batchNotificationToTokens(newTokens, tokens.getTitle(), tokens.getBody());
        } catch (FirebaseMessagingException | IOException e) {
            e.printStackTrace();
            return "Error Notification Token";
        }
        return "Process Completed";
    }
}
