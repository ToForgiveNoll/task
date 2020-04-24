package Alan;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        System.out.println("请输入一个秒数");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int s = a / 3600;
        int f = a % 3600 / 60;
        int m = a % 60;
        System.out.println(s + "时" + f + "分" + m + "秒");
    }
}
