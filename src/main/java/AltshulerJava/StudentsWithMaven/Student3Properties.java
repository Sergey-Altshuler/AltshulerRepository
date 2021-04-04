package AltshulerJava.StudentsWithMaven;

public class Student3Properties extends StudentProperties {

    @Override
    public void displayProperties() {
        System.out.println("Student type - third\nTalent - "+ getTalent());
        System.out.println("Time needed for practice - "+ getTime());
        System.out.println("Total time needed by student - " + getTime()*3+"\n");
    }
}
