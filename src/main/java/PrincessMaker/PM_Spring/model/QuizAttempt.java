package PrincessMaker.PM_Spring.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class QuizAttempt {

    // Getters and Setters
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 시도 ID

    @Getter
    @Column(nullable = false)
    private Long quizId;  // 퀴즈 ID

    @Getter
    @Column(nullable = false)
    private Long userId;  // 사용자 ID

    @Column(nullable = false)
    private boolean isCorrect;  // 정답 여부

    // 기본 생성자
    public QuizAttempt() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
