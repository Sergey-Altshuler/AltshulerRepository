package projectPackage.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    void save(T t) throws SQLException;

    void saveAll(List<T> t) throws SQLException;

    T get(Class<T> generic, int id) throws SQLException;

    void update( T t) throws SQLException;

    void delete(Class<T> genetic,int id) throws SQLException;

    List<T> getAll(Class <T> generic) throws SQLException;
}
