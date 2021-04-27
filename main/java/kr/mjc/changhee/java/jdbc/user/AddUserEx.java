package main.java.kr.mjc.changhee.java.jdbc.user;

import main.java.kr.mjc.changhee.java.jdbc.DataAccessException;

public class AddUserEx {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpUsingRawJDBC();
        User user = new User();
        user.setEmail("hee@daum.net");
        user.setPassword("hee");
        user.setName("김창희");
        try{
            userDao.addUser(user);
            System.out.format("사용자를 추가했습니다 : %s\n", user);
        } catch (DataAccessException e){
            System.err.println(e.getMessage());
        }
    }
}
