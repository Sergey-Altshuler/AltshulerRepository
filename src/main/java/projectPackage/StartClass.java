package projectPackage;

import projectPackage.util.DatabaseUtilClass;

import java.sql.SQLException;

public class StartClass {
    public static void main(String[] args) {
        try {
            DatabaseUtilClass databaseUtilClass = new DatabaseUtilClass();
            databaseUtilClass.addAddresses(5);
            databaseUtilClass.addPeople(5);
            databaseUtilClass.increaseAgeOfLastPeople(2, 2);
            databaseUtilClass.increaseHouseOfLastAddresses(2, 1);
            databaseUtilClass.deleteAddress(1);
            databaseUtilClass.deletePerson(1);
            databaseUtilClass.finishWorkWithEntities();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}