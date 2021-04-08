package personTask;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonNameComparatorTest {
    @Test
    public void compare(){
        Person person1=Person.createPerson();
        Person person2=Person.createPerson();
        PersonNameComparator p = new PersonNameComparator();
        assertEquals(person1.getName().compareTo(person2.getName()),p.compare(person1,person2));
    }
}
