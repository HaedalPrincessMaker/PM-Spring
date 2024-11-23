package PrincessMaker.PM_Spring.service;

import PrincessMaker.PM_Spring.entity.Member;
import java.util.List;

public interface UserService {

    // 모든 사용자 조회
    List<Member> getAllUsers();

    // 특정 사용자 조회
    Member getUserById(Long id);

    // 사용자 추가
    Member createUser(Member member);

    // 사용자 업데이트
    Member updateUser(Long id, Member updatedMember);

    // 사용자 삭제
    void deleteUser(Long id);

    // 특정 사용자 조회 (학생 ID로)
    Member getUserByStudentId(String studentId);
}
