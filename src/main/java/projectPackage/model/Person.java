package projectPackage.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PEOPLE")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", unique = true)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @OneToMany(mappedBy = "person")
    private Set<Address> addresses = new HashSet<>();

    private String displayAddresses() {
        StringBuilder displayed = new StringBuilder();
        if (addresses == null) displayed.append(" don't exist");
        else {
            for (Address address : addresses) {
                displayed.append("\naddress: ");
                displayed.append("id= ").append(address.getId()).append(", street= ").append(address.getStreet()).append(", house= ").append(address.getHouse());
            }
        }
        return new String(displayed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", addresses belonging to this person:" + displayAddresses() +
                '}';
    }
}