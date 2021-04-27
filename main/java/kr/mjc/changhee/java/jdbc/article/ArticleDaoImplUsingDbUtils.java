package main.java.kr.mjc.changhee.java.jdbc.article;


import main.java.kr.mjc.changhee.java.jdbc.DbUtils;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.util.List;

public class ArticleDaoImplUsingDbUtils implements ArticleDao{
    private static final String DB_URL
            = "jdbc:mariadb://irafe.com:3306/cafe?user=cafe&password=xxxx";

    private static final String LIST_ARTICLES
            = "select articleId, title, userId, name from article order by articleId desc limit ?,?";

    private static final String ADD_ARTICLE
            = "insert article(title, content, userId, name) values(?, ?, ?, ?)";

    private static final String GET_ARTICLE
            = "select articleId, userId, title, content, name, cdate, udate from article where articleId=?";

    private static final String UPDATE_ARTICLE
            = "update article set content=? where articleId=?";

    private static final String DELETE_ARTICLE
            = "delete from article where articleId=? and userId=?";

    private DbUtils dbUtils;

    public ArticleDaoImplUsingDbUtils() {
        DataSource dataSource = new MariaDbDataSource(DB_URL);
        dbUtils = new DbUtils(dataSource);
    }

    @Override
    public List<Article> listArticles(int offset, int count) {
        return dbUtils.list(LIST_ARTICLES, (rs) -> {
            Article article = new Article();
            article.setArticleId(rs.getInt("articleId"));
            article.setTitle(rs.getString("title"));
            article.setUserId(rs.getInt("userId"));
            article.setName(rs.getString("name"));
            return article;
        }, offset, count);
    }

    public Article getArticle(int articleId){
        return dbUtils.get(GET_ARTICLE, (rs) -> {
            Article article = new Article();
            article.setArticleId(rs.getInt("articleId"));
            article.setUserId(rs.getInt("userId"));
            article.setTitle(rs.getString("title"));
            article.setContent(rs.getString("content"));
            article.setName(rs.getString("name"));
            article.setCdate(rs.getString("cdate"));
            article.setUdate(rs.getString("udate"));
            return article;
        }, articleId);
    }

    public void addArticle(Article article){
        dbUtils.update(ADD_ARTICLE, article.getTitle(), article.getContent(), article.getUserId(), article.getName());
    }

    public int updateArticle(int articleId, String content){
        return dbUtils.update(UPDATE_ARTICLE, content, articleId);
    }

    public int deleteArticle(int articleId, int userId){
        return dbUtils.update(DELETE_ARTICLE, articleId, userId);
    }
}
