package peopleAndAddresses;

import java.sql.*;

public class DAOAddressClass implements DAOAddress {
    @Override
    public void save(Address address) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ADDRESS(street, house) VALUES(?,?)")) {
            ps.setString(1, address.getStreet());
            ps.setInt(2, address.getHouse());
            ps.executeUpdate();
        }
    }

    @Override
    public Address get(int id) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM ADDRESS WHERE id=" + id);
            rs.next();
            int index = rs.getInt(1);
            String street = rs.getString(2);
            int house = rs.getInt(3);
            return new Address(index, street, house);
        }
    }

    @Override
    public void update(Address address) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ADDRESS SET STREET=?, HOUSE=? WHERE id=?")) {
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setInt(2, address.getHouse());
            preparedStatement.setInt(3, address.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM ADDRESS WHERE id=" + id);
        }
    }
}
