package dao;


import Util.DBHelper;
import Util.PropertyReader;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.util.Properties;

public class UserDaoFactory {

//singleton, возвращать реализацию, дефолтное значение switch
    private final static PropertyReader propertyReader = new PropertyReader("db.properties");

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
        String daoType = propertyReader.getProperties("daoType");
        switch (daoType){
            case "hibernate":
                return new UserHibernateDAO(DBHelper.getInstance().createSessionFactory());
            case "JDBC":
                return new UserDaoImp(DBHelper.getInstance().getConnection());
            default:
                return new UserHibernateDAO(DBHelper.getInstance().createSessionFactory());

        }

    }
}
