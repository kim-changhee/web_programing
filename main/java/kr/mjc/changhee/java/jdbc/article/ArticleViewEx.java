package main.java.kr.mjc.changhee.java.jdbc.article;

public class ArticleViewEx {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDaoImplUsingDbUtils();
        Article article = articleDao.getArticle(1);
        System.out.println(article);
    }
}
