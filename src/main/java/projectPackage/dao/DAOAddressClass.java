package projectPackage.dao;

import projectPackage.model.Address;
import projectPackage.util.DatabaseStatementsUtilClass;
import projectPackage.util.DriverManagerUtilClass;

import java.sql.*;

public class DAOAddressClass implements DAOAddress {
    @Override
    public void save(Address address) throws SQLException {
        DatabaseStatementsUtilClass.executePreparedStatement("INSERT INTO ADDRESS(street, house) VALUES(?,?)", address);
    }

    @Override
    public Address get(int id) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM ADDRESS WHERE id=" + id);
            rs.next();
            int index = rs.getInt(1);
            String street = rs.getString(2);
            int house = rs.getInt(3);
            return new Address(index, street, house);
        }
    }

    @Override
    public void update(Address address) throws SQLException {
        DatabaseStatementsUtilClass.executePreparedStatement("UPDATE ADDRESS SET STREET=?, HOUSE=? WHERE id=?", address);
    }

    @Override
    public void delete(int id) throws SQLException {
        DatabaseStatementsUtilClass.executeStatement("DELETE FROM ADDRESS WHERE id=" + id);
    }
}
