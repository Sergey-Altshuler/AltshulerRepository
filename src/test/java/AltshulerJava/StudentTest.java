package AltshulerJava;

import AltshulerJava.StudentsWithMaven.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test.
 */
public class StudentTest {

    @Test
    public void createStudent() {
        Student student1 = Student.createStudent(1, TypeOfStudent.ONE);
        assertTrue(student1.getStudentProperties() instanceof Student1Properties);
        Student student2 = Student.createStudent(1, TypeOfStudent.TWO);
        assertTrue(student2.getStudentProperties() instanceof Student2Properties);
        Student student3 = Student.createStudent(1, TypeOfStudent.THREE);
        assertTrue(student3.getStudentProperties() instanceof Student3Properties);
    }
}
