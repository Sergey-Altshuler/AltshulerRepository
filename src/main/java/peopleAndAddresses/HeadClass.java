package peopleAndAddresses;

import java.sql.SQLException;

public class HeadClass {
    final static DAO<Address> addressDao = new DAOAddressClass();
    final static DAO<Person> personDAO = new DAOPeopleClass();

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        TableCreatable tableCreatable = new AddressTableCreator();
        tableCreatable.createTable();
        tableCreatable = new PeopleTableCreator();
        tableCreatable.createTable(); // создание таблиц Address и People
        executeFirstTask(); //первый пункт
        executeSecondTask(); // второй пункт
        executeThirdTask(); // третий пункт
    }

    public static void executeFirstTask() { //добавить 5 адресов и 5 человек
        try {
            addressDao.save(new Address(1, "Skriganova", 9));
            addressDao.save(new Address(2, "Skriganova", 14));
            addressDao.save(new Address(3, "Kiseleva", 61));
            addressDao.save(new Address(4, "Krasnaya", 12));
            addressDao.save(new Address(5, "Gikalo", 3));
            personDAO.save(new Person(1, "Sergey", "Altshuler", 27, 2));
            personDAO.save(new Person(2, "Dmitriy", "Perepechko", 24, 2));
            personDAO.save(new Person(3, "Egor", "Silvanovich", 20, 4));
            personDAO.save(new Person(4, "Matvey", "Vetcher", 29, 4));
            personDAO.save(new Person(5, "Mikhail", "Lapanik", 27, 3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeSecondTask() { // увеличить возраст на 2 у 2х последних людей и номер дома на 1 у 2х последних адресов
        try {
            Address address = addressDao.get(4);
            address.setHouse(address.getHouse() + 1);
            addressDao.update(address);
            address = addressDao.get(5);
            address.setHouse(address.getHouse() + 1);
            addressDao.update(address);
            Person person = personDAO.get(4);
            person.setAge(person.getAge() + 2);
            personDAO.update(person);
            person = personDAO.get(5);
            person.setAge(person.getAge() + 2);
            personDAO.update(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeThirdTask() { // удалить первый адрес и первого человека
        try {
            addressDao.delete(1);
            personDAO.delete(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
