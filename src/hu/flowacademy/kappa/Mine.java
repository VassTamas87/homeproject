package hu.flowacademy.kappa;

public class Mine extends Flower {

    private int x;
    private int y;
    private String type;

    @Override
    public String getType() {
        return type;
    }

    public Mine(int x, int y) {
        super(x, y);
        this.type = super.getMINE();
    }
}
