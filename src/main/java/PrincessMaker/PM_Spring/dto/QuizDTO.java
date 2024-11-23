package PrincessMaker.PM_Spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private Long id;
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String choice5;
}
