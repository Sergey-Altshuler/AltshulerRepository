package coachesAndStudents;

import coachesAndStudents.util.DBConnectorUtil;
import coachesAndStudents.util.GeneratorEntities;
import coachesAndStudents.util.SessionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {

        try {
            GeneratorEntities.generate(100);
            DBConnectorUtil.saveData();
            DBConnectorUtil.updateData(Connection.TRANSACTION_SERIALIZABLE);
            DBConnectorUtil.updateData(Connection.TRANSACTION_REPEATABLE_READ);
            DBConnectorUtil.updateData(Connection.TRANSACTION_READ_COMMITTED);
            DBConnectorUtil.updateData(Connection.TRANSACTION_READ_UNCOMMITTED);
            DBConnectorUtil.finish();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SessionUtil.stopSessionFactory();
        }
    }
}
