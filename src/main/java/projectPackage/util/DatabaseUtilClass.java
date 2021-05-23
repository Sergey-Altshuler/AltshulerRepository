package projectPackage.util;

import projectPackage.dao.DAOAddress;
import projectPackage.dao.DAOAddressImpl;
import projectPackage.dao.DAOPeople;
import projectPackage.dao.DAOPeopleImpl;
import projectPackage.generator.AddressGenerator;
import projectPackage.generator.PeopleGenerator;
import projectPackage.model.Address;
import projectPackage.model.Person;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatabaseUtilClass {
    private final static DAOAddress addressDAO = new DAOAddressImpl();
    private final static DAOPeople personDAO = new DAOPeopleImpl();

    public void addAddresses(int num) throws SQLException {
        addressDAO.saveAll(Stream.generate(AddressGenerator::generateAddress).limit(num).collect(Collectors.toList()));
    }

    public void addPeople(int num) throws SQLException {
        personDAO.saveAll(Stream.generate(PeopleGenerator::generatePerson).limit(num).collect(Collectors.toList()));
    }

    public void joinAddressesToPeople() throws SQLException {
        List<Person> personList = personDAO.getAll(Person.class);
        List<Address> addressList = addressDAO.getAll(Address.class);
        for (Address address : addressList) {
            if (address.getPerson() == null) {
                int num = (new Random().nextInt(personList.size()));
                Person person = personList.get(num);
                address.setPerson(person);
                Set<Address> addressSet = person.getAddresses();
                if (addressSet != null) {
                    addressSet.add(address);
                    person.setAddresses(addressSet);
                } else {
                    Set<Address> set = new HashSet<>();
                    set.add(address);
                    person.setAddresses(set);
                }
                addressDAO.update(address);
                personDAO.update(person);
            }
        }
    }

    public void increaseAgeOfLastPeople(int countOfPeople, int numOfYears) throws SQLException {
        List<Person> personList = personDAO.getAll(Person.class);
        for (int i = 0; i < countOfPeople; i++) {
            Person person = personDAO.increaseAge(personList.get(personList.size() - (i + 1)), numOfYears);
            personDAO.update(person);
        }
    }

    public void increaseHouseOfLastAddresses(int countOfAddresses, int numOfHouses) throws SQLException {
        List<Address> addressList = addressDAO.getAll(Address.class);
        for (int i = 0; i < countOfAddresses; i++) {
            Address address = addressDAO.increaseHouse(addressList.get(addressList.size() - (i + 1)), numOfHouses);
            addressDAO.update(address);
        }
    }

    public void deleteAddress(int num) throws SQLException {
        List<Address> addressList = addressDAO.getAll(Address.class);
        addressDAO.delete(Address.class, addressList.get(num - 1).getId());
    }

    public void deletePerson(int num) throws SQLException {
        List<Person> personList = personDAO.getAll(Person.class);
        personDAO.delete(Person.class, personList.get(num - 1).getId());
    }

    public void displayAll() throws SQLException {
        List<Person> personList = personDAO.getAll(Person.class);
        for (Person person : personList) {
            System.out.println(person);
        }
        List<Address> addressList = addressDAO.getAll(Address.class);
        for (Address address : addressList) {
            System.out.println(address);
        }
    }

    public void closeSessionFactory() throws SQLException {
        SessionUtil.stopSessionFactory();
    }
}