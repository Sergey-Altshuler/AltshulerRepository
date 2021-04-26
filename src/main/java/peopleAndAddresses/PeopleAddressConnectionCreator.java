package peopleAndAddresses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PeopleAddressConnectionCreator implements TableCreatable{
    @Override
    public void createTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, userName, password);
            statement = connection.createStatement();
            String SQL = "CREATE table if not exists PEOPLEWITHADDRESS (id int primary key auto_increment, personIndex int, addressIndex int, foreign key(personIndex) references PEOPLE(id) ON DELETE CASCADE, foreign key (addressIndex) references ADDRESS(id) ON DELETE CASCADE)";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
