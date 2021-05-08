package projectPackage.util;

import projectPackage.dao.DAOAddress;
import projectPackage.dao.DAOAddressClass;
import projectPackage.dao.DAOPeople;
import projectPackage.dao.DAOPeopleClass;
import projectPackage.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        try {
            TableCreatable tableCreatable = new AddressTableCreator();
            tableCreatable.createTable();
            tableCreatable = new PeopleTableCreator();
            tableCreatable.createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFiveAddressesAndPeople() {
        List<Person> personList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();
        personList.add(Person.builder().surname("Altshuler").name("Sergey").age(27).build());
        personList.add(Person.builder().surname("Perpechko").name("Dmitry").age(24).build());
        personList.add(Person.builder().surname("Silvanovich").name("Egor").age(20).build());
        personList.add(Person.builder().surname("Vetcher").name("Matvey").age(29).build());
        personList.add(Person.builder().surname("Lapanik").name("Mikhail").age(27).build());
        personDAO.saveAll(personList);
        addressList.add(Address.builder().street("Skriganova").house(9).build());
        addressList.add(Address.builder().street("Skriganova").house(14).build());
        addressList.add(Address.builder().street("Kiseleva").house(61).build());
        addressList.add(Address.builder().street("Krasnaya").house(12).build());
        addressList.add(Address.builder().street("Gikalo").house(3).build());
        addressDao.saveAll(addressList);
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

    public void useCallableStatement(Address address) {
        try (Connection connection = DriverManagerUtilClass.get();
             CallableStatement cs = connection.prepareCall("{call updateAddress(?,?,?)}")) {
            cs.setInt(1, address.getId());
            cs.setString(2, address.getStreet());
            cs.setInt(3, address.getHouse());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}