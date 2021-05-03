package peopleAndAddresses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtilClass {
    private final static DAOAddress addressDao = new DAOAddressClass();
    private final static DAOPeople personDAO = new DAOPeopleClass();

    public void initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTwoTables() {
        TableCreatable tableCreatable = new AddressTableCreator();
        tableCreatable.createTable();
        tableCreatable = new PeopleTableCreator();
        tableCreatable.createTable();
    }

    public void addFiveAddressesAndPeople() {
        try {
            addressDao.save(new Address("Skriganova", 9));
            addressDao.save(new Address("Skriganova", 14));
            addressDao.save(new Address("Kiseleva", 61));
            addressDao.save(new Address("Krasnaya", 12));
            addressDao.save(new Address("Gikalo", 3));
            personDAO.save(new Person("Sergey", "Altshuler", 27));
            personDAO.save(new Person("Dmitriy", "Perepechko", 24));
            personDAO.save(new Person("Egor", "Silvanovich", 20));
            personDAO.save(new Person("Matvey", "Vetcher", 29));
            personDAO.save(new Person("Mikhail", "Lapanik", 27));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void increaseAgeOfTwoLastPeople(int numOfYears) {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            ResultSet rsPeople = statement.executeQuery("SELECT MAX(id) FROM PEOPLE");
            rsPeople.next();
            int peopleNumOfRows = rsPeople.getInt(1);
            Person person = personDAO.increaseAge(personDAO.get(peopleNumOfRows - 1), numOfYears);
            personDAO.update(person);
            person = personDAO.increaseAge(personDAO.get(peopleNumOfRows), numOfYears);
            personDAO.update(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void increaseHouseOfTwoLastAddresses(int number) {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            ResultSet rsAddress = statement.executeQuery("SELECT MAX(id) FROM ADDRESS");
            rsAddress.next();
            int addressNumOfRows = rsAddress.getInt(1);
            Address address = addressDao.increaseHouse(addressDao.get(addressNumOfRows - 1), number);
            addressDao.update(address);
            address = addressDao.increaseHouse(addressDao.get(addressNumOfRows), number);
            addressDao.update(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFirstAddress() {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            ResultSet rsAddress = statement.executeQuery("SELECT MIN(id) FROM ADDRESS");
            rsAddress.next();
            int addressMin = rsAddress.getInt(1);
            addressDao.delete(addressMin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFirstPerson() {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            ResultSet rsPeople = statement.executeQuery("SELECT MIN(id) FROM PEOPLE");
            rsPeople.next();
            int peopleMin = rsPeople.getInt(1);
            personDAO.delete(peopleMin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}