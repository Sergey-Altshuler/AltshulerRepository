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
@Table(name = "ADDRESSES")
@NamedQuery(name = "Address.getAll", query = "SELECT s from Address s")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressGenerator")
    @SequenceGenerator(name = "addressGenerator", initialValue = 1, allocationSize = 1)
    private int id;
    @Column
    private String street;
    @Column
    private int house;

}


