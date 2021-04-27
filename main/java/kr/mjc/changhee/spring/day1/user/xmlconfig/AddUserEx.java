package main.java.kr.mjc.changhee.spring.day1.user.xmlconfig;

import main.java.kr.mjc.changhee.java.jdbc.user.User;
import main.java.kr.mjc.changhee.java.jdbc.user.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class AddUserEx {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-user.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setEmail("david@daum.net");
        user.setName("David");
        user.setPassword("x");

        try {
            userDao.addUser(user);
            System.out.println("user를 추가했습니다.");
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}