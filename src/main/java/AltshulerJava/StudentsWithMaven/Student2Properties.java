package AltshulerJava.StudentsWithMaven;

public class Student2Properties extends AltshulerJava.StudentsWithMaven.StudentProperties {

    @Override
    public void displayProperties() {
        System.out.println("Student type - second\nTalent - "+ getTalent());
        System.out.println("Time needed for practice and parsing - " + getTime());
        System.out.println("Total time needed by student - " + getTime()*2+"\n");
    }
}
