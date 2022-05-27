package peopleAndAddresses;

public class HeadClass {
    public static void main(String[] args) {
        DatabaseUtilClass databaseUtilClass = new DatabaseUtilClass();
        databaseUtilClass.initialize();
        databaseUtilClass.createTwoTables();
        databaseUtilClass.addFiveAddressesAndPeople();
        databaseUtilClass.increaseAgeOfTwoLastPeople(2);
        databaseUtilClass.increaseHouseOfTwoLastAddresses(1);
        databaseUtilClass.deleteFirstAddress();
        databaseUtilClass.deleteFirstPerson();
    }
}
