package hu.flowacademy.kappa;

import java.util.ArrayList;
import java.util.List;

public class Tropical extends Flower {

    private String type;
    private int age;
    private int hp;
    private int x;
    private int y;
    private List<Zombi> zombiList;
    private boolean isActive;

    public Tropical(int x, int y) {
        super(x, y);
        this.hp = super.getTROPICAL();
        this.type = super.getGATLING();
        this.age = 0;
        this.x = x;
        this.y = y;
        this.zombiList = new ArrayList<>();
        this.isActive = super.isActive();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public List<Zombi> getZombiList() {
        return zombiList;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }
}