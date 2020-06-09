package dao;

import Util.DBConnection;
import Util.DBHelper;
import Util.PropertyReader;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.util.Properties;

public class UserDaoFactory {


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
