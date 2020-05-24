package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    boolean addUser(User user) throws SQLException;
    boolean deleteUser(long id) throws SQLException;
    void updateUser(User user,int age, String name) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}
