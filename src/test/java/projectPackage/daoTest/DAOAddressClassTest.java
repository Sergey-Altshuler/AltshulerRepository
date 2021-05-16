package projectPackage.daoTest;

import org.junit.Test;
import projectPackage.dao.DAOAddress;
import projectPackage.dao.DAOAddressClass;
import projectPackage.model.Address;
import projectPackage.util.HibernateUtil;

import javax.persistence.EntityManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DAOAddressClassTest {
    private static final EntityManager em = HibernateUtil.getEntityManager();
    private static final DAOAddress daoAddress = new DAOAddressClass();

    @Test
    public void save() {
        Address address = Address.builder().street("Landera").house(4).build();
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        Address compared = em.find(Address.class, address.getId());
        assertEquals(compared, address);
    }

    @Test
    public void get() throws SQLException {
        Address address = daoAddress.get(5);
        assertEquals(5, address.getId());
    }

    @Test
    public void update() throws SQLException {
        Address address = Address.builder().id(4).street("Krasnaya").house(34).build();
        daoAddress.update(address);
        Address updated = daoAddress.get(4);
        assertEquals(address, updated);
    }

    @Test
    public void delete() throws SQLException {
        daoAddress.delete(3);
        Address address = em.find(Address.class, 3);
        assertNull(address);
    }

    @Test
    public void saveAll() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        addresses.add(Address.builder().street("Pobedi").house(2).build());
        addresses.add(Address.builder().street("Pobedi").house(3).build());
        daoAddress.saveAll(addresses);
        List<Address> result = daoAddress.getAll();
        assertTrue(result.containsAll(addresses));
    }

    @Test
    public void getAll() throws SQLException {
        List<Address> addresses = daoAddress.getAll();
        List<Address> compared = em.createNamedQuery("Address.getAll", Address.class).getResultList();
        assertTrue(addresses.containsAll(compared));
    }
}
