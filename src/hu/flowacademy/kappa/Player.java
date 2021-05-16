package hu.flowacademy.kappa;

public class Player {

    private int x;
    private int y;
    private int mapLength;
    private int mapHeight;

    public Player(int mapHeight, int mapLength) {
        this.x = 0;
        this.y = 0;
        this.mapHeight = mapHeight;
        this.mapLength = mapLength;
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

    public boolean move(String direction) throws ArrayIndexOutOfBoundsException {
        if (direction.equals("LE") && (x + 1) < mapHeight) {
            x += 1;
            return true;
        }
        if (direction.equals("FEL") && (x - 1) >= 0) {
            x -= 1;
            return true;
        }
        if (direction.equals("JOBBRA") && (y + 1) < mapLength) {
            y += 1;
            return true;
        }
        if (direction.equals("BALRA") && (y - 1) >= 0) {
            y -= 1;
            return true;
        }
        return false;
    }
}
