package PrincessMaker.PM_Spring.repository;

import PrincessMaker.PM_Spring.entity.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {

    // 특정 퀴즈 ID의 시도 횟수를 반환
    int countByQuizId(Long quizId);
}
