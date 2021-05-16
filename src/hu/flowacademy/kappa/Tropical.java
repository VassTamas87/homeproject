package hu.flowacademy.kappa;

public class Tropical extends Flower {

    private String type;
    private int age;
    private int hp;
    private int x;
    private int y;

    public Tropical(int x, int y) {
        super(x, y);
        this.type = "T";
        this.age = 0;
        this.hp = 18;
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

    public String toString() {
        return this.type + "/Age:" + this.age + "/Hp:" + this.hp;
    }
}
