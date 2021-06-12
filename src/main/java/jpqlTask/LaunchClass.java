package jpqlTask;

import jpqlTask.pojos.Salesman;
import jpqlTask.pojos.Shop;
import jpqlTask.util.DBConnector;
import jpqlTask.util.EntityGenerator;
import jpqlTask.util.HibernateUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class LaunchClass {
    public static void main(String[] args) throws NoSuchFieldException {
        try {
            EntityGenerator.generateEntities();
            DBConnector.saveList(EntityGenerator.getShopList());
            DBConnector.saveList(EntityGenerator.getSalesmen());
            DBConnector.displayAll(Shop.class);
            DBConnector.displayAll(Salesman.class);
            DBConnector.displaySalesmenNames(1000d);
            DBConnector.displaySalesmenData(Date.valueOf(LocalDate.of(2020,6,6)));
            DBConnector.displayShopsWithSpecificSalesmen(List.of("Иванов","Петров","Сидоров"));
        }
        finally {
            HibernateUtil.close();
        }

    }
}
