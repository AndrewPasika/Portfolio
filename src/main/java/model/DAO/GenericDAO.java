package model.DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aedpf on 2/15/16.
 */
public interface GenericDAO <T, PK extends Serializable> {

    PK create (T object) throws SQLException;

    T read (PK id) throws SQLException;

    void update (T object) throws SQLException;

    void delete (PK id) throws SQLException;

    List<T> getAll() throws SQLException;
}
