package main.java.kr.mjc.changhee.java.jdbc.article;


import main.java.kr.mjc.changhee.java.jdbc.DataAccessException;

public class AddArticleEx {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDaoImplUsingDbUtils();
        Article article = new Article();
        article.setTitle("제목입니다.");
        article.setContent("내용입니다.");
        article.setUserId(41);
        article.setName("김창희");
        try{
            articleDao.addArticle(article);
            System.out.format("기사를 추가했습니다 : %s\n", article);
        } catch(DataAccessException e){
            System.err.println(e.getMessage());
        }
    }
}
