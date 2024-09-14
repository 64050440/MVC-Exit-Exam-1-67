package model;

public class Cow {
    private int id;
    private int desiredMachine;
    private String mood; // happy, angry, etc.
    private boolean special;

    public Cow(int id, int desiredMachine, boolean special) {
        this.id = id;
        this.desiredMachine = desiredMachine;
        this.mood = "happy"; // อารมณ์เริ่มต้นคือมีความสุข
        this.special = special; // วัวพิเศษจะไม่ถูกรีดนม
    }

    public int getId() {
        return id;
    }

    public int getDesiredMachine() {
        return desiredMachine;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public boolean isSpecial() {
        return special;
    }
}
