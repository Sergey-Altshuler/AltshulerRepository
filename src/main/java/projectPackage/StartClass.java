package projectPackage;

import projectPackage.model.Address;
import projectPackage.util.DatabaseUtilClass;

public class StartClass {
    public static void main(String[] args) {
        DatabaseUtilClass databaseUtilClass = new DatabaseUtilClass();
        databaseUtilClass.initialize();
        databaseUtilClass.createTwoTables();
        databaseUtilClass.addFiveAddressesAndPeople();
        databaseUtilClass.increaseAgeOfTwoLastPeople(2);
        databaseUtilClass.increaseHouseOfTwoLastAddresses(1);
        databaseUtilClass.deleteFirstAddress();
        databaseUtilClass.deleteFirstPerson();
        databaseUtilClass.useCallableStatement(Address.builder().id(5).street("Landera").house(23).build());
    }
}