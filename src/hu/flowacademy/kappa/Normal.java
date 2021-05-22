package hu.flowacademy.kappa;


import java.util.ArrayList;
import java.util.List;

public class Normal extends Flower {

    private String type;
    private int age;
    private int hp;
    private int x;
    private int y;
    private boolean isPlayerPresent;
    private List<Zombi> zombiList;

    public Normal(int x, int y) {
        super(x, y);
        this.type = super.getSUNFLOWER();
        this.age = 0;
        this.hp = super.getNORMAL();
        this.x = x;
        this.y = y;
        this.isPlayerPresent = false;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isPlayerPresent() {
        return isPlayerPresent;
    }

    public void setPlayerPresent(boolean playerPresent) {
        isPlayerPresent = playerPresent;
    }
}