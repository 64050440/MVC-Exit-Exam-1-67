import model.Cow;
import model.MilkingMachine;
import java.util.LinkedList;
import java.util.Queue;

public class Controller {
    private Queue<Cow> queue; // คิวของวัวที่รอการรีดนม
    private MilkingMachine[] machines; // อาร์เรย์ของเครื่องรีดนม 10 ตัว
    private double milkProduced; // ปริมาณนมที่ผลิต
    private int milkedCows; // จำนวนวัวที่ได้รับการรีดนม
    private int interventions; // จำนวนการแทรกแซง
    private View view;

    public Controller(View view) {
        this.view = view;
        queue = new LinkedList<>();
        machines = new MilkingMachine[10];
        for (int i = 0; i < machines.length; i++) {
            machines[i] = new MilkingMachine(i + 1); // ID ของเครื่องเริ่มจาก 1
        }
        milkProduced = 0;
        milkedCows = 0;
        interventions = 0;
    }

    public void addCowToQueue(Cow cow) {// เอาวัวเข้าคิว
        if (!cow.isSpecial()) {
            queue.add(cow);
        }
    }

    // มอบหมายวัวไปยังเครื่อง
    public void assignCowsToMachines() {

        for (Cow cow : new LinkedList<>(queue)) {
            boolean assigned = false;

            for (MilkingMachine machine : machines) {
                if (machine.isIdle() && machine.getId() == cow.getDesiredMachine()) {
                    machine.attachToCow(cow);
                    queue.remove(cow);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                for (MilkingMachine machine : machines) {
                    if (machine.isIdle()) {
                        machine.attachToCow(cow);
                        queue.remove(cow);
                        break;
                    }
                }
            }
        }
    }

    public void prepareMachines() {
        for (MilkingMachine machine : machines) {
            if (machine.isReadyForMilking()) {
                machine.prepareForMilking();
            }
        }
    }

    public void startMilking() {
        for (MilkingMachine machine : machines) {
            machine.startMilking();
        }
    }

    public void checkAndMilkCows() {
        for (MilkingMachine machine : machines) {
            if (machine.getState().equals("milking")) {
                milkProduced += machine.milkCow();
                milkedCows++;
            }
        }
    }

    public void printMilkingDetails() {
        for (MilkingMachine machine : machines) {
            view.displayMilkingDetails(machine);
        }
    }

    public void printStatus() {
        view.displayStatus(this);
    }

    // Getter สำหรับให้ View เข้าถึงข้อมูล
    public double getMilkProduced() {
        return milkProduced;
    }

    public int getMilkedCows() {
        return milkedCows;
    }

    public int getInterventions() {
        return interventions;
    }
}
