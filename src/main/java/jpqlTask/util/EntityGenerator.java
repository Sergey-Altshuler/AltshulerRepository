package jpqlTask.util;

import jpqlTask.pojos.Salesman;
import jpqlTask.pojos.Shop;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class EntityGenerator {
    private final static List<String> streets = List.of("Ландера", "Скрыганова", "Независимости", "Красная", "Киселева", "Притыцкого", "Пушкина", "Рокоссовского");
    private final static List<String> shopNames = List.of("Евроопт", "Алми", "Соседи", "Белмаркет", "21 век", "Электросила", "5 элемент", "Корона");
    private final static List<String> names = List.of("Сергей", "Андрей", "Дима", "Гена", "Павел", "Денис");
    private final static List<String> surNames = List.of("Иванов", "Петров", "Сидоров", "Лапаник", "Альтшулер", "Власик", "Булгаков");
    private final static List<String> namesByFather = List.of("Олегович", "Сергеевич", "Иванович", "Матвеевич", "Геннадьевич", "Валерьевич");
    private final static List<Shop> shopList = new ArrayList<>();
    private final static List<Salesman> salesmen = new ArrayList<>();

    public static List<Shop> getShopList() {
        return shopList;
    }

    public static List<Salesman> getSalesmen() {
        return salesmen;
    }

    public static void generateEntities() {
        generateShops(new Random().nextInt(10) + 5);
        generateSalesmen(new Random().nextInt(20) + 10);
        affiliate();
    }

    private static void generateShops(int number) {

        for (int i = 0; i < number; i++) {
            String name = shopNames.get(new Random().nextInt(shopNames.size()));
            Date date = getRandomDate();
            String address = streets.get(new Random().nextInt(streets.size())) + ", " + (new Random().nextInt(50) + 1);
            Double income = ((double) (new Random().nextInt(100000) + 20000)) / 100;
            shopList.add(Shop.builder().name(name).date(date).address(address).income(income).build());
        }
    }

    private static void generateSalesmen(int number) {
        for (int i = 0; i < number; i++) {
            String name = names.get(new Random().nextInt(names.size()));
            String surname = surNames.get(new Random().nextInt(surNames.size()));
            String nameByFather = namesByFather.get(new Random().nextInt(namesByFather.size()));
            int salary = new Random().nextInt(1000) + 500;
            salesmen.add(Salesman.builder().name(name).surname(surname).nameByFather(nameByFather).salary(salary).build());
        }
    }

    private static void affiliate() {
        for (Salesman salesman : salesmen) {
            int shopNum = new Random().nextInt(shopList.size());
            Shop shop = shopList.get(shopNum);
            salesman.setShop(shop);

            if (shop.getSalesmen() != null) {
                Set<Salesman> salesSet = shop.getSalesmen();
                salesSet.add(salesman);
                shopList.get(shopNum).setSalesmen(salesSet);
            } else {
                Set<Salesman> set = new HashSet<>();
                set.add(salesman);
                shopList.get(shopNum).setSalesmen(set);
            }
        }
    }

    private static Date getRandomDate() {
        LocalDate first = LocalDate.of(2020, 1, 1);
        LocalDate last = LocalDate.of(2021, 6, 1);
        long days = first.until(last, ChronoUnit.DAYS);
        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
        LocalDate resultDate = first.plusDays(randomDays);
        return Date.valueOf(resultDate);
    }
}
