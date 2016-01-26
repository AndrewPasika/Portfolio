package model.DAO;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by AndriiUSER on 08.12.2015.
 */
public interface GenericDAO <T, PK extends Serializable>{

    PK create (T object) throws SQLException;

    T read (PK id) throws SQLException;

    void update (T object) throws SQLException;

    void delete (PK id) throws SQLException;
}
