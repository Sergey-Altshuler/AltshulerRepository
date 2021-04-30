package personTask;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class Person implements Serializable {
    private int id;
    private String name;
    private String surname;
    private int age;
    private double salary;
    private String passport;
    private String address;
    private Date dateOfBirthday;
    private Timestamp dateTimeCreate;
    private Time timeToLunch;
    private String letter;

    private static final List<String> names = List.of("Andrey", "Sergey", "Matvey", "Egor", "Ilya", "Dmitriy");
    private static final List<String> surnames = List.of("Perepechko", "Alekseev", "Silvanovich", "Vetcher", "Kechko", "Lapanik", "Altshuler");
    private static final List<String> addresses = List.of("Skriganova-14", "Dzerginskogo-92", "Krasnaya-3", "Kiseleva-12", "Nezavisimosti-50", "Gikalo-3", "Kolasa-13");
    private static final List<String> information = List.of("He is Java Junior", "He is Java Middle", "He is Java Senior", "He is Team Lead", "He is an owner of an IT-company");

    public static List<String> getNames() {
        return names;
    }

    public static List<String> getSurnames() {
        return surnames;
    }

    public static List<String> getAddresses() {
        return addresses;
    }

    public static List<String> getInformation() {
        return information;
    }

    public int getId() {
        return id;
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

    public double getSalary() {
        return salary;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public Timestamp getDateTimeCreate() {
        return dateTimeCreate;
    }

    public Time getTimeToLunch() {
        return timeToLunch;
    }

    public String getLetter() {
        return letter;
    }

    public Person(int id, String name, String surname, int age, double salary, String passport, String address, Date dateOfBirthday, Timestamp dateTimeCreate, Time timeToLunch, String letter) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.passport = passport;
        this.address = address;
        this.dateOfBirthday = dateOfBirthday;
        this.dateTimeCreate = dateTimeCreate;
        this.timeToLunch = timeToLunch;
        this.letter = letter;
    }

    private Person() {

    }

    private static String createPassport() {
        StringBuilder passportNumber = new StringBuilder("AB");
        for (int i = 0; i < 7; i++) {
            passportNumber.append(new Random().nextInt(10));
        }
        return new String(passportNumber);
    }

    @Override
    public String toString() {
        String creationData = getDateTimeCreate().toString().substring(0, getDateTimeCreate().toString().length() - 8);
        String lunchData = getTimeToLunch().toString().substring(0, getTimeToLunch().toString().length() - 3);
        return "Person № " + getId() + "\nName: " + getName() + "\nSurname: " + getSurname() + "\nAge: " + getAge() + "\nSalary: " + getSalary() + "\nPassport: " + getPassport() + "\nAddress: " + getAddress() + "\nBirthday: " + getDateOfBirthday() + "\nDate and time of creation a field about person: " + creationData + "\nTime to lunch: " + lunchData + "\nAdditional information: " + getLetter() + "\n\n";
    }

    public static Person createPerson(int id) {
        int nameIndex = new Random().nextInt(6);
        int surnameIndex = new Random().nextInt(7);
        int age = new Random().nextInt(16) + 15;
        double salary = new Random().nextInt(2001) + 500;
        String passport = createPassport();
        int addressIndex = new Random().nextInt(7);
        LocalDate birthday = LocalDate.ofEpochDay(new Random().nextInt(15000));
        Date birthdayDate = Date.valueOf(birthday);
        LocalDateTime createdDateTime = LocalDateTime.now();
        Timestamp created = Timestamp.valueOf(createdDateTime);
        LocalTime timeLunch = LocalTime.of(new Random().nextInt(4), new Random().nextInt(60));
        Time timeToLunch = Time.valueOf(timeLunch);
        int letterIndex = new Random().nextInt(5);
        return Person.personBuilder().id(id).name(names.get(nameIndex)).surname(surnames.get(surnameIndex)).age(age).salary(salary).passport(passport).address(addresses.get(addressIndex)).birthday(birthdayDate).dateTimeCreate(created).timeToLunch(timeToLunch).letter(information.get(letterIndex)).build();
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

    public static Builder personBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder id(int id) {
            person.id = id;
            return this;
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

        public Builder salary(double salary) {
            person.salary = salary;
            return this;
        }

        public Builder passport(String passport) {
            person.passport = passport;
            return this;
        }

        public Builder address(String address) {
            person.address = address;
            return this;
        }

        public Builder birthday(Date dateOfBirthday) {
            person.dateOfBirthday = dateOfBirthday;
            return this;
        }

        public Builder dateTimeCreate(Timestamp dateTimeCreate) {
            person.dateTimeCreate = dateTimeCreate;
            return this;
        }

        public Builder timeToLunch(Time timeToLunch) {
            person.timeToLunch = timeToLunch;
            return this;
        }

        public Builder letter(String letter) {
            person.letter = letter;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}