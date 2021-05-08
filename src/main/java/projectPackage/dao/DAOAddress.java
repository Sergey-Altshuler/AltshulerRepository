package projectPackage.dao;

import projectPackage.model.Address;
import projectPackage.util.TransactionUtilClass;
import java.util.List;

public interface DAOAddress extends DAO<Address> {
    default Address increaseHouse(Address address, int num) {
        address.setHouse(address.getHouse() + num);
        return address;
    }

    default void saveAll(List<Address> addresses) {
        TransactionUtilClass.executeTransaction("INSERT INTO ADDRESS(street, house) VALUES(?,?)",addresses, true);
    }
}
