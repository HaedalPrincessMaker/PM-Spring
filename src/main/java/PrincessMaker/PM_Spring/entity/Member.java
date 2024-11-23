package PrincessMaker.PM_Spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String studentId;
    private String nickname;
    private String fcmToken;

    public Member(String studentId, String nickname, String fcmToken) {
        this.studentId = studentId;
        this.nickname = nickname;
        this.fcmToken = fcmToken;
    }
}
