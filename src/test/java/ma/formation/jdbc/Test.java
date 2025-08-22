package ma.formation.jdbc;

import ma.formation.jdbc.dao.DatabaseManager;
import ma.formation.jdbc.service.model.Article;
import ma.formation.jdbc.service.model.User;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        initUsers(Arrays.asList(
                new User(null, "admin", "admin"),
                new User(null, "user1", "pass1"),
                new User(null, "user2", "pass2")
        ));
    }

    private static void initUsers(List<User> users) {
        try (Connection connection = DatabaseManager.getInstance().getConnection();
             Statement stmt = connection.createStatement()) {

            stmt.executeUpdate("DELETE FROM user"); // Nettoyage préalable

            for (User user : users) {
                String sql = String.format(
                        "INSERT INTO user (username, password) VALUES ('%s', '%s')",
                        user.getUsername(), user.getPassword());
                stmt.executeUpdate(sql);
            }
            System.out.println(users.size() + " utilisateurs insérés avec succès");

        } catch (Exception e) {
            System.err.println("Erreur lors de l'insertion des utilisateurs:");
            e.printStackTrace();
        }
    }

    private static void initArticles(List<Article> articles) {
        try (Connection connection = DatabaseManager.getInstance().getConnection();
             Statement stmt = connection.createStatement()) {

            stmt.executeUpdate("DELETE FROM article"); // Nettoyage préalable

            for (Article article : articles) {
                String sql = String.format(
                        "INSERT INTO article (description, quantite, price) VALUES ('%s', %f, %f)",
                        article.getDescription(), article.getQuantite(), article.getPrice());
                stmt.executeUpdate(sql);
            }
            System.out.println(articles.size() + " articles insérés avec succès");

        } catch (Exception e) {
            System.err.println("Erreur lors de l'insertion des articles:");
            e.printStackTrace();
        }
    }
}