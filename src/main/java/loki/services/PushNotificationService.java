package loki.services;

import com.google.firebase.messaging.*;


public class PushNotificationService {

    public static void sendSingleNotificationToToken(String token) throws FirebaseMessagingException {
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle("Titulo de la notificación")
                        .setBody("Detalle de la notificación")
                        .build())
                .putData("path", "home")
                .build();
        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Notificación enviada con respuesta: " + response);
    }
}
