package ma.formation.jdbc.dao.article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ma.formation.jdbc.dao.DatabaseManager;
import ma.formation.jdbc.service.model.Article;

public class ArticleDaoImplJDBC implements IArticleDao {
    @Override
    public List<Article> findAll() {
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from article");
            while (rs.next()) {
                articles.add(new Article(
                        rs.getLong("id"),
                        rs.getString("description"),
                        rs.getInt("quantite"),
                        rs.getDouble("price")));
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return articles;
    }

    @Override
    public Article findById(Long id) {
        Article article = null;
        try {
            Connection connection = DatabaseManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from article where id=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                article = new Article(
                        rs.getLong("id"),
                        rs.getString("description"),
                        rs.getInt("quantite"),
                        rs.getDouble("price"));
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return article;
    }

    @Override
    public void create(Article article) {
        try {
            Connection connection = DatabaseManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO article(description, quantite, price) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, article.getDescription());
            stmt.setDouble(2, article.getQuantite());
            stmt.setDouble(3, article.getPrice());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    article.setId(generatedKeys.getLong(1));
                }
            }

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    @Override
    public void update(Article article) {
        try {
            Connection connection = DatabaseManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE article SET description=?, quantite=?, price=? WHERE id=?");

            stmt.setString(1, article.getDescription());
            stmt.setDouble(2, article.getQuantite());
            stmt.setDouble(3, article.getPrice());
            stmt.setLong(4, article.getId());

            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            Connection connection = DatabaseManager.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM article WHERE id=?");
            stmt.setLong(1, id);
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    @Override
    public List<Article> findByCriteria(String description, Double minPrice, Double maxPrice) {
        List<Article> articles = new ArrayList<>();
        try {
            Connection connection = DatabaseManager.getInstance().getConnection();

            StringBuilder query = new StringBuilder("SELECT * FROM article WHERE 1=1");
            List<Object> params = new ArrayList<>();

            if (description != null && !description.isEmpty()) {
                query.append(" AND description LIKE ?");
                params.add("%" + description + "%");
            }
            if (minPrice != null) {
                query.append(" AND price >= ?");
                params.add(minPrice);
            }
            if (maxPrice != null) {
                query.append(" AND price <= ?");
                params.add(maxPrice);
            }

            PreparedStatement stmt = connection.prepareStatement(query.toString());

            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                articles.add(new Article(
                        rs.getLong("id"),
                        rs.getString("description"),
                        rs.getInt("quantite"),
                        rs.getDouble("price")));
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return articles;
    }

    private void handleSQLException(SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }
}