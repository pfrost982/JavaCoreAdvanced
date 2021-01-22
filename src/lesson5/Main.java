package lesson5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        method1(10_000_000);
        method2(10_000_000);

        float[] array1 = method1(10);
        float[] array2 = method2(10);
        System.out.println();
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

    }

    public static float[] method1(int size) {
        float[] array = new float[size];
        var aggregate = new ArrayAggregate(array, 0);

        System.out.println("\nМетод 1 начал работу");
        long startTime = System.currentTimeMillis();
        aggregate.fillArray();
        long endTime = System.currentTimeMillis();
        System.out.println("Метод 1 закончил работу. Время: " + (endTime - startTime));
        return array;
    }


    public static float[] method2(int size) {
        int half = size / 2;
        float[] array = new float[size];
        float[] firstHalfArray = new float[half];
        float[] secondHalfArray = new float[size - half];

        System.out.println("\nМетод 2 начал работу");
        long startTime = System.currentTimeMillis();

        System.arraycopy(array, 0, firstHalfArray, 0, half);
        System.arraycopy(array, half, secondHalfArray, 0, size - half);

        Thread firstThread = new Thread(new ArrayAggregate(firstHalfArray, 0), "firstThread");
        Thread secondThread = new Thread(new ArrayAggregate(secondHalfArray, half), "secondThread");

        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstHalfArray, 0, array, 0, firstHalfArray.length);
        System.arraycopy(secondHalfArray, 0, array, firstHalfArray.length, secondHalfArray.length);

        long endTime = System.currentTimeMillis();
        System.out.println("Метод 2 закончил работу. Время: " + (endTime - startTime));
        return array;
    }
}
