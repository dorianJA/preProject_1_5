package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void addUser(User user) throws SQLException;
    void deleteUser(User user) throws SQLException;
    void updateUser(User user,int age, String name) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    User getUserById(long id) throws SQLException;
}
