package projectPackage.util;

import projectPackage.model.Address;
import projectPackage.model.Person;
import java.sql.*;

public class DatabaseStatementsUtilClass {

    public static void executePreparedStatement(String sql, Person person) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            if (sql.toUpperCase().matches(".*UPDATE.*")) {
                ps.setString(1, person.getName());
                ps.setString(2, person.getSurname());
                ps.setInt(3, person.getAge());
                ps.setInt(4, person.getId());
            } else {
                ps.setString(1, person.getName());
                ps.setString(2, person.getSurname());
                ps.setInt(3, person.getAge());
            }
            ps.executeUpdate();
        }
    }

    public static void executePreparedStatement(String sql, Address address) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            if (sql.toUpperCase().matches(".*UPDATE.*")) {
                ps.setString(1, address.getStreet());
                ps.setInt(2, address.getHouse());
                ps.setInt(3, address.getId());
            } else {
                ps.setString(1, address.getStreet());
                ps.setInt(2, address.getHouse());
            }
            ps.executeUpdate();
        }
    }

    public static void executeStatement(String sql) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }
}