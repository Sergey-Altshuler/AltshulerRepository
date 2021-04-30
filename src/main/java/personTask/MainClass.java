package personTask;

import java.util.*;

public class MainClass {
    private static Locale locale = new Locale("en", "EN");
    private static ResourceBundle rb = ResourceBundle.getBundle("PersonFile", locale);

    public static void main(String[] args) {
        selectLanguage();
        System.out.println(rb.getString("firstList"));
        PersonFactory personFactory = new PersonFactory();
        personFactory.generateAndFilterU21();
        personFactory.printPersonList();
        personFactory.sortAndDeleteDuplicates();
        Connectable connectable = new FileConnector();
        connectable.writeToSource(personFactory.getPersonList());
        personFactory.setPersonList(connectable.readFromSource());
        personFactory.transformIntoSurnameNameList();
        System.out.println("\n" + rb.getString("finalList") + "\n");
        personFactory.printTransformedList();

        connectable = new DatabaseConnector();
        connectable.writeToSource(personFactory.getPersonList());
        personFactory.setPersonList(connectable.readFromSource());
        personFactory.transformIntoSurnameNameList();
        System.out.println("\n" + rb.getString("finalListAfterQueryToDatabase") + "\n");
        personFactory.printTransformedList();
    }

    public static void selectLanguage() {
        System.out.println("Введите язык, EN или RU");
        Scanner scanner = new Scanner(System.in);
        String language = scanner.nextLine();
        if (language.equals("RU")) {
            locale = new Locale("ru", "RU");
            rb = ResourceBundle.getBundle("PersonFile", locale);
        }
    }
}