package model.DAO_oracle;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by AndriiUSER on 08.12.2015.
 */
public interface GenericDAO <T, PK extends Serializable>{

    PK create (T object) throws SQLException;

    T read (PK id) throws SQLException;

    void update (T object) throws SQLException;

    void delete (PK id) throws SQLException;

    List<T> getAll () throws SQLException;

}
