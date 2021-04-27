package main.java.kr.mjc.changhee.spring.day2.article.xmlconfig;

import main.java.kr.mjc.changhee.java.jdbc.DataAccessException;
import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-article.xml");

        ArticleDao articleDao = context.getBean("articleDao",ArticleDao.class);
        try{
            int updateRows = articleDao.updateArticle(318, "내용 수정 ");
            Article article = articleDao.getArticle(318);
            if( updateRows > 0) {
                System.out.println("기사를 업데이트 했습니다.");
                System.out.println("수정된 내용 : " + article.getContent());
            }
            else
                System.out.println("글이 없습니다");
        } catch(DataAccessException e){
            System.err.println(e.getMessage());
        }
    }
}
