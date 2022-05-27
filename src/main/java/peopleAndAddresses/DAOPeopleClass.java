package peopleAndAddresses;

import java.sql.*;

public class DAOPeopleClass implements DAOPeople {
    @Override
    public void save(Person person) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO PEOPLE (name, surname, age) VALUES(?,?,?)")) {
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setInt(3, person.getAge());
            ps.executeUpdate();
        }
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
        try (Connection connection = DriverManagerUtilClass.get();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PEOPLE SET NAME=?,SURNAME=?, AGE=? WHERE id=?")) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setInt(4, person.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM PEOPLE WHERE id=" + id);
        }
    }
}
