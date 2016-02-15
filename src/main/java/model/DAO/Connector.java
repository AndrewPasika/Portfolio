package model.DAO;

import java.sql.*;

/**
 * Created by aedpf on 2/15/16.
 */
public class Connector {

    /** URL and credentials */
    final static String URL = "jdbc:mysql://localhost:3306/Portfolio?useSSL=false";
    final static String NAME = "Andrew";
    final static String PASSWORD = "mysite1";
    final static String DRIVER = "com.mysql.jdbc.Driver";

    private static volatile Connection connection;

    /** Create database connection */
    public Connector(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
