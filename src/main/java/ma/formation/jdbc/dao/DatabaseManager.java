package ma.formation.jdbc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private static final String CONF_FILE = "database.properties";
    private static Properties databaseConfig = new Properties();
    private static DatabaseManager instance;
    private static Connection connection;

    private DatabaseManager() {}

    public static DatabaseManager getInstance() {
        if (instance != null)
            return instance;
        instance = new DatabaseManager();
        instance.loadDriver();
        return instance;
    }

    private void loadDriver() {
        try {
            databaseConfig.load(this.getClass().getClassLoader().getResourceAsStream(CONF_FILE));
            Class.forName(databaseConfig.getProperty("database.driver"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Recharger la config si nécessaire
                databaseConfig.load(getClass().getClassLoader().getResourceAsStream(CONF_FILE));
                Class.forName(databaseConfig.getProperty("database.driver"));

                connection = DriverManager.getConnection(
                        databaseConfig.getProperty("database.url"),
                        databaseConfig.getProperty("database.username"),
                        databaseConfig.getProperty("database.password"));
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("Échec de la connexion à la base", e);
        }
    }
}