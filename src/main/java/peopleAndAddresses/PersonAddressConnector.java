package peopleAndAddresses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonAddressConnector {
    private int id;
    private int personIndex;
    private int addressIndex;
}
