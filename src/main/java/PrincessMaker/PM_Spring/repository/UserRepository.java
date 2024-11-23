package PrincessMaker.PM_Spring.repository;

import PrincessMaker.PM_Spring.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {

    // 사용자 ID로 조회하는 메서드
    Member findByStudentId(String studentId);

    // 닉네임으로 조회하는 메서드 (필요 시)
    Member findByNickname(String nickname);
}
