package model.DAO;

import java.sql.*;

/**
 * Created by AndriiUSER on 06.12.2015.
 */
public class Connector {

    private final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private final String USERNAME = "c##Andrii";
    private final String PASSWORD = "pasika12";

    private Connection connection;

    public Connector(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
