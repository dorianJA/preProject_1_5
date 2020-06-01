package dao;

import Util.HibernateSessionFactory;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDao {
    private Session session;
    private SessionFactory sessionFactory;

    public UserHibernateDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }



    @Override
    public void addUser(User user) throws SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public User getUserById(long id){
        session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where id = :parId");
        query.setParameter("parId",id);
        User user = query.getSingleResult();
        session.close();
        return user;
    }

    @Override
    public void updateUser(User user, int age, String name) throws SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("update User set age = :paramAge, name =:paramName where id = :paraId");
        query.setParameter("paramAge",age);
        query.setParameter("paramName",name);
        query.setParameter("paraId",user.getId());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User");
        List<User> list = query.list();
        session.close();
        return list;
    }
}
