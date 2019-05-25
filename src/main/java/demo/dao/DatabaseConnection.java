package demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://database:3306/demo","root","password");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
