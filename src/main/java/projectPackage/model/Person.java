package projectPackage.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Person implements Serializable {
    private int id;
    private String name;
    private String surname;
    private int age;

}
