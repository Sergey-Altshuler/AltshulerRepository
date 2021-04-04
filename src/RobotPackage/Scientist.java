package RobotPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Scientist extends Thread {
    private final Garbage garbage;
    private final Map<Robot_details, Integer> resultMap = new HashMap<>();
    private final String name;
    volatile boolean isRun = false;

    public Scientist(Garbage garbage, String name) {
        this.garbage = garbage;
        this.name = name;
    }

    public void run() {
        for (int i = 1; i < 101; i++) {
            while (!isRun) {
            }
            synchronized (Garbage.class) {
                consumeDetails();
            }
            isRun = false;
        }
    }

    private void consumeDetails() {
        Random random = new Random();
        int numberOfTakenDetails = random.nextInt(4) + 1;
        for (int i = 0; i < numberOfTakenDetails; i++) {
            if (garbage.detailsList.size() == 0) {
                break;
            } else {
                int numberOfDetail = random.nextInt(garbage.detailsList.size());
                Robot_details takenDetail = garbage.detailsList.get(numberOfDetail);
                System.out.println(name + " забрал деталь " + takenDetail.toString());
                garbage.detailsList.remove(numberOfDetail);
                if (resultMap.containsKey(takenDetail)) {
                    int value = resultMap.get(takenDetail) + 1;
                    resultMap.put(takenDetail, value);
                } else resultMap.put(takenDetail, 1);

            }
        }
    }

    public int countRobots() {
        if (resultMap.size() < 9) return 0;
        else {
            int countOfRobots = Integer.MAX_VALUE;
            boolean flag = false;
            for (Map.Entry<Robot_details, Integer> mapEntry : resultMap.entrySet()) {
                if (!flag) {
                    flag = true;
                    countOfRobots = mapEntry.getValue();
                } else {
                    if (mapEntry.getValue() < countOfRobots) countOfRobots = mapEntry.getValue();
                }
            }
            return countOfRobots;
        }
    }
}
