package peopleAndAddresses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
    private int id;
    private String street;
    private int house;

    public Address(String street, int house) {
        this.street = street;
        this.house = house;
    }
}
