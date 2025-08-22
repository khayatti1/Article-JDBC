package ma.formation.jdbc.service;

import java.util.List;
import ma.formation.jdbc.dao.DaoImplJDBC;
import ma.formation.jdbc.dao.IDao;
import ma.formation.jdbc.dao.article.ArticleDaoImplJDBC;
import ma.formation.jdbc.dao.article.IArticleDao;
import ma.formation.jdbc.service.model.Article;
import ma.formation.jdbc.service.model.User;

public class ServiceImpl implements IService {
    private IDao dao = new DaoImplJDBC();
    private IArticleDao daoArticle = new ArticleDaoImplJDBC();

    @Override
    public Boolean checkAccount(String username, String password) {
        User u = dao.getUserByUsername(username);
        if (u == null)
            return false;
        return password.equals(u.getPassword());
    }

    @Override
    public List<Article> getAllArticle() {
        return daoArticle.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return daoArticle.findById(id);
    }

    @Override
    public void createArticle(Article article) {
        daoArticle.create(article);
    }

    @Override
    public void updateArticle(Article article) {
        daoArticle.update(article);
    }

    @Override
    public void deleteArticleById(Long id) {
        daoArticle.deleteById(id);
    }

    @Override
    public List<Article> searchArticles(String description, Double minPrice, Double maxPrice) {
        return daoArticle.findByCriteria(description, minPrice, maxPrice);
    }
}