package lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MyArrayDataException, MySizeArrayException {

        String[][] normArray = {
                {"27", "65", "98", "33"},
                {"27", "65", "98", "33"},
                {"27", "65", "98", "33"},
                {"27", "65", "98", "33"}
        };

        String[][] wrongSizeArray = {
                {"27", "65", "98", "33"},
                {"27", "65", "98", "33"},
                {"27", "65", "98", "33"},
                {"27", "65", "98"}
        };

        String[][] wrongDataArray = {
                {"27", "65", "98", "33"},
                {"27", "65", "xx", "33"},
                {"27", "65", "98", "33"},
                {"27", "65", "98", "33"}
        };

        int sum;
        try {
            sum = convertAndSum4x4StringArray(normArray);
        } catch (MySizeArrayException | MyArrayDataException e) {
            sum = 0;
            e.printStackTrace();
        }
        System.out.println("Сумма равна:" + sum);

        try {
            sum = convertAndSum4x4StringArray(wrongSizeArray);
        } catch (MySizeArrayException | MyArrayDataException e) {
            sum = 0;
            e.printStackTrace();
        }
        System.out.println("Сумма равна:" + sum);

        try {
            sum = convertAndSum4x4StringArray(wrongDataArray);
        } catch (MySizeArrayException | MyArrayDataException e) {
            sum = 0;
            e.printStackTrace();
        }
        System.out.println("Сумма равна:" + sum);
    }

    public static int convertAndSum4x4StringArray(String[][] array) throws MySizeArrayException, MyArrayDataException {

        if (array.length != 4) {
            throw new MySizeArrayException("Неправильное количество строк");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MySizeArrayException("Неправильный размер строки " + i);
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }
}
