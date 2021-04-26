package peopleAndAddresses;

import java.sql.*;

public class DAOAddressWithPeopleClass implements DAOAddressWithPeople{
    @Override
    public void save(PersonAddressConnector personAddressConnector) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, userName, password);
        String sql = "INSERT INTO PEOPLEWITHADDRESS(id, personIndex, addressIndex) VALUES(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,personAddressConnector.getId());
        ps.setInt(2, personAddressConnector.getPersonIndex());
        ps.setInt(3, personAddressConnector.getAddressIndex());
        ps.executeUpdate();
        connection.close();
        ps.close();
    }

    @Override
    public PersonAddressConnector get(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, userName, password);
        String sql = "SELECT * FROM PEOPLEWITHADDRESS WHERE id=" + id;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        int index = rs.getInt(1);
        int personIndex = rs.getInt(2);
        int addressIndex = rs.getInt(3);
        connection.close();
        statement.close();
        return new PersonAddressConnector(index,personIndex, addressIndex);
    }

    @Override
    public void update(PersonAddressConnector personAddressConnector) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, userName, password);
        String sql = "UPDATE PEOPLEWITHADDRESS SET PERSONINDEX=?, ADDRESSINDEX=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, personAddressConnector.getPersonIndex());
        preparedStatement.setInt(2, personAddressConnector.getAddressIndex());
        preparedStatement.setInt(3, personAddressConnector.getId());
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, userName, password);
        String sql = "DELETE FROM PEOPLEWITHADDRESS WHERE id=" + id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
        statement.close();
    }
}
