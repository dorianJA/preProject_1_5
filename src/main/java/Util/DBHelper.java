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
    private static final PropertyReader propertyReader = new PropertyReader("db.properties");
    private static DBHelper dbHelper;

    private DBHelper() {

    }

    public static DBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
//            properties = PropertyReader.getProperties(ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties"));

        }
        return dbHelper;
    }


    private Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.connection.driver_class",propertyReader.getProperties("driver"));
        configuration.setProperty("hibernate.connection.url", propertyReader.getProperties("url"));
        configuration.setProperty("hibernate.connection.username",propertyReader.getProperties("username"));
        configuration.setProperty("hibernate.connection.password", propertyReader.getProperties("password"));
        configuration.setProperty("hibernate.show_sql", propertyReader.getProperties("show_sql"));
        configuration.setProperty("hibernate.hbm2ddl.auto", propertyReader.getProperties("hbm2ddl"));
//        configuration.setProperty("hibernate.dialect",propertyReader.getProperties("dialect"));
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
            String url = propertyReader.getProperties("url");
            String password = propertyReader.getProperties("password");
            String userName = propertyReader.getProperties("username");
            String driver = propertyReader.getProperties("driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException();
        }
    }


}
