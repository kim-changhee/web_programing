package main.java.kr.mjc.changhee.spring.day2.article.javaconfig;

import lombok.extern.slf4j.Slf4j;
import main.java.kr.mjc.changhee.java.jdbc.DataAccessException;
import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class UpdateArticleEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ArticleDao articleDao = context.getBean("articleDao", ArticleDao.class);
        try{
            int updateRows = articleDao.updateArticle(302,"내용 수정 ");
            Article article = articleDao.getArticle(302);
            if( updateRows > 0) {
                log.debug("기사를 업데이트 했습니다.");
                log.info(article.toString());
            }
            else
                log.debug("글이 없습니다");
        } catch(DataAccessException e){
            System.err.println(e.getMessage());
        }
    }
}
