package coachesAndStudents.util;

import coachesAndStudents.pojos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorEntities {
    private final static List<Coach> coachList = new ArrayList<>();
    private final static List<Course> courseList = new ArrayList<>();
    private final static List<Diary> diaryList = new ArrayList<>();
    private final static List<Student> studentList = new ArrayList<>();
    private final static List<Task> taskList = new ArrayList<>();

    private final static List<String> names = List.of("Сергей", "Андрей", "Дима", "Гена", "Павел", "Денис");
    private final static List<String> titles = List.of("C++", "Ruby", "Android", "Java", "JS");
    private final static List<String> reports = List.of("bad", "very bad", "so-so", "it would be better", "good", "excellent", "superb", "very well");
    private final static List<String> tasks = List.of("write a program","fix bags","create an application","repair a computer");

    public static List<Coach> getCoachList() {
        return coachList;
    }

    public static List<Course> getCourseList() {
        return courseList;
    }

    public static List<Diary> getDiaryList() {
        return diaryList;
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static List<Task> getTaskList() {
        return taskList;
    }


    public static void generate(int number) {
        generateCoach(number);
        generateCourse(number);
        generateDiary(number);
        generateTask(number);
        generateStudent(number);
    }
    public static void clearAll(){
        coachList.clear();
        courseList.clear();
        taskList.clear();
        diaryList.clear();
        studentList.clear();
    }

    private static void generateCoach(int number) {
        for (int i = 0; i < number; i++) {
            String name = names.get(new Random().nextInt(names.size()));
            int salary = new Random().nextInt(1500) + 1000;
            coachList.add(Coach.builder().name(name).salary(salary).build());
        }
    }

    private static void generateCourse(int number) {
        for (int i = 0; i < number; i++) {
            String title = titles.get(new Random().nextInt(titles.size()));
            int level = new Random().nextInt(10) + 1;
            int price = new Random().nextInt(1000) + 1000;
            courseList.add(Course.builder().title(title).level(level).price(price).build());
        }
    }

    private static void generateDiary(int number) {
        for (int i = 0; i < number; i++) {
            int mark = new Random().nextInt(11);
            String report = reports.get(new Random().nextInt(reports.size()));
            diaryList.add(Diary.builder().mark(mark).report(report).build());
        }
    }

    private static void generateStudent(int number) {
        for (int i = 0; i < number; i++) {
            String name = names.get(new Random().nextInt(names.size()));
            int IQ = new Random().nextInt(70)+90;
            int age = new Random().nextInt(20)+20;
            studentList.add(Student.builder().name(name).IQ(IQ).age(age).build());
        }
    }

    private static void generateTask(int number) {
        for (int i = 0; i < number; i++) {
             String name = tasks.get(new Random().nextInt(tasks.size()));
             int level = new Random().nextInt(100)+1;
             taskList.add(Task.builder().name(name).level(level).build());
        }
    }
}

