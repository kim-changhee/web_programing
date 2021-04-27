package main.java.kr.mjc.changhee.java.jdbc.user;

import java.util.List;

public interface UserDao {
    List<User> listUsers(int offset, int count);
    // offset = 시작 위치, count = 개수

    // 회원가입
    void addUser(User user);
    // 로그인
    User login(String email, String password);
    // 회원 조회
    User getUser(int userId);
    // 이메일 수정
    int updateEmail(int userId, String email);
    // 비밀번호 수정
    int updatePassword(int userId, String oldPassword, String newPassword);
}
