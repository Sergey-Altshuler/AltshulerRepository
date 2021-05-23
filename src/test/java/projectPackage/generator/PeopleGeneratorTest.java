package projectPackage.generator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PeopleGeneratorTest {
    @Test
    public void generatePerson(){
        assertNotNull(PeopleGenerator.generatePerson());
    }
}
