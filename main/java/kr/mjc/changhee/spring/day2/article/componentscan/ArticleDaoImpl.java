package main.java.kr.mjc.changhee.spring.day2.article.componentscan;

import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("articleDaoImpl")
public class ArticleDaoImpl implements ArticleDao {

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

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Article> rowMapper = new BeanPropertyRowMapper<>(Article.class);

    @Autowired
    public ArticleDaoImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Article> listArticles(int offset, int count) {
        return jdbcTemplate.query(LIST_ARTICLES, rowMapper, offset, count);
    }

    @Override
    public Article getArticle(int articleId) {
        return jdbcTemplate.queryForObject(GET_ARTICLE, rowMapper, articleId);
    }

    @Override
    public void addArticle(Article article) {
        jdbcTemplate.update(ADD_ARTICLE, article.getTitle(), article.getContent(), article.getUserId(),article.getName());
    }

    @Override
    public int updateArticle(int articleId, String content) {
        return jdbcTemplate.update(UPDATE_ARTICLE, content, articleId);
    }

    @Override
    public int deleteArticle(int articleId, int userId) {
        return jdbcTemplate.update(DELETE_ARTICLE, articleId, userId);
    }
}
