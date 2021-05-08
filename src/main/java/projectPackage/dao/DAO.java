package projectPackage.dao;

import java.sql.SQLException;

public interface DAO <T> {
    void save (T t) throws SQLException;
    T get (int id)  throws SQLException;
    void update (T t) throws SQLException;
    void delete (int id) throws SQLException;
}
