package ma.formation.jdbc.dao;

import java.util.List;
import ma.formation.jdbc.service.model.User;

public interface IDao {
    List<User> findAllUsers();
    User getUserByUsername(String username);
}