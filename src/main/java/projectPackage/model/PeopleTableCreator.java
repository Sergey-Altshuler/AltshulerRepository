package projectPackage.model;

import projectPackage.util.DatabaseStatementsUtilClass;
import java.sql.SQLException;

public class PeopleTableCreator implements TableCreatable {
    @Override
    public void createTable() throws SQLException {
        DatabaseStatementsUtilClass.executeStatement("CREATE table if not exists PEOPLE (id int auto_increment, name varchar(25), surname varchar(25), age int, primary key (id))");
    }
}
