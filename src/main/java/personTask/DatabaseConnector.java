package personTask;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector extends Connectable {

    @Override
    public List<Person> readFromSource() {
        prepareForUseDatabase();
        List<Person> listFromDatabase = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM PEOPLE");
            while (result.next()) {
                Person person = new Person(result.getInt(1), result.getString(2),
                        result.getString(3), result.getInt(4), result.getDouble(5),
                        result.getString(6), result.getString(7), result.getDate(8),
                        result.getTimestamp(9), result.getTime(10), result.getString(11));
                listFromDatabase.add(person);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            isNotWrittenOrRead = true;
            e.printStackTrace();
        }
        return listFromDatabase;
    }

    @Override
    public void writeToSource(List<Person> personList) {
        prepareForUseDatabase();
        try {
            String sqlUpdate = "CREATE TABLE IF NOT EXISTS PEOPLE(id INTEGER, name varchar(25), surname varchar(25), age int, salary dec, passport varchar(10), address varchar(50), dateOfBirthday date, dateTimeCreate timestamp, timeToLunch time, letter varchar(100))";
            statement.executeUpdate(sqlUpdate);
            sqlUpdate = "DELETE FROM PEOPLE";
            statement.executeUpdate(sqlUpdate);
            String insertSQL = "INSERT INTO PEOPLE(id, name, surname, age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            for (Person person : personList) {
                preparedStatement.setInt(1, person.getId());
                preparedStatement.setString(2, person.getName());
                preparedStatement.setString(3, person.getSurname());
                preparedStatement.setInt(4, person.getAge());
                preparedStatement.setDouble(5, person.getSalary());
                preparedStatement.setString(6, person.getPassport());
                preparedStatement.setString(7, person.getAddress());
                preparedStatement.setDate(8, person.getDateOfBirthday());
                preparedStatement.setTimestamp(9, person.getDateTimeCreate());
                preparedStatement.setTime(10, person.getTimeToLunch());
                preparedStatement.setString(11, person.getLetter());
                preparedStatement.executeUpdate();
            }
            statement.close();
            connection.close();
        } catch (SQLException | NullPointerException e) {
            isNotWrittenOrRead = true;
            e.printStackTrace();
        }
    }

    @Override
    public void prepareForUseDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/people?serverTimezone=CST&useSSL=false", "root", "root");
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            isNotWrittenOrRead = true;
            e.printStackTrace();
        }
    }
}
