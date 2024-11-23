package PrincessMaker.PM_Spring.service;

import PrincessMaker.PM_Spring.entity.QuizAttempt;
import PrincessMaker.PM_Spring.repository.QuizAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizAttemptService {

    @Autowired
    private QuizAttemptRepository quizAttemptRepository;

    /**
     * 퀴즈 시도를 기록하고, 해당 퀴즈의 총 시도 횟수를 반환합니다.
     *
     * @param quizId    퀴즈 ID
     * @param userId    사용자 ID
     * @param isCorrect 정답 여부
     * @return 해당 퀴즈의 총 시도 횟수
     */
    public int recordAttempt(Long quizId, Long userId, boolean isCorrect) {
        // 퀴즈 시도 생성
        QuizAttempt quizAttempt = new QuizAttempt();
        quizAttempt.setQuizId(quizId);
        quizAttempt.setUserId(userId);
        quizAttempt.setIsCorrect(isCorrect);

        // DB에 저장
        quizAttemptRepository.save(quizAttempt);

        // 해당 퀴즈의 시도 횟수 반환
        return quizAttemptRepository.countByQuizId(quizId);
    }
}
