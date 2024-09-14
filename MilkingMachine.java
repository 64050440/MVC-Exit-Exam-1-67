
public class MilkingMachine {
    private int id;
    private String state; // กำหนดสถานะเครื่อง idle, cleaning, ready, milking
    private Cow currentCow;

    public MilkingMachine(int id) {
        this.id = id;
        this.state = "idle";
        this.currentCow = null;
    }

    public void attachToCow(Cow cow) {
        if (this.currentCow == null) {
            this.currentCow = cow;
            this.state = "cleaning";
            System.out.println("เครื่อง " + id + " กำลังทำความสะอาดวัว " + cow.getId() + ".");
        }
    }

    public boolean isReadyForMilking() {
        return this.state.equals("cleaning");
    }

    public void prepareForMilking() {
        if (this.isReadyForMilking()) {
            this.state = "ready";
            System.out.println("เครื่อง " + id + " พร้อมสำหรับการรีดนมวัว " + currentCow.getId() + ".");
        }
    }

    public void startMilking() {
        if (this.state.equals("ready") && this.currentCow != null) {
            this.state = "milking";
            System.out.println("เครื่อง " + id + " กำลังรีดนมวัว " + currentCow.getId() + ".");

            // บันทึกว่าหากวัวถูกรีดโดยเครื่องที่ต้องการ
            if (currentCow.getDesiredMachine() == this.id) {
                System.out.println("วัว " + currentCow.getId() + " มีความสุขและกำลังถูกรีดโดยเครื่องที่ต้องการ.");
            } else {
                System.out.println(
                        "วัว " + currentCow.getId() + " ไม่พอใจและไม่ได้ถูกรีดโดยเครื่องที่ต้องการ.");
            }
        }
    }

    public double milkCow() {
        if (this.state.equals("milking") && this.currentCow != null) {
            double milkProduced;
            if (currentCow.getDesiredMachine() == this.id) {
                milkProduced = 1.0; // วัวมีความสุข, ผลิตนม 1 ลิตร
            } else {
                milkProduced = 0.5; // วัวไม่พอใจ, ผลิตนม 0.5 ลิตร
                currentCow.setMood("angry");
            }
            System.out.println("วัว " + currentCow.getId() + " ผลิตนม " + milkProduced + " ลิตร.");
            this.removeCow();
            return milkProduced;
        }
        return 0;
    }

    public void removeCow() {
        this.currentCow = null;
        this.state = "idle"; // รีเซ็ตเครื่องหลังการรีดนม
        System.out.println("เครื่อง " + id + " กลับมาอยู่ในสถานะ idle.");
    }

    public boolean isIdle() {
        return this.state.equals("idle");
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public Cow getCurrentCow() {
        return currentCow;
    }
}
