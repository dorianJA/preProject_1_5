package Util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    private static SessionFactory sessionFactory;
    private static Properties properties;
    private static DBHelper dbHelper;

    private DBHelper() {

    }

    public static DBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
//            properties = PropertyReader.getProperties(ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties"));
            properties = PropertyReader.getProperties(DBHelper.class.getClassLoader().getResourceAsStream("db.properties"));
        }
        return dbHelper;
    }


    private Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("driver"));
        configuration.setProperty("hibernate.connection.url", properties.getProperty("url"));
        configuration.setProperty("hibernate.connection.username", properties.getProperty("username"));
        configuration.setProperty("hibernate.connection.password", properties.getProperty("password"));
        configuration.setProperty("hibernate.show_sql", properties.getProperty("show_sql"));
        configuration.setProperty("hibernate.hbm2ddl.auto", properties.getProperty("hbm2ddl"));
//        configuration.setProperty("hibernate.dialect",properties.getProperty("dialect"));
        return configuration;
    }

    public SessionFactory createSessionFactory() {
        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public Connection getConnection() {
        Connection connection;
        try {
            String url = properties.getProperty("url");
            String password = properties.getProperty("password");
            String userName = properties.getProperty("username");
            String driver = properties.getProperty("driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException();
        }
    }


}
