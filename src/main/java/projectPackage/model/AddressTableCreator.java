package projectPackage.model;

import projectPackage.util.DatabaseStatementsUtilClass;

import java.sql.SQLException;

public class AddressTableCreator implements TableCreatable {
    @Override
    public void createTable() throws SQLException {
        DatabaseStatementsUtilClass.executeStatement("CREATE table if not exists ADDRESS (id int auto_increment, street varchar(25), house int, primary key (id))");
    }
}
