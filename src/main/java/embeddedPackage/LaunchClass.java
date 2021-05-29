package embeddedPackage;

import embeddedPackage.pojos.Address;
import embeddedPackage.pojos.HomeTask;
import embeddedPackage.pojos.Task;
import embeddedPackage.pojos.WorkTask;
import embeddedPackage.util.SessionUtil;
import org.hibernate.Session;

public class LaunchClass {
    public static void main(String[] args) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        Task task = Task.builder().name("Task1").description("Java Task").build();
        session.saveOrUpdate(task);
        Address address = Address.builder().city("Kiev").street("Landera").build();
        HomeTask homeTask =  HomeTask.builder().address(address).name("HomeTask").build();
        session.saveOrUpdate(homeTask);
        WorkTask workTask =  WorkTask.builder().cost(250).description("ORM Task").name("WorkTask").build();
        session.saveOrUpdate(workTask);
        session.getTransaction().commit();
        SessionUtil.stopSessionFactory();
    }
}
