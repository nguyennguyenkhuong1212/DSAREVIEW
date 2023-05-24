package w5;

import java.util.Random;

public class p1 {
    public static int[] generateRandomIntArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return array;
    }
}
