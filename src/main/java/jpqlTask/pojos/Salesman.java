package jpqlTask.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="salesman")
@Table(name="salesmen")
public class Salesman implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String nameByFather;
    @Column
    private int salary;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesman salesman = (Salesman) o;
        return id == salesman.id && salary == salesman.salary && Objects.equals(name, salesman.name) && Objects.equals(surname, salesman.surname) && Objects.equals(nameByFather, salesman.nameByFather);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, nameByFather, salary);
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nameByFather='" + nameByFather + '\'' +
                ", salary=" + salary +
                ", shop=" + shop.getName() +
                '}';
    }
}
