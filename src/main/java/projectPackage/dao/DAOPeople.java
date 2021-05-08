package projectPackage.dao;

import projectPackage.model.Person;
import projectPackage.util.TransactionUtilClass;
import java.util.List;

public interface DAOPeople extends DAO<Person> {
    default Person increaseAge(Person person, int num) {
        person.setAge(person.getAge() + num);
        return person;
    }

    default void saveAll(List<Person> people) {
        TransactionUtilClass.executeTransaction("INSERT INTO PEOPLE (name, surname, age) VALUES(?,?,?)", people, false);
    }
}
