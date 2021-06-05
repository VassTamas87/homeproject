package hu.flowacademy.kappa;


import java.util.ArrayList;
import java.util.List;

public class Normal extends Flower {

    private String type;
    private int age;
    private int hp;
    private int x;
    private int y;
    private List<Zombi> zombiList;
    private boolean isActive;

    public Normal(int x, int y) {
        super(x, y);
        this.type = super.getSUNFLOWER();
        this.age = 0;
        this.hp = super.getNORMAL();
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