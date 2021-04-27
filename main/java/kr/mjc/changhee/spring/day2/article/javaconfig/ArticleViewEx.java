package main.java.kr.mjc.changhee.spring.day2.article.javaconfig;

import lombok.extern.slf4j.Slf4j;
import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

@Slf4j
public class ArticleViewEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ArticleDao articleDao = context.getBean("articleDao", ArticleDao.class);
        try{
            Article article = articleDao.getArticle(146);
            log.info(article.toString());
        } catch (EmptyResultDataAccessException e){
            System.err.format("데이터가 없습니다.");
        }
    }
}
