package peopleAndAddresses;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PeopleTableCreator implements TableCreatable {
    @Override
    public void createTable() {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE table if not exists PEOPLE (id int auto_increment, name varchar(25), surname varchar(25), age int, addressNum int, primary key (id), foreign key(addressNum) references ADDRESS(id) ON UPDATE CASCADE ON DELETE SET NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
