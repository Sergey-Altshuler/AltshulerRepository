package peopleAndAddresses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private int id;
    private String name;
    private String surname;
    private int age;


}
