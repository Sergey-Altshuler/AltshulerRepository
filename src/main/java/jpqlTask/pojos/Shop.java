package jpqlTask.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="shop")
@Table(name="shops")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String address;
    @Column
    private Double income;
    @Column (name = "dateWhenFounded")
    private Date date;
    @Column
    private String name;
    @OneToMany(mappedBy = "shop")
    private Set<Salesman> salesmen = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id && Objects.equals(address, shop.address) && Objects.equals(income, shop.income) && Objects.equals(date, shop.date) && Objects.equals(name, shop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, income, date, name);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", income=" + income +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", salesmen=" + salesmen +
                '}';
    }
}
