package peopleAndAddresses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PeopleTableCreator implements TableCreatable {
    @Override
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        Statement statement = connection.createStatement())
        {
            String SQL = "CREATE table if not exists PEOPLE (id int auto_increment, name varchar(25), surname varchar(25), age int, primary key (id))";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
