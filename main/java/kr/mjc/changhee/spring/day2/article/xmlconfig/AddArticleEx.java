package main.java.kr.mjc.changhee.spring.day2.article.xmlconfig;

import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class AddArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-article.xml");

        ArticleDao articleDao = context.getBean("articleDao", ArticleDao.class);

        Article article = new Article();
        article.setTitle("제목입니다.");
        article.setContent("내용입니다.");
        article.setUserId(41);
        article.setName("김창희");

        try {
            articleDao.addArticle(article);
            System.out.println("기사를 추가했습니다.");
            System.out.println(article);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
