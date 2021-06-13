package coachesAndStudents.util;

import org.hibernate.Session;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class DBConnectorUtil {
    private static final Session session = SessionUtil.getSession();
    private static Connection connection;

    static {
        try {
            connection = SimpleConnectorUtil.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void saveList(List<?> saved) {
        session.getTransaction().begin();
        for (Object obj : saved) {
            session.save(obj);
        }
        session.getTransaction().commit();
    }

    public static void saveData() {
        saveList(GeneratorEntities.getCoachList());
        saveList(GeneratorEntities.getCourseList());
        saveList(GeneratorEntities.getDiaryList());
        saveList(GeneratorEntities.getTaskList());
        saveList(GeneratorEntities.getStudentList());
    }

    public static void updateData(int levelOfIsolation) {
       // GeneratorEntities.clearAll();
        GeneratorEntities.generate(100);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        threadPoolExecutor.execute(() -> {
            long start = System.currentTimeMillis();
            try {
                updateList(GeneratorEntities.getCoachList(), levelOfIsolation);
                updateList(GeneratorEntities.getCourseList(), levelOfIsolation);
                updateList(GeneratorEntities.getDiaryList(), levelOfIsolation);
                updateList(GeneratorEntities.getTaskList(), levelOfIsolation);
                updateList(GeneratorEntities.getCourseList(), levelOfIsolation);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println("Level of isolation: " + getLevelOfIsolation(levelOfIsolation)+ " - " + (end - start) + " milliseconds");
        });
        threadPoolExecutor.shutdown();
    };

    private static void updateList(List<?> updated, int levelOfIsolation) throws SQLException {
        connection.setTransactionIsolation(levelOfIsolation);
        session.sessionWithOptions().connection(connection);
        session.getTransaction().begin();
        for (Object obj : updated) {
            session.saveOrUpdate(obj);
        }
        session.getTransaction().commit();
    }
    private static String getLevelOfIsolation(int identifier){
        switch (identifier){
            case 1: return "READ_UNCOMMITTED";
            case 2: return "READ_COMMITTED";
            case 4: return  "REPEATABLE_READ";
            case 8: return "SERIALIZABLE";
            default: return "NONE";
        }
    }
    public static void finish() throws SQLException {
        connection.close();
    }
}
