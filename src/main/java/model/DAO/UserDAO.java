package model.DAO;

import model.javaBeans.UserBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndriiUSER on 18.11.2015.
 */
public class UserDAO implements GenericDAO<UserBean, Integer>{
    /* Table name and fields */
    private static final String TABLE_NAME = "users";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String LOGIN = "login";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    /* CRUD queries */
    private static final String CREATE = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)"
            , TABLE_NAME, NAME, SURNAME, LOGIN, EMAIL, PASSWORD);
    private static final String UPDATE = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?"
            , TABLE_NAME, NAME, SURNAME, LOGIN, EMAIL, PASSWORD, ID);
    private static final String DELETE = String.format("DELETE FROM %s WHERE %s=?"
            , TABLE_NAME, ID);
    private static final String SELECT = String.format("SELECT * FROM %s WHERE %s=?", TABLE_NAME, ID);

    /* other queries */
    private static final String SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);
    private static final String RETRIEVE_ID = String.format("SELECT %s FROM %s WHERE %s=?", ID, TABLE_NAME, EMAIL);
    private static final String AUTHORIZATION = String.format("SELECT %s FROM %s WHERE (%s=? or %s=?) and %s=?"
            , ID, TABLE_NAME, EMAIL, LOGIN, PASSWORD);

    /* Singleton instance */
    private static volatile UserDAO INSTANCE;

    private UserDAO(){}

    public static UserDAO getInstance() {
        if(INSTANCE == null) {
            synchronized (UserDAO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDAO();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Integer create(UserBean object) throws SQLException {
        try(
                Connection connection = new Connector().getConnection();
                PreparedStatement statement = connection.prepareStatement(CREATE);
                PreparedStatement statement1 = connection.prepareStatement(RETRIEVE_ID);
        ){
            statement.setString(1, object.getName());
            statement.setString(2, object.getSurname());
            statement.setString(3, object.getLogin());
            statement.setString(4, object.getEmail());
            statement.setString(5, object.getPassword());
            statement.executeUpdate();

            statement1.setString(1, object.getEmail());
            ResultSet rs = statement1.executeQuery();

            if(rs.next()){
                return rs.getInt(1);
            }else {
                throw new SQLException("User not created!");
            }
        }
    }

    @Override
    public UserBean read(Integer id) throws SQLException {
        try(
                Connection connection = new Connector().getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT);
        ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new UserBean(
                        resultSet.getInt(ID),
                        resultSet.getString(NAME),
                        resultSet.getString(SURNAME),
                        resultSet.getString(LOGIN),
                        resultSet.getString(EMAIL),
                        resultSet.getString(PASSWORD)
                        );
            }else {
                throw new SQLException("User not found");
            }
        }
    }

    @Override
    public void update(UserBean object) throws SQLException {
        try(
                Connection connection = new Connector().getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE);
        ){
            statement.setString(1, object.getName());
            statement.setString(2, object.getSurname());
            statement.setString(3, object.getLogin());
            statement.setString(5, object.getEmail());
            statement.setString(4, object.getPassword());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try(
                Connection connection = new Connector().getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE);
        ){
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<UserBean> getAll() throws SQLException{
        List<UserBean> users = new ArrayList<>();

        try (
                Connection connection = new Connector().getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
        ){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                users.add(
                        new UserBean(
                                resultSet.getInt(ID),
                                resultSet.getString(NAME),
                                resultSet.getString(SURNAME),
                                resultSet.getString(LOGIN),
                                resultSet.getString(EMAIL),
                                resultSet.getString(PASSWORD)
                        )
                );
            }
            return users;
        }
    }

    public int authorization(String loginOrEmail, String password, int position, int blank) throws SQLException {
        try (
                Connection connection = new Connector().getConnection();
                PreparedStatement statement = connection.prepareStatement(AUTHORIZATION);
        ) {
            statement.setString(position, loginOrEmail);
            statement.setString(blank, "");
            statement.setString(3, password);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getInt(ID);
            }else {
                throw new SQLException("User not found");
            }
        }
    }
}
