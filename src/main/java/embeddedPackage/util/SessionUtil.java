package embeddedPackage.util;

import embeddedPackage.pojos.*;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    @Getter
    private static SessionFactory sessionFactory;

    private SessionUtil() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(HomeTask.class);
            configuration.addAnnotatedClass(Task.class);
            configuration.addAnnotatedClass(WorkTask.class);
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
