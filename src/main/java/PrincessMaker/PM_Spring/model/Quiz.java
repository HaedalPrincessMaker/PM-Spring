package PrincessMaker.PM_Spring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    // 기본 생성자 (JPA 요구사항)
    public Quiz() {}

    // 모든 필드를 초기화하는 생성자 (선택 사항)
    public Quiz(String question, String choice1, String choice2, String choice3,
                String choice4, String choice5, String answer, String createdAt) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.choice5 = choice5;
        this.answer = answer;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getChoice5() {
        return choice5;
    }

    public void setChoice5(String choice5) {
        this.choice5 = choice5;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

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
