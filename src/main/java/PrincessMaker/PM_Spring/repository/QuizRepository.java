package PrincessMaker.PM_Spring.repository;

import PrincessMaker.PM_Spring.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
