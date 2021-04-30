package personTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonFactory {
    private List<Person> personList = new ArrayList<>();
    private static int count;
    private List<String> surnamesAndNames = new ArrayList<>();

    public PersonFactory() {
        count = 0;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void generateAndFilterU21() {
        Stream<Person> personStream = Stream.generate(() -> Person.createPerson(++count)).limit(100).filter((person) -> person.getAge() < 21);
        personList = personStream.collect(Collectors.toList());
    }

    public void printPersonList() {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    public void sortAndDeleteDuplicates() {
        Set<Person> personSet = new HashSet<>(personList);
        personList = personSet.stream().sorted
                (new PersonSurnameComparator().thenComparing(new PersonNameComparator())).collect(Collectors.toList());
    }

    public void transformIntoSurnameNameList() {
        surnamesAndNames = personList.stream().map((person) -> person.getSurname() + " " + person.getName()).collect(Collectors.toList());
    }

    public void printTransformedList() {
        for (String person : surnamesAndNames) {
            System.out.println("Name and surname: " + person);
        }
    }
}