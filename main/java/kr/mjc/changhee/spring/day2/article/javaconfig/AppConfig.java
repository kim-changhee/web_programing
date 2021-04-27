package main.java.kr.mjc.changhee.spring.day2.article.javaconfig;

import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import main.java.kr.mjc.changhee.spring.day2.article.componentscan.ArticleDaoImpl;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public JdbcTemplate jdbcTemplate(){ return new JdbcTemplate(dataSource()); }

    @Bean
    public ArticleDao articleDao() { return new ArticleDaoImpl(jdbcTemplate()); }
}
