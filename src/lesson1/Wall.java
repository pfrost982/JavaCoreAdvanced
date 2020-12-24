package lesson1;

public class Wall implements Obstacle {
    private double hight;

    public Wall(double hight) {
        this.hight = hight;
    }

    @Override
    public boolean overcome(Participant challenger) {
        return challenger.jump(hight);
    }

    @Override
    public String toString() {
        return "Стена высотой " + String.format("%.2f", hight);
    }
}
