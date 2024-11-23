package PrincessMaker.PM_Spring.dto;

public class NotificationRequest {

    private String token; // FCM 토큰
    private String title; // 알림 제목
    private String body;  // 알림 내용

    // Getter & Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}