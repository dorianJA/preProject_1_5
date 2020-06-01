package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserDaoImp implements UserDao{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDaoImp(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void addUser(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT into user(age, name) values (?,?)");
        preparedStatement.setInt(1, user.getAge());
        preparedStatement.setString(2, user.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE from user where id =?");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    @Override
    public User getUserById(long id) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * from user where id =?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        User newUser = new User();
        if(resultSet.next()){
            newUser.setId(resultSet.getInt("id"));
            newUser.setAge(resultSet.getInt("age"));
            newUser.setName(resultSet.getString("name"));
        }
        return newUser;
    }

    @Override
    public void updateUser(User user, int age, String name) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE user set age=?, name = ? where id =?");
        preparedStatement.setLong(1, age);
        preparedStatement.setString(2, name);
        preparedStatement.setLong(3, user.getId());
        int rows = preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> list = new CopyOnWriteArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setAge(resultSet.getInt("age"));
            user.setName(resultSet.getString("name"));
            list.add(user);
        }
        return list;
    }
}
