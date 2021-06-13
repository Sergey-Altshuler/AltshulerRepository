package coachesAndStudents.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private int level;
    @Column
    private int price;

    @OneToMany (mappedBy = "course")
    private Set<Coach> coachSet = new HashSet<>();

    @ManyToMany (mappedBy = "courseSet")
    private Set<Student> students = new HashSet<>();

    @OneToMany (mappedBy = "course1")
    private Set<Task> taskSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && level == course.level && price == course.price && Objects.equals(title, course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, level, price);
    }
}
