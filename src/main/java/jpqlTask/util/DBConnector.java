package jpqlTask.util;

import jpqlTask.pojos.Salesman;
import jpqlTask.pojos.Shop;
import org.hibernate.Session;
import org.hibernate.query.Query;


import javax.persistence.Entity;
import javax.persistence.EntityManager;


import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DBConnector {
    private static final EntityManager em = HibernateUtil.getEntityManager();
    private static final Session session = em.unwrap(Session.class);

    public static void saveList(List<?> saved) {
        em.getTransaction().begin();
        for (Object obj : saved) {
            em.persist(obj);
        }
        em.getTransaction().commit();
    }

    public static void displayAll(Class<?> displayed) {
        String annotationName = displayed.getAnnotation(Entity.class).name();

        Query query = session.createQuery("from " + annotationName);
        query.list().forEach(System.out::println);
    }

    public static void displaySalesmenNames(double income) {
        Query query = session.createQuery("select a from salesman a join a.shop b  where b.income>:income", Salesman.class);
        List<Salesman> resultList = query.setParameter("income", income).getResultList();
        if (resultList.size() > 0) {
            resultList.forEach((salesman) -> {
                System.out.println("ФИО:" + salesman.getSurname() + " " + salesman.getName() + " " + salesman.getNameByFather());
            });
        } else System.out.println("Нет таких продавцов!");
    }

    public static void displaySalesmenData(Date date) {
        Query query = session.createQuery("select a from salesman a join a.shop b  where b.date<:date", Salesman.class);
        List<Salesman> result = query.setParameter("date", date).getResultList();
        if (result.size() > 0) {
            result.forEach((salesman) -> {
                System.out.println("Фамилия и зарплата: " + salesman.getSurname() + " " + salesman.getSalary());
            });
        } else System.out.println("Нет таких продавцов!");
    }

    public static void displayShopsWithSpecificSalesmen(List<String> surnames) {
        Set<Shop> shopSet = new HashSet<>();
        for (String surname : surnames) {
            Query query = session.createQuery("select a from shop a where exists (select b from salesman b where b.surname=:surname and b.shop=a )", Shop.class);
            List<Shop> shopList = query.setParameter("surname", surname).getResultList();
            shopSet.addAll(shopList);
        }
            if (shopSet.size() > 0) {
                shopSet.forEach(shop -> {
                    System.out.println("Имя и доход магазина: " + shop.getName() + " " + shop.getIncome());
                });
            } else System.out.println("Нет таких магазинов!");
        }
    }

