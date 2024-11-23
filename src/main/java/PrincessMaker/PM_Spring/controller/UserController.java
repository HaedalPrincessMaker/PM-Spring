package PrincessMaker.PM_Spring.controller;

import PrincessMaker.PM_Spring.dto.MemberDTO;
import PrincessMaker.PM_Spring.entity.Member;
import PrincessMaker.PM_Spring.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 1. 모든 사용자 조회
    @GetMapping
    public ResponseEntity<List<Member>> getAllUsers() {
        List<Member> allUser = userService.getAllUsers();
        return new ResponseEntity(allUser, HttpStatus.OK);
    }

    // 2. 사용자 ID로 조회
    @GetMapping("/{id}")
    public MemberDTO getUserById(@PathVariable Long id) {
        Member selectedUser = userService.getUserById(id);
        MemberDTO selectedUserDTO = new MemberDTO(
                selectedUser.getStudentId(),
                selectedUser.getNickname(),
                selectedUser.getFcmToken()
        );
//        동수♥
        return selectedUserDTO;
    }

    @GetMapping("/name/{nickname}")
    public ResponseEntity<MemberDTO> getUserByStudentId(@PathVariable String nickname) {
        List<Member> allUser = userService.getAllUsers();
        for (Member member : allUser) {
            if (member.getNickname().equals(nickname)) {
                MemberDTO selectedUserDTO = new MemberDTO(
                        member.getStudentId(),
                        member.getNickname(),
                        member.getFcmToken()
                );
                return ResponseEntity.ok(selectedUserDTO);
            }
        }
        return ResponseEntity.notFound().build();  // If no user is found
    }

    // 3. 사용자 추가
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody MemberDTO memberDTO) {
        try {
            if (haveSameUser(memberDTO.getStudentId())) {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            // 회원 정보 생성
            Member createdMember = userService.createUser(
                    new Member(memberDTO.getStudentId(), memberDTO.getNickname(), memberDTO.getFcmToken()));

            // 응답에 반환할 데이터 준비
            Map<String, String> resp = new HashMap<>();
            resp.put("userId", createdMember.getUserId().toString());

            // 성공 응답 (HTTP 200)
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // 실패 응답 (HTTP 400)
            Map<String, String> errorResp = new HashMap<>();
            errorResp.put("message", "회원가입 실패");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 4. 사용자 정보 업데이트
    @PutMapping("/{id}")
    public Member updateUser(@PathVariable Long id, @RequestBody MemberDTO updatedMember) {
        Member updatedMemberDTO = userService.createUser(
                new Member(updatedMember.getStudentId(), updatedMember.getNickname(), updatedMember.getFcmToken()));
        return userService.updateUser(id, updatedMemberDTO);
    }

    // 5. 사용자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).build(); // HTTP 200 OK 응답을 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 오류 발생 시 HTTP 400 응답 반환
        }
    }

    //6.로그인
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody MemberDTO memberDTO) {
        //1. 학번으로 같은 학번이 있는지 조회
        String find = memberDTO.getStudentId();
        List<Member> allMember = userService.getAllUsers();
        for (Member temp : allMember) {
            if (haveSameUser(find)) {
                if (!temp.getNickname().equals(memberDTO.getNickname())) {
                    Map<String, String> errorResp = new HashMap<>();
                    errorResp.put("message", "로그인");
                    return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);
                }
                Map<String, String> resp = new HashMap<>();
                resp.put("userId", temp.getUserId().toString());
                return new ResponseEntity<>(resp, HttpStatus.OK);
            }
        }
        Map<String, String> errorResp = new HashMap<>();
        errorResp.put("message", "로그인");
        return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);
    }

    /**
     * 학번 같은 사람을 조회
     *
     * @param studentID
     * @return 만약 같은 사람이 없다 -> false 같은 사람이 있다 -> true
     */
    private boolean haveSameUser(String studentID) {
        List<Member> allMember = userService.getAllUsers();
        for (Member member : allMember) {
            if (studentID.equals(member.getStudentId())) {
                return true;
            }
        }
        return false;
    }
}
