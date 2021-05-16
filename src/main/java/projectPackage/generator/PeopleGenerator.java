package projectPackage.generator;

import projectPackage.model.Person;

import java.util.List;
import java.util.Random;

public class PeopleGenerator {
    private final static List<String> names = List.of("Sergey", "Oksana", "Matvei", "Gena", "Ilya", "Andrey", "Dmitriy", "Mikhail");
    private final static List<String> surnames = List.of("Althsuler", "Peregud", "Vetcher", "Lapanik", "Vlasik", "Kechko", "Lapanik", "Silvanovich");

    private static String generateName() {
        return names.get(new Random().nextInt(8));
    }

    private static String generateSurname() {
        return surnames.get(new Random().nextInt(8));
    }

    private static int generateAge() {
        return new Random().nextInt(100);
    }

    public static Person generatePerson() {
        return Person.builder().name(generateName()).surname(generateSurname()).age(generateAge()).build();
    }
}
