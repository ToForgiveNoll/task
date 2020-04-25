package Alan;

import java.util.Arrays;
import java.util.Random;

public class task03 {

    public static void main(String[] args) {

        int[] number = new int[7];

        Random random = new Random();
        for (int i = 0; i < 6; i++) {

            number[i] = random.nextInt(33) + 1;
        }
        number[6] = random.nextInt(16) + 1;
        System.out.println(Arrays.toString(number));
    }
}
