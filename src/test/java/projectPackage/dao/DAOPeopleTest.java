package projectPackage.dao;

import org.junit.Test;
import projectPackage.model.Person;

import static org.junit.Assert.assertEquals;

public class DAOPeopleTest {
    @Test
    public void increaseAge() {
        Person person = Person.builder().age(18).build();
        DAOPeople daoPeople = new DAOPeopleImpl();
        Person result = daoPeople.increaseAge(person,10);
        assertEquals(result.getAge(),28);
    }
}
