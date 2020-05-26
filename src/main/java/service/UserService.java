package service;

import Util.DBConnection;
import dao.UserDao;
import dao.UserDaoImp;
import dao.UserHibernateDAO;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao;
//    private Connection connection;

    public UserService() {
//        connection = DBConnection.getDBConnection();
//        userDao = new UserDaoImp(connection);
        userDao = new UserHibernateDAO();
    }

    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }

    public void deleteUser(User user) throws SQLException {
        userDao.deleteUser(user);
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

