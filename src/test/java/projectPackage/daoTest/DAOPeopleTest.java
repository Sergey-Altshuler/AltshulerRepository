package projectPackage.daoTest;

import org.junit.Test;
import projectPackage.dao.DAOPeople;
import projectPackage.dao.DAOPeopleClass;
import projectPackage.model.Person;

import static org.junit.Assert.assertEquals;

public class DAOPeopleTest {
    @Test
    public void increaseAge() {
        Person person = Person.builder().age(18).build();
        DAOPeople daoPeople = new DAOPeopleClass();
        Person result = daoPeople.increaseAge(person,10);
        assertEquals(result.getAge(),28);
    }
}
