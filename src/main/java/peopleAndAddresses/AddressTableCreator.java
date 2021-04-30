package peopleAndAddresses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressTableCreator implements TableCreatable {
    @Override
    public void createTable() {
        try (
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        Statement statement = connection.createStatement())
        {
            String SQL = "CREATE table if not exists ADDRESS (id int auto_increment, street varchar(25), house int, primary key (id))";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
