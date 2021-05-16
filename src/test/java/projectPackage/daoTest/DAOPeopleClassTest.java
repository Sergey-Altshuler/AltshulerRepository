package projectPackage.daoTest;

import org.junit.Test;
import projectPackage.dao.DAOPeople;
import projectPackage.dao.DAOPeopleClass;
import projectPackage.model.Person;
import projectPackage.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DAOPeopleClassTest {
    private static final EntityManager em = HibernateUtil.getEntityManager();
    private static final DAOPeople daoPeople = new DAOPeopleClass();

    @Test
    public void save() {
        Person person = Person.builder().name("Sergey").surname("Altshuler").age(27).build();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        Person compared = em.find(Person.class, person.getId());
        assertEquals(compared, person);
    }

    @Test
    public void get() throws SQLException {
        Person person = daoPeople.get(5);
        assertEquals(5,person.getId());
    }

    @Test
    public void update() throws SQLException {
        Person person = Person.builder().id(4).name("Sergey").surname("Altshuler").age(27).build();
        daoPeople.update(person);
        Person compared = daoPeople.get(4);
        assertEquals(person, compared);
    }

    @Test
    public void delete() throws SQLException {
        daoPeople.delete(3);
        Person person = em.find(Person.class, 3);
        assertNull(person);
    }

    @Test
    public void saveAll() throws SQLException {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().name("Matvei").surname("Vetcher").age(25).build());
        personList.add(Person.builder().name("Oksana").surname("Peregud").age(32).build());
        daoPeople.saveAll(personList);
        List<Person> result = daoPeople.getAll();
        assertTrue(result.containsAll(personList));
    }

    @Test
    public void getAll() throws SQLException {
        List<Person> personList = daoPeople.getAll();
        List<Person> compared = em.createNamedQuery("Person.getAll", Person.class).getResultList();
        assertTrue(personList.containsAll(compared));
    }
}
