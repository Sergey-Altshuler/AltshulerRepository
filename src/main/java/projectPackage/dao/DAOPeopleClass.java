package projectPackage.dao;

import projectPackage.model.Person;
import projectPackage.util.DatabaseStatementsUtilClass;
import projectPackage.util.DriverManagerUtilClass;

import java.sql.*;

public class DAOPeopleClass implements DAOPeople {
    @Override
    public void save(Person person) throws SQLException {
        DatabaseStatementsUtilClass.executePreparedStatement("INSERT INTO PEOPLE(name,surname,age) VALUES(?,?,?)", person);
    }

    @Override
    public Person get(int id) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM PEOPLE WHERE id=" + id);
            rs.next();
            int index = rs.getInt(1);
            String name = rs.getString(2);
            String surname = rs.getString(3);
            int age = rs.getInt(4);
            return new Person(index, name, surname, age);
        }
    }

    @Override
    public void update(Person person) throws SQLException {
        DatabaseStatementsUtilClass.executePreparedStatement("UPDATE PEOPLE SET NAME=?, SURNAME=?, AGE=? WHERE id=?", person);
    }

    @Override
    public void delete(int id) throws SQLException {
        DatabaseStatementsUtilClass.executeStatement("DELETE FROM PEOPLE WHERE id=" + id);
    }
}