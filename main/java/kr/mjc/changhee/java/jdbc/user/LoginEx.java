package main.java.kr.mjc.changhee.java.jdbc.user;

public class LoginEx {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpUsingRawJDBC();
        User user = userDao.login("hee@daum.net", "hee");
        if(user != null){
            System.out.format("로그인 했습니다. : %s\n", user);
        } else{
            System.out.println("이메일이나 비빌번호가 틀립니다. ");
        }

    }
}
