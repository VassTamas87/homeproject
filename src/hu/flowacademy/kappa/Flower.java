package hu.flowacademy.kappa;

;

public class Flower<ANSI_BLACK_BACKGROUND, TEXT_YELLOW> {

    private String type;
    private int age;
    private int hp;
    private int x;
    private int y;
    private boolean isPlayerPresent;

    public Flower(int x, int y) {
        this.type = "N";
        this.age = 0;
        this.hp = 12;
        this.x = x;
        this.y = y;
        this.isPlayerPresent = false;
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



    public String toString() {
        return  this.type + "|Age:" + this.age + "|Hp:" + this.hp + (isPlayerPresent ? " █████ " : "       ") + "Bug:10";
    }
}
