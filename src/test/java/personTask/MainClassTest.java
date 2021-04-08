package personTask;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainClassTest {
    @Test
    public void main()  {
        MainClass.printU21();
        MainClass.compareAndDeleteEqualities();
        MainClass.writeToFile();
        MainClass.readFromFile();
        MainClass.printNameSurnameList();
        assertFalse(MainClass.isNotWrittenOrRead);
        assertNotNull(MainClass.personList);
        assertNotNull(MainClass.readList);
        assertNotNull(MainClass.finalList);
        assertEquals(MainClass.finalList.size(),MainClass.readList.size());
        assertEquals(MainClass.personList.size(),MainClass.readList.size());
    }
}
