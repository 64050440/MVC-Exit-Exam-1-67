import model.Cow;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        Random random = new Random();

        // จำลองการเข้าคิวของวัว 100 ตัว
        for (int i = 1; i <= 100; i++) {
            int desiredMachine = random.nextInt(10) + 1; // เครื่องรีดนมที่ต้องการแบบสุ่มระหว่าง 1 ถึง 10
            boolean specialCow = random.nextDouble() < 0.05; // มีโอกาส 5% ที่จะเป็นวัวพิเศษ (แต่เราจะไม่สนใจมัน)
            Cow cow = new Cow(i, desiredMachine, specialCow);
            controller.addCowToQueue(cow);
        }

        for (int i = 0; i < 10; i++) { // จำลอง 10 รอบการรีดนม
            controller.assignCowsToMachines();
            controller.prepareMachines();
            controller.startMilking();
            controller.checkAndMilkCows();
            controller.printStatus();
            controller.printMilkingDetails();
        }
    }
}
