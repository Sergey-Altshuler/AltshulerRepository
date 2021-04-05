package tasksAboutReflection;

public class AnnotationMethods {
    @AcademyInfo(year = 2021)
     public void withAnnotation(){
        System.out.println("This method includes annotation");
    }
    public void withoutAnnotation(){
        System.out.println("This method does not include annotation");
    }
}
