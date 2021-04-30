package peopleAndAddresses;

import java.sql.*;

public class DAOPeopleClass implements DAOPeople{
    @Override
    public void save(Person person) throws SQLException {
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        String sql = "INSERT INTO PEOPLE (id, name, surname, age, addressNum) VALUES(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,person.getId());
        ps.setString(2, person.getName());
        ps.setString(3, person.getSurname());
        ps.setInt(4, person.getAge());
        ps.setInt(5,person.getAddressNum());
        ps.executeUpdate();
        connection.close();
        ps.close();
    }

    @Override
    public Person get(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        String sql = "SELECT * FROM PEOPLE WHERE id=" + id;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        int index= rs.getInt(1);
        String name = rs.getString(2);
        String surname = rs.getString(3);
        int age = rs.getInt(4);
        int addressNum = rs.getInt(5);
        connection.close();
        statement.close();
        return new Person(index, name, surname, age, addressNum);
    }

    @Override
    public void update(Person person) throws SQLException {
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        String sql = "UPDATE PEOPLE SET NAME=?,SURNAME=?, AGE=?, ADDRESSNUM=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,person.getName());
        preparedStatement.setString(2, person.getSurname());
        preparedStatement.setInt(3, person.getAge());
        preparedStatement.setInt(4,person.getAddressNum());
        preparedStatement.setInt(5, person.getId());
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        String sql = "DELETE FROM PEOPLE WHERE id=" + id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
        statement.close();
    }
}
