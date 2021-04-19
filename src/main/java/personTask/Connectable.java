package personTask;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public abstract class Connectable {
    boolean isNotWrittenOrRead = false;
    File file = new File("People.txt");
    Connection connection;
    Statement statement;

    abstract List<Person> readFromSource();

    abstract void writeToSource(List<Person> listOfSomething);

    void prepareForUseDatabase() {

    }
}

