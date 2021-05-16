package projectPackage.generator;

import projectPackage.model.Address;

import java.util.List;
import java.util.Random;

public class AddressGenerator {
    private static final List<String> streets = List.of("Landera", "Krasnaya", "Skriganova", "Pobedi", "Kolasa", "Belinskogo");

    private static String generateStreet() {
        return streets.get(new Random().nextInt(6));
    }

    private static int generateHouse() {
        return new Random().nextInt(50) + 1;
    }

    public static Address generateAddress() {
        return Address.builder().street(generateStreet()).house(generateHouse()).build();
    }
}
