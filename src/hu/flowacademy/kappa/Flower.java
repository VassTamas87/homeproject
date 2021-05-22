package hu.flowacademy.kappa;

import java.util.*;

public abstract class Flower {
    private String type;
    private int age;
    private int hp;
    private int x;
    private int y;
    private boolean isPlayerPresent;
    private final int NORMAL = 12;
    private final int TROPICAL = 18;
    private List<Zombi> zombiList;

    public Flower(int x, int y) {
        this.age = 0;
        this.x = x;
        this.y = y;
        this.isPlayerPresent = false;
        this.zombiList = new ArrayList<>();
    }

    public String getSUNFLOWER() {
        return SUNFLOWER;
    }

    public void setSUNFLOWER(String SUNFLOWER) {
        this.SUNFLOWER = SUNFLOWER;
    }

    public String getGATLING() {
        return GATLING;
    }

    public void setGATLING(String GATLING) {
        this.GATLING = GATLING;
    }

    private String SUNFLOWER = "Sunflower";
    private String GATLING = "Gatling Pea";

    public int getNORMAL() {
        return NORMAL;
    }

    public List<Zombi> getZombiList() {
        return zombiList;
    }

    public void setZombiList(List<Zombi> zombiList) {
        this.zombiList = zombiList;
    }

    public int getTROPICAL() {
        return TROPICAL;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPlayerPresent() {
        return isPlayerPresent;
    }

    public void setPlayerPresent(boolean playerPresent) {
        isPlayerPresent = playerPresent;
    }
}