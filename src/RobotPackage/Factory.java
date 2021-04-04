package RobotPackage;

import java.util.Random;

public class Factory extends Thread {
    private final Garbage garbage;
    volatile boolean isRun = false;

    public Factory(Garbage garbage) {
        this.garbage = garbage;
    }

    public void run() {
        for (int i = 1; i < 101; i++) {
            while (!isRun) {

            }
            synchronized (Garbage.class) {
                throwDetails();
            }
            isRun = false;
        }
    }

    public void initialize() {
        for (int i = 0; i < 20; i++) {
            throwOneDetail();
        }
    }

    private void throwDetails() {
        Random random = new Random();
        int numberOfDetails = random.nextInt(4) + 1;
        for (int i = 0; i < numberOfDetails; i++) {
            throwOneDetail();
        }
    }

    private void throwOneDetail() {
        Random random = new Random();
        Robot_details partOfRobot = getDetail(random.nextInt(9));
        garbage.detailsList.add(partOfRobot);
        System.out.println("На склад выброшена деталь " + partOfRobot.toString());
    }

    private Robot_details getDetail(int index) {
        for (Robot_details details : Robot_details.values()) {
            if (details.ordinal() == index) return details;
        }
        return null;
    }
}
