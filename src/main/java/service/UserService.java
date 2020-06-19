package service;

import Util.DBHelper;
import dao.UserDao;
import dao.UserDaoFactory;
import dao.UserHibernateDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

//interface, static final userdao, свои исключения

public class UserService {

    private final static UserDao userDao = UserDaoFactory.getUserDao();
    private static UserService userService;

    private UserService() {

    }

    public static UserService getInstance() {
        if (userService == null){
            userService = new UserService();
        }
        return userService;
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

    public User getUserById(long id) throws SQLException {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
    public User getUserByNameAndPassword(String name, String password) throws SQLException {
        return userDao.getUserByNameAndPassword(name,password);
    }
}

