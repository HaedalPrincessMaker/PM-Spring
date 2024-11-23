package PrincessMaker.PM_Spring.service;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {

    public String sendNotification(String token, String title, String body) {
        try {
            // 알림 메시지 생성
            Notification notification = Notification.builder()
                    .setTitle(title)
                    .setBody(body)
                    .build();

            // 메시지 빌더 설정
            Message message = Message.builder()
                    .setToken(token) // FCM 토큰
                    .setNotification(notification)
                    .build();

            // FirebaseMessaging을 통해 메시지 전송
            return FirebaseMessaging.getInstance().send(message);

        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return "Failed to send message: " + e.getMessage();
        }
    }
}
