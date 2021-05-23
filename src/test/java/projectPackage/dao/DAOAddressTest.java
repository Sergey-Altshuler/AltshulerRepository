package projectPackage.dao;

import org.junit.Test;
import projectPackage.model.Address;

import static org.junit.Assert.assertEquals;

public class DAOAddressTest {
    @Test
    public void increaseHouse() {
        Address address = Address.builder().house(4).build();
        DAOAddress daoAddress = new DAOAddressImpl();
        Address result = daoAddress.increaseHouse(address, 2);
        assertEquals(result.getHouse(), 6);
    }
}
