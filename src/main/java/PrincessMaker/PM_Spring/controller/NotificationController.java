package PrincessMaker.PM_Spring.controller;

import PrincessMaker.PM_Spring.dto.NotificationRequest;
import PrincessMaker.PM_Spring.service.FirebaseMessagingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final FirebaseMessagingService firebaseMessagingService;

    public NotificationController(FirebaseMessagingService firebaseMessagingService) {
        this.firebaseMessagingService = firebaseMessagingService;
    }

    // 푸시 알림 전송 엔드포인트
    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        System.out.println("sendNotification");
        String response = firebaseMessagingService.sendNotification(
                request.getToken(),
                request.getTitle(),
                request.getBody()
        );
        return ResponseEntity.ok(response);
    }
}

