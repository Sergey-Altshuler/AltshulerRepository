package peopleAndAddresses;

public class PersonAddressConnector {
    private int id;
    private int personIndex;
    private int addressIndex;

    public int getPersonIndex() {
        return personIndex;
    }

    public void setPersonIndex(int personIndex) {
        this.personIndex = personIndex;
    }

    public int getAddressIndex() {
        return addressIndex;
    }

    public void setAddressIndex(int addressIndex) {
        this.addressIndex = addressIndex;
    }

    public PersonAddressConnector(int id, int personIndex, int addressIndex) {
        this.id=id;
        this.personIndex = personIndex;
        this.addressIndex = addressIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonAddressConnector{" +
                "id=" + id +
                ", personIndex=" + personIndex +
                ", addressIndex=" + addressIndex +
                '}';
    }
}
