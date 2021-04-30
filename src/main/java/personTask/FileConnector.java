package personTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileConnector extends Connectable{

    @Override
    public List<Person> readFromSource() {
        List<Person> readList=null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
           readList = (ArrayList<Person>) inputStream.readObject();
        }
        catch(IOException|ClassNotFoundException e){
            isNotWrittenOrRead = true;
        }
        return readList;
    }

    @Override
    public void writeToSource(List<Person> personList) {
        try (ObjectOutputStream personStream = new ObjectOutputStream(new FileOutputStream(file))) {
            file.createNewFile();
            personStream.writeObject(personList);
        } catch (IOException e) {
            isNotWrittenOrRead = true;
        }
    }
}
