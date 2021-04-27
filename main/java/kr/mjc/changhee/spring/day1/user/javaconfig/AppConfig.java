package main.java.kr.mjc.changhee.spring.day1.user.javaconfig;


import main.java.kr.mjc.changhee.java.jdbc.DbUtils;
import main.java.kr.mjc.changhee.spring.day1.user.componentscan.UserDaoImpl;
import main.java.kr.mjc.changhee.java.jdbc.user.UserDao;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {

    @Value("${db.url}")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        return new MariaDbDataSource(dbUrl);
    }

    @Bean
    public DbUtils dbUtils() {
        return new DbUtils(dataSource());
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(dbUtils());
    }
}
