package tasksAboutReflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HeadClass {
    public static void main(String[] args) throws Exception {
        Class myClass = HeadClass.class;
        Method myMethod = myClass.getMethod("printManInfo");
        Class[] parameters = new Class[]{};
        myMethod.invoke(new HeadClass(), parameters); //задание 70
        myClass = Task71Class.class;
        myMethod = myClass.getMethod("printHelloWorld");
        myMethod.invoke(new Task71Class(), parameters); // задание 71
        myClass = AnnotationMethods.class;
        myMethod = myClass.getMethod("withAnnotation");
        Annotation[] annotations = myMethod.getDeclaredAnnotations();
        System.out.println("\nАннотации метода withAnnotation:");
        if (annotations.length == 0) System.out.println("Отсутствуют");
        else {
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        }
        myMethod = myClass.getMethod("withoutAnnotation");
        annotations = myMethod.getDeclaredAnnotations();
        System.out.println("\nАннотации метода withoutAnnotation:");
        if (annotations.length == 0) System.out.println("Отсутствуют");
        else {
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        }
    }

    public static void printManInfo() {
        Class manClass = Man.class;
        System.out.println("Имя класса: " + manClass.getName());
        System.out.println("Пакет, в котором находится класс: " + manClass.getPackage());
        System.out.println("Класс наследуется от: " + manClass.getSuperclass());
        System.out.println("Конструкторы класса: ");
        Constructor[] constructors = manClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("Поля класса: ");
        Field[] fields = manClass.getDeclaredFields();
        for (Field field : fields)
            System.out.println(field);
        System.out.println("Методы класса: ");
        Method[] methods = manClass.getDeclaredMethods();
        for (Method method : methods)
            System.out.println(method);
    }
}
