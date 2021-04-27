package main.java.kr.mjc.changhee.spring.day2.article.componentscan;

import main.java.kr.mjc.changhee.java.jdbc.DataAccessException;
import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UpdateArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ArticleDao articleDao = context.getBean("articleDaoImpl", ArticleDao.class);
        try{
            int updateRows = articleDao.updateArticle(287,"내용 수정 ");
            Article article = articleDao.getArticle(287);
            if( updateRows > 0) {
                System.out.println("기사를 업데이트 했습니다.");
                System.out.println(article);
            }
            else
                System.out.println("글이 없습니다");
        } catch(DataAccessException e){
            System.err.println(e.getMessage());
        }
    }
}
