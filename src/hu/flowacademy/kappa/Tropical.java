package hu.flowacademy.kappa;

import java.util.ArrayList;
import java.util.List;

public class Tropical extends Flower {

    private String type;
    private int age;
    private int hp;
    private int x;
    private int y;
    private boolean isPlayerPresent;
    private List<Zombi> zombiList;

    public Tropical(int x, int y) {
        super(x, y);
        this.hp = super.getTROPICAL();
        this.type = super.getGATLING();
        this.age = 0;
        this.isPlayerPresent = false;
        this.x = x;
        this.y = y;
        this.zombiList = new ArrayList<>();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public List<Zombi> getZombiList() {
        return zombiList;
    }

    @Override
    public void setZombiList(List<Zombi> zombiList) {
        this.zombiList = zombiList;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
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

    @Override
    public boolean isPlayerPresent() {
        return isPlayerPresent;
    }

    @Override
    public void setPlayerPresent(boolean playerPresent) {
        isPlayerPresent = playerPresent;
    }
}