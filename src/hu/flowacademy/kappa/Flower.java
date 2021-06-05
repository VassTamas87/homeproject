package hu.flowacademy.kappa;

import java.util.*;

public abstract class Flower {
    private String type;
    private int age;
    private int hp;
    private int x;
    private int y;
    private final List<Zombi> zombiList;
    private boolean isActive;

    public Flower(int x, int y) {
        this.age = 0;
        this.x = x;
        this.y = y;
        this.zombiList = new ArrayList<>();
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSUNFLOWER() {
        return "Sunflower";
    }

    public String getGATLING() {
        return "Gatling Pea";
    }

    public int getNORMAL() {
        return 12;
    }

    public List<Zombi> getZombiList() {
        return zombiList;
    }

    public int getTROPICAL() {
        return 18;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}