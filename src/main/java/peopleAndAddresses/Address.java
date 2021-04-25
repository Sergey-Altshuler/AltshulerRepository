package peopleAndAddresses;

import java.io.Serializable;

public class Address implements Serializable {
    private int id;
    private String street;
    private int house;

    public Address(int id, String street, int house) {
        this.id=id;
        this.street = street;
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }
}
