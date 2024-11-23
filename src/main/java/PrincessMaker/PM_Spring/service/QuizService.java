package PrincessMaker.PM_Spring.service;

import PrincessMaker.PM_Spring.entity.Quiz;
import PrincessMaker.PM_Spring.repository.QuizRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;  // QuizRepository 주입

    // 퀴즈 생성
    public void createQuiz(Quiz quiz) {
        quizRepository.save(quiz);  // 퀴즈를 DB에 저장
    }

    // 퀴즈 조회
    public Quiz getQuizById(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.orElse(null);  // 퀴즈 ID로 조회
    }

    // 퀴즈 목록 조회
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // 퀴즈 수정
    public void updateQuiz(Long id, Quiz quiz) {
        Quiz existingQuiz = getQuizById(id);
        if (existingQuiz != null) {
            existingQuiz.setQuestion(quiz.getQuestion());
            existingQuiz.setChoice1(quiz.getChoice1());
            existingQuiz.setChoice2(quiz.getChoice2());
            existingQuiz.setChoice3(quiz.getChoice3());
            existingQuiz.setChoice4(quiz.getChoice4());
            existingQuiz.setChoice5(quiz.getChoice5());
            existingQuiz.setAnswer(quiz.getAnswer());
            existingQuiz.setCreatedAt(quiz.getCreatedAt());

            quizRepository.save(existingQuiz);  // 수정된 퀴즈를 DB에 저장
        }
    }

    // 퀴즈 삭제
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);  // 퀴즈 삭제
    }
}
