package lesson5;

public class Main {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        Main main = new Main();

        main.method1();
        main.method2();

    }

    public void method1() {
        float[] array = new float[SIZE];
        new Thread(() -> this.fillArray(array, "1")).start();
    }

    public void method2() {
        float[] array = new float[SIZE];
        float[] firstHalf = new float[HALF];
        float[] secondHalf = new float[SIZE - HALF];
        long startTime = System.currentTimeMillis();
        System.arraycopy(array, 0, firstHalf, 0, HALF);
        System.arraycopy(array, HALF, secondHalf, 0, SIZE - HALF);
        System.out.println("Время разбивки: " + (System.currentTimeMillis() - startTime));
        new Thread(() -> this.fillArray(firstHalf, "2 first half")).start();
        new Thread(() -> this.fillArray(secondHalf, "2 second half")).start();
        startTime = System.currentTimeMillis();
        System.arraycopy(firstHalf, 0, array, 0, firstHalf.length);
        System.arraycopy(secondHalf, 0, array, firstHalf.length, secondHalf.length);
        System.out.println("Время склейки: " + (System.currentTimeMillis() - startTime));
    }

    public void fillArray(float[] array, String name) {
        long startTime = System.currentTimeMillis();
        System.out.println("Start Method " + name);
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Finish Method " + name + ", Time: " + (System.currentTimeMillis() - startTime) + " length " + array.length);
    }
}
