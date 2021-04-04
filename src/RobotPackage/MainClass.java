package RobotPackage;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {

        Garbage garbage = new Garbage();
        Factory factory = new Factory(garbage);
        Scientist scientist1 = new Scientist(garbage, "Scientist1");
        Scientist scientist2 = new Scientist(garbage, "Scientist2");
        factory.initialize();
        factory.start();
        scientist1.start();
        scientist2.start();
        for (int i = 1; i < 101; i++) {
            System.out.println("Ночь номер " + i);
            factory.isRun = true;
            scientist1.isRun = true;
            scientist2.isRun = true;
            Thread.sleep(100);
            while (factory.isRun || scientist1.isRun || scientist2.isRun) {

            }
        }
        int result1 = scientist1.countRobots();
        int result2 = scientist2.countRobots();
        System.out.println("Scientist1 собрал " + result1 + " роботов");
        System.out.println("Scientist2 собрал " + result2 + " роботов");
        if (result1 > result2) System.out.println("Победил Scientist1");
        else if (result2 > result1) System.out.println("Победил Scientist2");
        else System.out.println("Ничья");
    }
}
