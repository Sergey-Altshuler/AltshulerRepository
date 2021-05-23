package projectPackage.generator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AddressGeneratorTest {
    @Test
    public void generateAddress() {
        assertNotNull(AddressGenerator.generateAddress());
    }
}