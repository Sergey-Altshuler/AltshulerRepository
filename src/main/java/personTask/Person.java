package personTask;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Person implements Serializable {
    private String name;
    private String surname;
    private int age;
    private static final List<String> names = List.of("Andrey", "Sergey", "Matvey", "Egor", "Ilya", "Dmitriy");
    private static final List<String> surnames = List.of("Perepechko", "Alekseev", "Silvanovich", "Vetcher", "Kechko", "Lapanik", "Altshuler");

    public static List<String> getNames() {
        return names;
    }

    public static List<String> getSurnames() {
        return surnames;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    private Person() {

    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Surname: " + getSurname() + ", Age: " + getAge();
    }

    public static Person createPerson() {
        int nameIndex = new Random().nextInt(6);
        int surnameIndex = new Random().nextInt(7);
        int age = new Random().nextInt(16) + 15;
        return new Builder().name(names.get(nameIndex)).surname(surnames.get(surnameIndex)).age(age).build();
    }


    @Override
    public boolean equals(Object person) {
        if (this == person) return true;
        return (person instanceof Person) &&
                (((Person) person).getName().equals(this.name)) &&
                (((Person) person).getSurname().equals(this.surname)) &&
                (((Person) person).getAge() == (this.age));

    }

    @Override
    public int hashCode() {
        return 1 + 31 * age + 21 * name.hashCode() + surname.hashCode();
    }

    public static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder name(String name) {
            person.name = name;
            return this;
        }

        public Builder surname(String surname) {
            person.surname = surname;
            return this;
        }

        public Builder age(int age) {
            person.age = age;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}
