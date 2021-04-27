package main.java.kr.mjc.changhee.java.jdbc.article;

import main.java.kr.mjc.changhee.java.jdbc.DataAccessException;

public class UpdateArticleEx {
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDaoImplUsingDbUtils();
        try{
            int updateRows = articleDao.updateArticle(302,"내용 수정 입니다  ");
            Article article = articleDao.getArticle(302);
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
