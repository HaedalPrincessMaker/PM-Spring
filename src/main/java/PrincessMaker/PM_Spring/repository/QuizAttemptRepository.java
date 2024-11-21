package PrincessMaker.PM_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PrincessMaker.PM_Spring.model.QuizAttempt;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {

    // 특정 퀴즈 ID의 시도 횟수를 반환
    int countByQuizId(Long quizId);
}
