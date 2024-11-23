package PrincessMaker.PM_Spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                  // 퀴즈 ID (고유값, Long)

    @Column(nullable = false)         // 필수 필드
    private String question;          // 문제 (varchar)

    @Column(nullable = false)
    private String choice1;           // 답안 1 (varchar)

    @Column(nullable = false)
    private String choice2;           // 답안 2 (varchar)

    @Column(nullable = false)
    private String choice3;           // 답안 3 (varchar)

    @Column(nullable = false)
    private String choice4;           // 답안 4 (varchar)

    @Column(nullable = false)
    private String choice5;           // 답안 5 (varchar)

    @Column(nullable = false)
    private String answer;            // 정답 (varchar, 답안 중 하나)

    @Column(nullable = false)
    private String createdAt;         // 생성일시 (varchar)

    // Optional: toString 메서드 추가 (디버깅 및 로깅에 유용)
    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", choice4='" + choice4 + '\'' +
                ", choice5='" + choice5 + '\'' +
                ", answer='" + answer + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
