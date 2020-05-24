package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;
    private static  String userName = "root";
    private static  String password = "root";
    private static  String url = "jdbc:mysql://localhost:3306/java_testing?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection getDBConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url,userName,password);
            }
        }catch (Exception e){
            System.out.println("DB Connection Error");
            e.printStackTrace();
        }
        return connection;
    }
}
