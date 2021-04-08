package personTask;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void createPerson(){
      Person person = Person.createPerson();
      assertNotNull(person);
      assertTrue(Person.getNames().contains(person.getName()));
      assertTrue(Person.getSurnames().contains(person.getSurname()));
      assertTrue(person.getAge()>=15&&person.getAge()<=30);
      assertTrue(person.toString().startsWith("Name:"));
    }
    @Test
    public void equals(){
        assertNotEquals(Person.createPerson(), new Object());
    }
    @Test
    public void hashcode(){
        Person person=Person.createPerson();
        assertEquals(person.hashCode(),
                 1+ 31 * person.getAge() + 21 * person.getName().hashCode() + person.getSurname().hashCode());
    }
}
