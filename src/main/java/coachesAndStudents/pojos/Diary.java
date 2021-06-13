package coachesAndStudents.pojos;

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
@Table
@Entity
public class Diary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int mark;
    @Column
    private String report;
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn
    private Student student;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "coach_id")
    private Coach coach;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Task task;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diary diary = (Diary) o;
        return id == diary.id && mark == diary.mark && Objects.equals(report, diary.report);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, report);
    }
}
