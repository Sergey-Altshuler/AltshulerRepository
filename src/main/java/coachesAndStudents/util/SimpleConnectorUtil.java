package coachesAndStudents.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SimpleConnectorUtil {
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost/studentsAndCoaches";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
