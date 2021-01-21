package lesson5;

public class ArrayAggregate implements Runnable {
    private float[] array;
    int startPosition;

    public ArrayAggregate(float[] array, int startPosition) {
        this.array = array;
        this.startPosition = startPosition;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("Поток " + Thread.currentThread().getName() + " начал работу");
        fillArray();
        System.out.println("Поток " + Thread.currentThread().getName() + " закончил работу. Время " + (System.currentTimeMillis() - startTime));
    }

    public void fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + (i + startPosition) / 5) * Math.cos(0.2f + (i + startPosition) / 5) * Math.cos(0.4f + (i + startPosition) / 2));
        }
    }
}
