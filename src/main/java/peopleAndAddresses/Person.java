package peopleAndAddresses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private int id;
    private String name;
    private String surname;
    private int age;
    private int addressNum;

    public Person(String name, String surname, int age, int addressNum) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.addressNum=addressNum;
    }
}
