package projectPackage.util;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import projectPackage.model.Address;
import projectPackage.model.Person;

public class SessionUtil {
    @Getter
    private static SessionFactory sessionFactory;

    private SessionUtil() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Address.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialize() {
        if (SessionUtil.getSessionFactory() == null) {
            new SessionUtil();
        }
    }

    public static Session getSession() {
        initialize();
        return sessionFactory.openSession();
    }

    public static void stopSessionFactory() {
        sessionFactory.close();
    }
}
