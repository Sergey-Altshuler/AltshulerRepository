package AltshulerJava.StudentsWithMaven;

public class Student1Properties extends StudentProperties {

    @Override
    public void displayProperties() {
        System.out.println("Student type - first\nTalent - "+ getTalent());
        System.out.println("Time needed for practice, parsing and being in stream - " + getTime()/3);
        System.out.println("Total time needed by student - " + getTime()+"\n");
    }
}
