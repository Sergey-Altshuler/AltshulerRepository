package projectPackage.generatorTest;

import org.junit.Test;
import projectPackage.generator.AddressGenerator;

import static org.junit.Assert.assertNotNull;

public class AddressGeneratorTest {
    @Test
    public void generateAddress(){
        assertNotNull(AddressGenerator.generateAddress());
    }
}
