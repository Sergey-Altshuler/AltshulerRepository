package projectPackage.util;

import projectPackage.model.Address;
import projectPackage.model.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransactionUtilClass {
    public static void executeTransaction(String sql, List<? extends Object> personList, boolean isAddress) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManagerUtilClass.get();
            preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            if (isAddress) {
                for (Object object : personList) {
                    Address address = (Address) object;
                    preparedStatement.setString(1, address.getStreet());
                    preparedStatement.setInt(2, address.getHouse());
                    preparedStatement.addBatch();
                }
            } else {
                for (Object object : personList) {
                    Person person = (Person) object;
                    preparedStatement.setString(1, person.getName());
                    preparedStatement.setString(2, person.getSurname());
                    preparedStatement.setInt(3, person.getAge());
                    preparedStatement.addBatch();
                }
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }
}