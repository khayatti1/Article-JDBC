package ma.formation.jdbc.dao.article;

import java.util.List;
import ma.formation.jdbc.service.model.Article;

public interface IArticleDao {
    List<Article> findAll();
    Article findById(Long id);
    void create(Article article);
    void update(Article article);
    void deleteById(Long id);
    List<Article> findByCriteria(String description, Double minPrice, Double maxPrice);
}