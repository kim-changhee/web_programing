package main.java.kr.mjc.changhee.spring.day2.article.xmlconfig;

import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ArticleListEx {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-article.xml");

        ArticleDao articleDao = context.getBean("articleDao", ArticleDao.class);
        List<Article> articleList = articleDao.listArticles(0, 100);
        for(Article article : articleList){
            System.out.println(article);
        }
    }
}
