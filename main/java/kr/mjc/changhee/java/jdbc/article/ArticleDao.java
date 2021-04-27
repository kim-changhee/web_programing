package main.java.kr.mjc.changhee.java.jdbc.article;
import java.util.List;

public interface ArticleDao {

    /**
     * 글 목록
     */
    List<Article> listArticles(int offset, int count);

    /**
     * 글 보기
     */
    Article getArticle(int articleId);

    /**
     * 글 쓰기
     */
    void addArticle(Article article);

    /**
     * 글 수정
     */
    int updateArticle(int articleId, String content);

    /**
     * 글 삭제
     */
    int deleteArticle(int articleId, int userId);
}