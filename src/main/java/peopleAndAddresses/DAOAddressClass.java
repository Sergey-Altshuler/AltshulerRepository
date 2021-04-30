package peopleAndAddresses;

import java.sql.*;

public class DAOAddressClass implements DAOAddress {
    @Override
    public void save(Address address) throws SQLException {
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        String sql = "INSERT INTO ADDRESS(id, street, house) VALUES(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,address.getId());
        ps.setString(2, address.getStreet());
        ps.setInt(3, address.getHouse());
        ps.executeUpdate();
        connection.close();
        ps.close();
    }

    @Override
    public Address get(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        String sql = "SELECT * FROM ADDRESS WHERE id=" + id;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        int index = rs.getInt(1);
        String street = rs.getString(2);
        int house = rs.getInt(3);
        connection.close();
        statement.close();
        return new Address(index,street,house);
    }

    @Override
    public void update(Address address) throws SQLException {
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        String sql = "UPDATE ADDRESS SET STREET=?, HOUSE=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, address.getStreet());
        preparedStatement.setInt(2, address.getHouse());
        preparedStatement.setInt(3,address.getId());
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();

    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(HeadClass.URL, HeadClass.userName, HeadClass.password);
        String sql = "DELETE FROM ADDRESS WHERE id=" + id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
        statement.close();
    }
}
