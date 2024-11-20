package PrincessMaker.PM_Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import PrincessMaker.PM_Spring.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // 추가적인 커스텀 쿼리가 필요하면 여기 정의할 수 있음
}
