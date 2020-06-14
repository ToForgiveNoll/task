package Alan.Stage1Module1;

import java.util.Arrays;
import java.util.Scanner;

public class task04 {

    public static void main(String[] args) {

        int[] number1 = new int[10];
        int[] number2 = null;
        int num = 0; // 记录已存在数值的多少

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("请输入一个数:");
            number1[num] = scanner.nextInt();
            if (num + 1 >= (int) (number1.length * 0.8)) { // 如果大于80%则扩容

                number2 = number1;
                number1 = new int[(int) (number1.length * 1.5)];

                for (int i = 0; i < number2.length; i++) { // 马甲数组循环赋值给原数组
                    number1[i] = number2[i];
                }

                System.out.println("已扩容1.5倍 现在的容量为" + number1.length);
            }
            num++;
        }
    }
}
