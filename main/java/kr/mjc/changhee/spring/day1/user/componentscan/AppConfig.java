package main.java.kr.mjc.changhee.spring.day1.user.componentscan;

import main.java.kr.mjc.changhee.java.jdbc.DbUtils;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "main.java.kr.mjc.changhee.spring.day1.user.componentscan")
@PropertySource("classpath:db.properties")
public class AppConfig {

    @Bean
    public DataSource dataSource(@Value("${db.url}") String dbUrl) {
        return new MariaDbDataSource(dbUrl);
    }

    @Bean
    public DbUtils dbUtils(DataSource dataSource) {
        return new DbUtils(dataSource);
    }
}
