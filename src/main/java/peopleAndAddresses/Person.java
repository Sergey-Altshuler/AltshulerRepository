package peopleAndAddresses;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int addressNum;

    public Person(int id, String name, String surname, int age, int addressNum) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.addressNum=addressNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(int addressNum) {
        this.addressNum = addressNum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", addressNum=" + addressNum +
                '}';
    }
}
