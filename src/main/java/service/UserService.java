package service;

import Util.DBConnection;
import dao.UserDaoImp;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private Connection connection;
    private UserDaoImp userDao;

    public UserService() {
        connection = DBConnection.getDBConnection();
        userDao = new UserDaoImp(connection);
    }

    public boolean addUser(User user) throws SQLException {
        return userDao.addUser(user);
    }

    public boolean deleteUser(long id) throws SQLException {
        return userDao.deleteUser(id);
    }

    public void updateUser(User user, int age, String name) throws SQLException {
        userDao.updateUser(user, age, name);
    }

    public User getUserbyId(long id) throws SQLException {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
}

