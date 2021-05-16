package projectPackage.dao;

import projectPackage.model.Address;
import projectPackage.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DAOAddressClass implements DAOAddress {
    private static final EntityManager em;

    static {
        em = HibernateUtil.getEntityManager();
    }

    @Override
    public void save(Address address) {
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();

    }

    @Override
    public Address get(int id) {
        Address address = em.find(Address.class, id);
        em.detach(address);
        return address;
    }

    @Override
    public void update(Address address) {
        Address updated = get(address.getId());
        em.detach(updated);
        updated.setStreet(address.getStreet());
        updated.setHouse(address.getHouse());
        em.getTransaction().begin();
        em.merge(updated);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Address address = em.find(Address.class, id);
        if (address != null) {
            em.remove(address);
        }
        em.getTransaction().commit();
    }

    public void saveAll(List<Address> addresses) {
        em.getTransaction().begin();
        for (Address address : addresses) {
            em.persist(address);
        }
        em.getTransaction().commit();
    }

    public List<Address> getAll() {
        return em.createNamedQuery("Address.getAll", Address.class).getResultList();
    }
}
