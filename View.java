import model.Cow;
import model.MilkingMachine;

public class View {

    // แสดงสถานะของระบบการรีดนมทั้งหมด
    public void displayStatus(Controller controller) {
        System.out.println("===== SYSTEM STATUS =====");
        System.out.println("Total milk produced: " + controller.getMilkProduced() + " liters."); // แสดงปริมาณนมที่ผลิตทั้งหมด
        System.out.println("Total cows milked: " + controller.getMilkedCows()); // แสดงจำนวนวัวที่ได้รับการรีดนม
        System.out.println("Total interventions: " + controller.getInterventions()); // แสดงจำนวนการแทรกแซง
        System.out.println("--------------------------");
    }

    // แสดงข้อมูลของเครื่องรีดนมแต่ละตัว
    public void displayMachineStatus(MilkingMachine machine) {
        System.out.println("Machine ID: " + machine.getId()); // แสดงรหัสของเครื่องรีดนม
        System.out.println("State: " + machine.getState()); // แสดงสถานะของเครื่องรีดนม
        if (machine.getCurrentCow() != null) {
            System.out.println("Current cow ID: " + machine.getCurrentCow().getId()); // แสดงรหัสของวัวที่กำลังอยู่ในเครื่อง
        } else {
            System.out.println("No cow currently assigned."); // ไม่มีวัวอยู่ในเครื่อง
        }
        System.out.println("--------------------------");
    }

    // แสดงรายละเอียดการรีดนมสำหรับเครื่องรีดนมแต่ละตัว
    public void displayMilkingDetails(MilkingMachine machine) {
        System.out.println("Machine ID: " + machine.getId());
        System.out.println("State: " + machine.getState());
        if (machine.getCurrentCow() != null) {
            System.out.println("Current cow ID: " + machine.getCurrentCow().getId());
            System.out.println("Cow's Desired Machine: " + machine.getCurrentCow().getDesiredMachine()); // แสดงเครื่องที่วัวต้องการ
        } else {
            System.out.println("No cow currently assigned.");
        }
        System.out.println("--------------------------");
    }

    // แสดงข้อมูลของวัวแต่ละตัว
    public void displayCowInfo(Cow cow) {
        System.out.println("Cow ID: " + cow.getId()); // รหัสของวัว
        System.out.println("Desired Machine: " + cow.getDesiredMachine()); // เครื่องที่วัวต้องการ
        System.out.println("Mood: " + cow.getMood()); // อารมณ์ของวัว
        System.out.println("--------------------------");
    }
}
