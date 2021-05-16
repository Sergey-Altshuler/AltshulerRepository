package projectPackage.generatorTest;

import org.junit.Test;
import projectPackage.generator.PeopleGenerator;

import static org.junit.Assert.assertNotNull;

public class PeopleGeneratorTest {
    @Test
    public void generatePerson(){
        assertNotNull(PeopleGenerator.generatePerson());
    }
}
