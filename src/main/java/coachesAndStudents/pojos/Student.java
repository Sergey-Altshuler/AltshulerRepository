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
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private int IQ;

    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable (name = "Students_Courses", joinColumns = {@JoinColumn(name="Student_id")},
        inverseJoinColumns = {@JoinColumn(name="Course_id")})
    private Set<Course> courseSet = new HashSet<>();

    @OneToOne (fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private Diary diary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && IQ == student.IQ && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, IQ);
    }
}
