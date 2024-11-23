package PrincessMaker.PM_Spring.controller;

import PrincessMaker.PM_Spring.entity.Quiz;
import PrincessMaker.PM_Spring.service.QuizAttemptService;
import PrincessMaker.PM_Spring.service.QuizService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuizAttemptService quizAttemptService;

    // 퀴즈 목록 조회
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    // 퀴즈 생성
    @PostMapping
    public void createQuiz(@RequestBody Quiz quiz) {
        quizService.createQuiz(quiz);
    }

    // 퀴즈 조회
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    // 퀴즈 시도 기록 (정답 여부 확인)
    @PostMapping("/{quizId}/attempt")
    public int attemptQuiz(@PathVariable Long quizId, @RequestParam Long userId, @RequestParam boolean isCorrect) {
        return quizAttemptService.recordAttempt(quizId, userId, isCorrect);
    }

    // 퀴즈 수정
    @PutMapping("/{id}")
    public void updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        quizService.updateQuiz(id, updatedQuiz); // 퀴즈 서비스에서 수정된 퀴즈를 처리
    }

    // 퀴즈 삭제
    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }
}
