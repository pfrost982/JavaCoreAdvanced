package lesson1;

public class Track implements Obstacle {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(Participant challenger) {
        return challenger.run(distance);
    }

    @Override
    public String toString() {
        return "Дорожка длинной " + distance;
    }

}
