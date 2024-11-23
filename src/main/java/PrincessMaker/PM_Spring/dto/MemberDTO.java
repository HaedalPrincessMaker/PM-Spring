package PrincessMaker.PM_Spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String studentId;
    private String nickname;
    private String fcmToken;
}
