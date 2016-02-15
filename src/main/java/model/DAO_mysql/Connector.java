package model.DAO_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aedpf on 2/15/16.
 */
public class Connector {

    // URL and credentials
    final static String URL = "jdbc:mysql://localhost:3306/?useSSL=false";
    final static String NAME = "Andrew";
    final static String PASSWORD = "mysite1";
    final static String DRIVER = "com.mysql.jdbc.Driver";

    private volatile Connection connection;

    // create database connection
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
