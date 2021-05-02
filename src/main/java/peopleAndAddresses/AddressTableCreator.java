package peopleAndAddresses;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressTableCreator implements TableCreatable {
    @Override
    public void createTable() {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE table if not exists ADDRESS (id int auto_increment, street varchar(25), house int, primary key (id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}