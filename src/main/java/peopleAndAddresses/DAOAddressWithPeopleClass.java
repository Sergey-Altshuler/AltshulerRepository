package peopleAndAddresses;

import java.sql.*;

public class DAOAddressWithPeopleClass implements DAOAddressWithPeople {
    @Override
    public void save(PersonAddressConnector personAddressConnector) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO PEOPLEWITHADDRESS(personIndex, addressIndex) VALUES(?,?)")) {
            ps.setInt(1, personAddressConnector.getPersonIndex());
            ps.setInt(2, personAddressConnector.getAddressIndex());
            ps.executeUpdate();
        }
    }

    @Override
    public PersonAddressConnector get(int id) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM PEOPLEWITHADDRESS WHERE id=" + id);
            rs.next();
            int index = rs.getInt(1);
            int personIndex = rs.getInt(2);
            int addressIndex = rs.getInt(3);
            return new PersonAddressConnector(index, personIndex, addressIndex);
        }
    }

    @Override
    public void update(PersonAddressConnector personAddressConnector) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PEOPLEWITHADDRESS SET PERSONINDEX=?, ADDRESSINDEX=? WHERE id=?")) {
            preparedStatement.setInt(1, personAddressConnector.getPersonIndex());
            preparedStatement.setInt(2, personAddressConnector.getAddressIndex());
            preparedStatement.setInt(3, personAddressConnector.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = DriverManagerUtilClass.get();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM PEOPLEWITHADDRESS WHERE id=" + id);
        }
    }
}
