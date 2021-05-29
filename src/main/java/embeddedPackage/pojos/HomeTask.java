package embeddedPackage.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
public class HomeTask extends Task{
    @CreationTimestamp
    private LocalDateTime startDate;
    @UpdateTimestamp
    private LocalDateTime endDate;
    @Embedded
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HomeTask homeTask = (HomeTask) o;
        return id == homeTask.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "HomeTask{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", address=" + address +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
