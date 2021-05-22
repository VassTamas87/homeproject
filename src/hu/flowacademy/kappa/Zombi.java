package hu.flowacademy.kappa;

public class Zombi {

    private int hp;
    private boolean hasEaten;

    public Zombi() {
        boolean hasEaten = false;
        this.hp = 6;
    }

    public boolean isHasEaten() {
        return hasEaten;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
