package projectPackage.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "PEOPLE")
@NamedQuery(name = "Person.getAll", query = "SELECT s from Person s")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personGenerator")
    @SequenceGenerator(name = "personGenerator", initialValue = 1, allocationSize = 1)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
}
