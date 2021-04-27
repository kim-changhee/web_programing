package main.java.kr.mjc.changhee.spring.day2.article.componentscan;

import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ArticleListEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ArticleDao articleDao = context.getBean("articleDaoImpl", ArticleDao.class);
        List<Article> articleList = articleDao.listArticles(0, 100);
        for (Article article : articleList) {
            System.out.println(article);
        }
    }
}
