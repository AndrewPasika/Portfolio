package model.DAO_oracle;

import java.sql.*;

/**
 * Created by AndriiUSER on 06.12.2015.
 */
public class Connector {

    private final String URL = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
    private final String USERNAME = "Andrew";
    private final String PASSWORD = "mysite1";

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
