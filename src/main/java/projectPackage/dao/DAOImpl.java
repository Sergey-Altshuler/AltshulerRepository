package projectPackage.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import projectPackage.util.SessionUtil;

import java.sql.SQLException;
import java.util.List;

public class DAOImpl<T> implements DAO<T> {
    private static final Session session = SessionUtil.getSession();
    private static final Transaction transaction = session.getTransaction();

    @Override
    public void save(T t) throws SQLException {
        transaction.begin();
        session.save(t);
        transaction.commit();
    }

    @Override
    public void saveAll(List<T> t) throws SQLException {
        for (T value : t) {
            save(value);
        }
    }

    @Override
    public T get(Class<T> generic, int id) throws SQLException {
        transaction.begin();
        T t = session.get(generic, id);
        transaction.commit();
        return t;
    }

    @Override
    public void update(T t) throws SQLException {
        transaction.begin();
        session.update(t);
        transaction.commit();
    }

    @Override
    public void delete(Class<T> generic, int id) throws SQLException {
        transaction.begin();
        T t = session.get(generic, id);
        session.delete(t);
        transaction.commit();
    }

    @Override
    public List<T> getAll(Class<T> generic) throws SQLException {
        String hql = "from " + generic.getTypeName();
        return (List<T>) session.createQuery(hql).list();
    }
}
