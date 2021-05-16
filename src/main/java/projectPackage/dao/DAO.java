package projectPackage.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    void save(T t) throws SQLException;

    void saveAll(List<T> t) throws SQLException;

    T get(int id) throws SQLException;

    void update(T t) throws SQLException;

    void delete(int id) throws SQLException;

    List<T> getAll() throws SQLException;
}
