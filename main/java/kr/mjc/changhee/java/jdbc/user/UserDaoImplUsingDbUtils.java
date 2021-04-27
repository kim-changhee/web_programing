package main.java.kr.mjc.changhee.java.jdbc.user;


import main.java.kr.mjc.changhee.java.jdbc.DbUtils;
import main.java.kr.mjc.changhee.java.jdbc.ResultSetHandler;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImplUsingDbUtils implements UserDao {

    private static final String DB_URL
            = "jdbc:mariadb://irafe.com:3306/cafe?user=cafe&password=xxxx";

    private static final String LIST_USERS
            = "select userId, email, name from user order by userId desc limit ?,?";

    private static final String ADD_USER
            = "insert user(email, password, name) values(?, sha2(?,256), ?)";

    private static final String LOGIN
            = "select userId, email, name from user where (email, password) = (?, sha2(?,256))";

    private static final String GET_USER
            = "select userId, email, name from user where userId=?";

    private static final String UPDATE_EMAIL
            = "update user set email=? where userId=?";

    private static final String UPDATE_PASSWORD
            = "update user set password=sha2(?,256) where userId=?";

    private DbUtils dbUtils;

    ResultSetHandler<User> h = (rs) -> {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        return user;
    };

    /*
    ResultSetHandler<User> h = new ResultSetHandler<>(){
        public User handle(ResultSet rs) throws SQLException{
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("name"));
            return user;
        }
    }
     */

    public UserDaoImplUsingDbUtils() {
        DataSource dataSource = new MariaDbDataSource(DB_URL);
        dbUtils = new DbUtils(dataSource);
    }

    @Override
    public List<User> listUsers(int offset, int count) {
        return dbUtils.list(LIST_USERS, h, offset, count);
    }

    @Override
    public User login(String email, String password) {
        return dbUtils.get(LOGIN, h, email, password);
    }

    @Override
    public User getUser(int userId) {
        return dbUtils.get(GET_USER, h, userId);
    }

    @Override
    public void addUser(User user) {
        dbUtils .update(ADD_USER, user.getEmail(), user.getPassword(), user.getName());
    }

    @Override
    public int updateEmail(int userId, String email) {
        return dbUtils.update(UPDATE_EMAIL, email, userId);
    }

    @Override
    public int updatePassword(int userId, String newPassword, String oldPassword) {
        return dbUtils.update(UPDATE_PASSWORD, newPassword, userId, oldPassword);
    }
}
