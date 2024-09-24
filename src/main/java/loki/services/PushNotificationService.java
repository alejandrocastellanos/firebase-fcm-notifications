package loki.services;

import com.google.firebase.messaging.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PushNotificationService {

    public static void sendSingleNotificationToToken(String token, String title, String body)
            throws FirebaseMessagingException {
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(title.toUpperCase())
                        .setBody(body.toLowerCase())
                        .build())
                .putData("path", "home")
                .build();
        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Notificación enviada con respuesta: " + response);
    }

    public static void batchNotificationToTokens(List<String> tokens, String title, String body)
            throws FirebaseMessagingException {
        Notification notification = Notification.builder()
                .setTitle(title)
                .setBody(body.toLowerCase())
                .build();

        AndroidConfig androidConfig = AndroidConfig.builder()
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder()
                        .setChannelId("high_importance_channel")
                        .build())
                .build();

        Map<String, String> data = new HashMap<>();
        data.put("path", "home");
        MulticastMessage message = MulticastMessage.builder()
                .setNotification(notification)
                .setAndroidConfig(androidConfig)
                .putAllData(data)
                .addAllTokens(tokens)
                .build();

        BatchResponse response = FirebaseMessaging.getInstance().sendEachForMulticast(message);

        if (response.getFailureCount() > 0) {
            List<SendResponse> responses = response.getResponses();
            for (int i = 0; i < responses.size(); i++) {
                if (!responses.get(i).isSuccessful()) {
                    System.out.println("Failed to send to token: " + tokens.get(i));
                }
            }
        }
    }
}
