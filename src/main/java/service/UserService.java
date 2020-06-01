package service;

import Util.DBHelper;
import dao.UserDao;
import dao.UserDaoFactory;
import dao.UserHibernateDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDao userDao;
    private static UserService userService;
//    private Connection connection;

    private UserService() {

//        connection = Del.getDBConnection();
//        userDao = new UserDaoImp(connection);
//        userDao = new UserHibernateDAO();
        userDao = UserDaoFactory.getUserDao("JDBC");
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

    public User getUserbyId(long id) throws SQLException {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }
}

