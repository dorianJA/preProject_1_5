package dao;


import Util.DBHelper;
import Util.PropertyReader;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.util.Properties;

public class UserDaoFactory {

//singleton, возвращать реализацию, дефолтное значение switch

//    private static UserDaoFactory userDaoFactory;
//
//    private UserDaoFactory(){
//
//    }
//
//    public static UserDaoFactory getFactory(){
//        if(userDaoFactory == null){
//            userDaoFactory = new UserDaoFactory();
//        }
//        return userDaoFactory;
//    }


    public static UserDao getUserDao() {
        Properties properties = PropertyReader.getProperties(DBHelper.class.getClassLoader().getResourceAsStream("db.properties"));
        if (properties.getProperty("daoType").equals("hibernate")) {
            SessionFactory sessionFactory = DBHelper.getInstance().createSessionFactory();
            return new UserHibernateDAO(sessionFactory);
        }
        if (properties.getProperty("daoType").equals("JDBC")) {
            Connection connection = DBHelper.getInstance().getConnection();
            return new UserDaoImp(connection);
        }
        throw new IllegalArgumentException();

    }
}
