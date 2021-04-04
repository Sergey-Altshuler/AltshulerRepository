package AltshulerJava.StudentsWithMaven;

import java.util.Random;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {

        Random random = new Random();
        Stream<Student> stream1 =
                Stream.generate(() ->
                        Student.createStudent((double) (random.nextInt(10) + 1) / 10, TypeOfStudent.ONE));
        stream1 = stream1.limit(3);
        Stream<Student> stream2 =
                Stream.generate(() ->
                        Student.createStudent((double) (random.nextInt(10) + 1) / 10, TypeOfStudent.TWO));
        stream2 = stream2.limit(3);
        Stream<Student> stream3 =
                Stream.generate(() ->
                        Student.createStudent((double) (random.nextInt(10) + 1) / 10, TypeOfStudent.THREE));
        stream3 = stream3.limit(3);
        Stream<Student> fullStream = Stream.concat(Stream.concat(stream1, stream2), stream3);
        fullStream.forEach(Student::display);
    }
}
