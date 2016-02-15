package model.DAO;

import model.javaBeans.UserBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aedpf on 2/15/16.
 */
public class UserDAO implements GenericDAO <UserBean, Integer>{

    /** Table columns' names */
    private static final String TABLE_NAME = "users";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String LOGIN = "login";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

    /* CRUD queries */
    private static final String CREATE = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)",
            TABLE_NAME, NAME, SURNAME, LOGIN, EMAIL, PASSWORD);
    private static final String SELECT = String.format("SELECT * FROM %s WHERE %s=?", TABLE_NAME, ID);
    private static final String UPDATE = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
            TABLE_NAME, NAME, SURNAME, LOGIN, EMAIL, PASSWORD, ID);
    private static final String DELETE = String.format("DELETE FROM %s WHERE %s=?", TABLE_NAME, ID);

    /* Other queries */
    private static final String SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);
    private static final String AUTHORIZATION = String.format("SELECT %s FROM %s WHERE (%s=? or %s=?) and %s=?",
            ID, TABLE_NAME, EMAIL, LOGIN, PASSWORD);

    /* Singleton instance */
    private static UserDAO INSTANCE;

    private UserDAO(){}

    public static UserDAO getInstance(){
        if(INSTANCE == null){
            synchronized (UserDAO.class){
                if(INSTANCE == null){
                    INSTANCE = new UserDAO();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Integer create(UserBean object) throws SQLException {
        Integer id = -1;
        try (Connection connection = new Connector().getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, object.getName());
            statement.setString(2, object.getSurname());
            statement.setString(3, object.getLogin());
            statement.setString(4, object.getEmail());
            statement.setString(5, object.getPassword());

            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
                return id;
            }else {
                throw new SQLException("User not created");
            }
        }
    }

    @Override
    public UserBean read(Integer key) throws SQLException {
        UserBean user = null;
        try(Connection connection = new Connector().getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT);
        ){
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return new UserBean(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"));
            }else {
                throw new SQLException("User not found");
            }
        }
    }

    @Override
    public void update(UserBean object) throws SQLException {
        try( Connection connection = new Connector().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE);
        ){
            statement.setString(1, object.getName());
            statement.setString(2, object.getSurname());
            statement.setString(3, object.getLogin());
            statement.setString(4, object.getEmail());
            statement.setString(5, object.getPassword());
            statement.setInt(6, object.getId());

            statement.execute();
        }

    }

    @Override
    public void delete(Integer key) throws SQLException {
        try ( Connection connection = new Connector().getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE);
        ){
            statement.setInt(1, key);
            statement.execute();
        }
    }

    @Override
    public List<UserBean> getAll() throws SQLException {
        List<UserBean> list = new ArrayList<>();
        try (Connection connection = new Connector().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
        ){
            ResultSet rs = statement.executeQuery();
            int index = 0;
            while (rs.next()){
                list.add(new UserBean(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password")));
            }
            return list;
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
