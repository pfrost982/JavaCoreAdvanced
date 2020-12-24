package lesson1;

public class Man implements Participant {
    private String name;
    private int maxRunDistance;
    private double maxJumpHight;

    public Man(String name, int maxRunDistance, double maxJumpHight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHight = maxJumpHight;
    }

    @Override
    public boolean run(int distance) {
        if (this.maxRunDistance > distance) {
            System.out.println("Человек " + name + " пробежал дистанцию " + distance);
            return true;
        } else {
            System.out.println("Человек " + name + " не смог пробежать дистанцию " + distance);
            return false;
        }
    }

    @Override
    public boolean jump(double hight) {
        if (this.maxJumpHight > hight) {
            System.out.println("Человек " + name + " перепрыгнул высоту " + String.format("%.2f", hight));
            return true;
        } else {
            System.out.println("Человек " + name + " не смог перепрыгнуть высоту " + String.format("%.2f", hight));
            return false;
        }
    }

    @Override
    public String toString() {
        return "Человек " + name + ", максимальная дистанция: " + maxRunDistance + ", максимальный прыжок: " + String.format("%.2f", maxJumpHight);
    }
}
