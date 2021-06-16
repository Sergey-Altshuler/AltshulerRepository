package com.Altshuler.util;

import com.Altshuler.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentsGenerator {
    private static final List<String> names = List.of("Sergey","Andrey","Oksana","Ilya","Matvei","Nikita");
    public static List<Student> generateStudents(int number){
        List<Student> students = new ArrayList<>();
        for (int i=0; i<number; i++){
            Student student = Student.builder().name(names.get(new Random().nextInt(names.size()))).age(new Random().nextInt(15)+18).build();
            students.add(student);
        }
        return students;
    }
}
