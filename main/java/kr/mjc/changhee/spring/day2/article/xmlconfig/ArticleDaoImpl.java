package main.java.kr.mjc.changhee.spring.day2.article.xmlconfig;

import main.java.kr.mjc.changhee.java.jdbc.article.Article;
import main.java.kr.mjc.changhee.java.jdbc.article.ArticleDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleDaoImpl implements ArticleDao {

    private static final String LIST_ARTICLES
            = "select articleId, title, userId, name from article order by articleId desc limit :offset ,:count";

    private static final String ADD_ARTICLE
            = "insert article(title, content, userId, name) values(:title, :content, :userId, :name)";

    private static final String GET_ARTICLE
            = "select articleId, userId, title, content, name, cdate, udate from article where articleId=:articleId";

    private static final String UPDATE_ARTICLE
            = "update article set content=:content where articleId=:articleId";

    private static final String DELETE_ARTICLE
            = "delete from article where articleId=:articleId and userId=:userId";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private RowMapper<Article> rowMapper = new BeanPropertyRowMapper<>(Article.class);

    public ArticleDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) { this.namedParameterJdbcTemplate = namedParameterJdbcTemplate; }

    @Override
    public List<Article> listArticles(int offset, int count) {
        Map<String, Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("count", count);
        return namedParameterJdbcTemplate.query(LIST_ARTICLES, params, rowMapper);
    }

    @Override
    public Article getArticle(int articleId) {
        SqlParameterSource params = new MapSqlParameterSource("articleId", articleId);
        return namedParameterJdbcTemplate.queryForObject(GET_ARTICLE, params, rowMapper);
    }

    @Override
    public void addArticle(Article article) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(article);
        namedParameterJdbcTemplate.update(ADD_ARTICLE, params);
    }

    @Override
    public int updateArticle(int articleId, String content) {
        Map<String, Object> params = new HashMap<>();
        params.put("content", content);
        params.put("articleId", articleId);
        return namedParameterJdbcTemplate.update(UPDATE_ARTICLE, params);
    }

    @Override
    public int deleteArticle(int articleId, int userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("articleId", articleId);
        params.put("userId", userId);
        return namedParameterJdbcTemplate.update(DELETE_ARTICLE, params);
    }
}