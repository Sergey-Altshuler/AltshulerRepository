package AltshulerJava;

import AltshulerJava.StudentsWithMaven.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentPropertiesTest {

    @Test
    public void getTime() {
        Student student = Student.createStudent(0.5, TypeOfStudent.ONE);
        assertEquals(132, student.getStudentProperties().getTime(), 0.0);
    }

    @Test
    public void setTime() {
        StudentProperties studentProperties = new Student2Properties();
        studentProperties.setTime(100);
        assertEquals(100, studentProperties.getTime(), 0);
    }

    @Test
    public void getTalent() {
        Student student = Student.createStudent(0.5, TypeOfStudent.ONE);
        assertEquals(0.5, student.getStudentProperties().getTalent(), 0.0);
    }

    @Test
    public void setTalent() {
        StudentProperties studentProperties = new Student2Properties();
        studentProperties.setTalent(0.2);
        assertEquals(0.2, studentProperties.getTalent(), 0);
    }
}
