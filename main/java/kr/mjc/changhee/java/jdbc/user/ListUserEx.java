package main.java.kr.mjc.changhee.java.jdbc.user;

import java.util.List;

public class ListUserEx {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpUsingRawJDBC();
        List<User> userList = userDao.listUsers(0, 10);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
