package AltshulerJava.StudentsWithMaven;

public class Student {

    private final StudentProperties studentProperties;

    public StudentProperties getStudentProperties() {
        return studentProperties;
    }

    private Student(double talent, TypeOfStudent typeOfStudent) {
        switch (typeOfStudent) {
            case ONE: {
                studentProperties = new Student1Properties();
                break;
            }
            case TWO: {
                studentProperties = new Student2Properties();
                break;
            }
            case THREE: {
                studentProperties = new Student3Properties();
                break;
            }
            default:
                studentProperties = null;
        }
        studentProperties.setTalent(talent);
        studentProperties.setTime(StudentProperties.DEFAULT_TIME / talent);
    }

    public void display() {
        studentProperties.displayProperties();
    }

    public static Student createStudent(double talent, TypeOfStudent typeOfStudent) {
        return new Student(talent, typeOfStudent);
    }
}
