package Alan.Stage1Module1;

import java.util.Arrays;
import java.util.Random;

public class task03 {

    public static void main(String[] args) {

        int[] number = new int[7];

        Random random = new Random();
        for (int i = 0; i < 6; i++) { // 循环创建随机数

            number[i] = random.nextInt(33) + 1;
            for (int j = 0; j < i; j++) { // 判断是否重复

                if (number[i] == number[j]) { // 如果重复则重新创建 并再次判断
                    number[i] = random.nextInt(33) + 1;
                    j = -1; // 运行完成后j会加1
                }
            }

        }
        number[6] = random.nextInt(16) + 1;
        System.out.println(Arrays.toString(number));
    }
}
