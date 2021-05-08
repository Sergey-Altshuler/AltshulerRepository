package projectPackage.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Address implements Serializable {
    private int id;
    private String street;
    private int house;

}


