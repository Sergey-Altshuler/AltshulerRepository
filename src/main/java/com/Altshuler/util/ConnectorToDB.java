package com.Altshuler.util;


import com.Altshuler.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ConnectorToDB {
    private static final EntityManager em = HibernateUtil.getEntityManager();

    public static void saveList(List<Student> saved) {
        em.getTransaction().begin();
        for (Student student : saved) {
            em.persist(student);
        }
        em.getTransaction().commit();
    }

    public static List<Student> getStudents() {
        Query query = em.createQuery("from student");
        return query.getResultList();
    }
}
