package personTask;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    static List<Person> personList = new ArrayList<>();
    static final File file = new File("person.txt");
    static boolean isCreated = false;
    static boolean isNotWrittenOrRead = false;
    static List<Person> readList = new ArrayList<>();
    static List<String> finalList = new ArrayList<>();
    static Locale locale = new Locale("en", "EN");
    static ResourceBundle rb = ResourceBundle.getBundle("PersonFile", locale);

    public static void main(String[] args) {
        selectLanguage();
        printU21();
        compareAndDeleteEqualities();
        writeToFile();
        readFromFile();
        printNameSurnameList();
    }

    public static void selectLanguage() {
        System.out.println("Введите язык, EN или RU");
        Scanner scanner = new Scanner(System.in);
        String language = scanner.nextLine();
        if (language.equals("RU")) {
            locale = new Locale("ru", "RU");
            rb = ResourceBundle.getBundle("PersonFile", locale);
        }
        System.out.println(rb.getString("firstList"));
    }

    public static void printU21() {
        Stream<Person> personStream = Stream.generate(Person::createPerson).limit(100).filter((person) -> person.getAge() < 21);
        personList = personStream.collect(Collectors.toList());
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    public static void compareAndDeleteEqualities() {
        Set<Person> personSet = new HashSet<>(personList);
        personList = personSet.stream().sorted
                (new PersonSurnameComparator().thenComparing(new PersonNameComparator())).collect(Collectors.toList());
    }

    public static void writeToFile() {
        try (ObjectOutputStream personStream = new ObjectOutputStream(new FileOutputStream(file))) {
            isCreated = file.createNewFile();
            personStream.writeObject(personList);
        } catch (IOException e) {
            isNotWrittenOrRead = true;
        }
    }

    public static void readFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            readList = (ArrayList<Person>) inputStream.readObject();
        }
        catch(IOException|ClassNotFoundException e){
            isNotWrittenOrRead = true;
        }
    }

    public static void printNameSurnameList() {
        finalList = readList.stream().map((person) -> person.getSurname() + " " + person.getName()).collect(Collectors.toList());
        System.out.println("\n" + rb.getString("finalList") + "\n");
        for (String person : finalList) {
            System.out.println(rb.getString("person") + person);
        }
    }
}