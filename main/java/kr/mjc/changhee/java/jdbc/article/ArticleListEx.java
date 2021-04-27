package main.java.kr.mjc.changhee.java.jdbc.article;

import main.java.kr.mjc.changhee.java.jdbc.DataAccessException;

import java.util.List;

public class ArticleListEx {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDaoImplUsingDbUtils();
        try {
            List<Article> articleList = articleDao.listArticles(0, 10);
            for (Article article : articleList) {
                System.out.println(article);
            }
        } catch (DataAccessException e){
            System.err.println(e.getMessage());
        }
    }
}
