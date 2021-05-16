package projectPackage.dao;

import projectPackage.model.Person;
import projectPackage.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DAOPeopleClass implements DAOPeople {
    private static final EntityManager em;

    static {
        em = HibernateUtil.getEntityManager();
    }

    @Override
    public void save(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    @Override
    public Person get(int id) {
        Person person = em.find(Person.class, id);
        em.detach(person);
        return person;
    }

    @Override
    public void update(Person person) {
        Person updated = get(person.getId());
        em.detach(updated);
        updated.setAge(person.getAge());
        updated.setSurname(person.getSurname());
        updated.setName(person.getName());
        em.getTransaction().begin();
        em.merge(updated);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
    }

    public void saveAll(List<Person> people) {
        em.getTransaction().begin();
        for (Person person : people) {
            em.persist(person);
        }
        em.getTransaction().commit();
    }

    public List<Person> getAll() {
        return em.createNamedQuery("Person.getAll", Person.class).getResultList();
    }
}