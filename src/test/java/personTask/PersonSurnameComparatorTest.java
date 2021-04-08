package personTask;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonSurnameComparatorTest {
    @Test
    public void compare(){
        Person person1=Person.createPerson();
        Person person2=Person.createPerson();
        PersonSurnameComparator p = new PersonSurnameComparator();
        assertEquals(person1.getSurname().compareTo(person2.getSurname()),p.compare(person1,person2));
    }
}
