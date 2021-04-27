package main.java.kr.mjc.changhee.java.jdbc.article;

import main.java.kr.mjc.changhee.java.jdbc.DataAccessException;

public class DeleteArticleEx {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDaoImplUsingDbUtils();
        Article article = new Article();
        try{
            articleDao.deleteArticle(17, 41);
            System.out.format("기사를 삭제했습니다. : %s\n", article);
        } catch(DataAccessException e) {
            System.err.println(e.getMessage());
        }
    }
}
