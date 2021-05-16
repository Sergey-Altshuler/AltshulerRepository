package projectPackage.daoTest;

import org.junit.Test;
import projectPackage.dao.DAOAddress;
import projectPackage.dao.DAOAddressClass;
import projectPackage.model.Address;

import static org.junit.Assert.assertEquals;

public class DAOAddressTest {
    @Test
    public void increaseHouse(){
        Address address= Address.builder().house(4).build();
        DAOAddress daoAddress = new DAOAddressClass();
        Address result=daoAddress.increaseHouse(address,2);
        assertEquals(result.getHouse(), 6);
    }
}
