package peopleAndAddresses;

public interface DAOAddress extends DAO<Address>{
    default Address increaseHouse(Address address, int num){
        address.setHouse(address.getHouse() + num);
        return address;
    }
}
