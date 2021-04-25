package peopleAndAddresses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressTableCreator implements TableCreatable {
    @Override
    public void createTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, userName, password);
            statement = connection.createStatement();
            String SQL = "CREATE table if not exists ADDRESS (id int auto_increment, street varchar(25), house int, primary key (id))";
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
