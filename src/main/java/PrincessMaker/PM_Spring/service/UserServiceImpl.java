package PrincessMaker.PM_Spring.service;

import PrincessMaker.PM_Spring.entity.Member;
import PrincessMaker.PM_Spring.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Member> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Member getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Member createUser(Member member) {
        // 추가적인 검증 로직을 여기에 작성할 수 있습니다.
        return userRepository.save(member);
    }

    @Override
    public Member updateUser(Long id, Member updatedMember) {
        return userRepository.findById(id).map(member -> {
            member.setStudentId(updatedMember.getStudentId());
            member.setNickname(updatedMember.getNickname());
            return userRepository.save(member);
        }).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
    }

    @Override
    public Member getUserByStudentId(String studentId) {
        return userRepository.findByStudentId(studentId);
    }
}
