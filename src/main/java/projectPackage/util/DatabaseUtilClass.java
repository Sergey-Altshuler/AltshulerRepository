package projectPackage.util;

import projectPackage.generator.AddressGenerator;
import projectPackage.generator.PeopleGenerator;
import projectPackage.dao.DAOAddress;
import projectPackage.dao.DAOAddressClass;
import projectPackage.dao.DAOPeople;
import projectPackage.dao.DAOPeopleClass;
import projectPackage.model.Address;
import projectPackage.model.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtilClass {
    private final static DAOAddress addressDao = new DAOAddressClass();
    private final static DAOPeople personDAO = new DAOPeopleClass();

    public void addAddresses(int num) throws SQLException {
        List<Address> addressList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            addressList.add(AddressGenerator.generateAddress());
        }
        addressDao.saveAll(addressList);
    }

    public void addPeople(int num) throws SQLException {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            personList.add(PeopleGenerator.generatePerson());
        }
        personDAO.saveAll(personList);
    }


    public void increaseAgeOfLastPeople(int countOfPeople, int numOfYears) throws SQLException {
        List<Person> personList = personDAO.getAll();
        for (int i = 0; i < countOfPeople; i++) {
            Person person = personDAO.increaseAge(personList.get(personList.size() - (i + 1)), numOfYears);
            personDAO.update(person);
        }
    }

    public void increaseHouseOfLastAddresses(int countOfAddresses, int numOfHouses) throws SQLException {
        List<Address> addressList = addressDao.getAll();
        for (int i = 0; i < countOfAddresses; i++) {
            Address address = addressDao.increaseHouse(addressList.get(addressList.size() - (i + 1)), numOfHouses);
            addressDao.update(address);
        }
    }

    public void deleteAddress(int num) throws SQLException {
        List<Address> addressList = addressDao.getAll();
        addressDao.delete(addressList.get(num - 1).getId());
    }

    public void deletePerson(int num) throws SQLException {
        List<Person> personList = personDAO.getAll();
        personDAO.delete(personList.get(num - 1).getId());
    }
    public void finishWorkWithEntities(){
        HibernateUtil.close();
    }
}