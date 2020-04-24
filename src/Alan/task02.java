package Alan;

import java.util.Arrays;

public class task02 {

    public static void main(String[] args) {

//        for (int i = 0; i <= 1000; i++) {
//
//            int sum = 0;
//            int factor = 0;
//
//            while (sum < i) {
//
//                if ((sum += ++factor) == i) {
//                    System.out.println(i);
//                }
//            }
//        }
//        以上是我理解错误 我以为完数是 1+2+3这种自然数的和等于本身..


        for (int i = 1; i < 1000; i++) { // 遍历0-1000

            int sum = 0;

            for (int i1 = 1; i1 < i; i1++) { // 遍历所有因数

                if (i % i1 == 0) {

                    sum += i1;
                }
            }

            if (sum == i)
                System.out.println(sum);
        }

    }
}
