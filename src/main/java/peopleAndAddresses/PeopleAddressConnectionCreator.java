package peopleAndAddresses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PeopleAddressConnectionCreator implements TableCreatable {
    @Override
    public void createTable() {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE table if not exists PEOPLEWITHADDRESS (id int primary key auto_increment, personIndex int, addressIndex int, foreign key(personIndex) references PEOPLE(id) ON DELETE CASCADE, foreign key (addressIndex) references ADDRESS(id) ON DELETE CASCADE)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
