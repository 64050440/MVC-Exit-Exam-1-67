
public class MilkingMachine {
    private int id;
    private String state; // idle, cleaning, ready, milking
    private Cow currentCow;

    public MilkingMachine(int id) {
        this.id = id;
        this.state = "idle";
        this.currentCow = null;
    }

    // แนบวัวเข้ากับเครื่องรีดนม
    public void attachToCow(Cow cow) {
        if (this.currentCow == null) {
            this.currentCow = cow;
            this.state = "cleaning";
            System.out.println("Machine " + id + " is cleaning cow " + cow.getId() + ".");
        }
    }

    // ตรวจสอบว่าเครื่องรีดนมพร้อมสำหรับการรีดนมหรือไม่
    public boolean isReadyForMilking() {
        return this.state.equals("cleaning");
    }

    // เตรียมเครื่องรีดนมสำหรับการรีด
    public void prepareForMilking() {
        if (this.isReadyForMilking()) {
            this.state = "ready";
            System.out.println("Machine " + id + " is now ready for milking cow " + currentCow.getId() + ".");
        }
    }

    // เริ่มการรีดนม
    public void startMilking() {
        if (this.state.equals("ready") && this.currentCow != null) {
            this.state = "milking";
            System.out.println("Machine " + id + " is milking cow " + currentCow.getId() + ".");

            // บันทึกหากวัวถูกรีดโดยเครื่องที่ต้องการ
            if (currentCow.getDesiredMachine() == this.id) {
                System.out.println("Cow " + currentCow.getId() + " is happy and being milked by its desired machine.");
            } else {
                System.out.println(
                        "Cow " + currentCow.getId() + " is unhappy and not being milked by its desired machine.");
            }
        }
    }

    // รีดนมวัว
    public double milkCow() {
        if (this.state.equals("milking") && this.currentCow != null) {
            double milkProduced;
            if (currentCow.getDesiredMachine() == this.id) {
                milkProduced = 1.0; // วัวที่มีความสุข ผลิต 1 ลิตร
            } else {
                milkProduced = 0.5; // วัวที่ไม่พอใจ ผลิต 0.5 ลิตร
                currentCow.setMood("angry");
            }
            System.out.println("Cow " + currentCow.getId() + " produced " + milkProduced + " liters of milk.");
            this.removeCow();
            return milkProduced;
        }
        return 0;
    }

    // ลบวัวออกจากเครื่องรีดนม
    public void removeCow() {
        this.currentCow = null;
        this.state = "idle"; // รีเซ็ตสถานะของเครื่องหลังการรีดนม
        System.out.println("Machine " + id + " is now idle.");
    }

    // ตรวจสอบว่าเครื่องรีดนมว่างอยู่หรือไม่
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
