package Alan;

import java.util.Scanner;

public class task01 {

    public static void main(String[] args) {

        int year, month, day, result = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用拉钩万年历 0.1.0 Bata版 \n当前版本您可以输入年月日来查询日期属于该年的第多少天\n");

        while (true) { // 循环询问直到获取正确值

            try { // 在用户输出非数字时做出提醒

                System.out.print("请输入年份(int)：");
                year = scanner.nextInt();
                if (year < 1) { // 判断年份是否合法

                    System.out.println("请输入合法年份");
                    continue;
                }
                break;
            } catch (Exception e) {

                System.out.println("您输入的不是一个数字!\n");
                scanner = new Scanner(System.in);
            }

        }

        while (true) { // 循环询问直到获取正确值

            try { // 在用户输出非数字时做出提醒

                System.out.print("请输入月份(int)：");
                month = scanner.nextInt();
                if (month < 1 || month > 12) {// 判断月份是否合法

                    System.out.println("请输入合法月份");
                    continue;
                }
                break;
            } catch (Exception e) {

                System.out.println("您输入的不是一个数字!\n");
                scanner = new Scanner(System.in);
            }

        }

        while (true) { // 循环询问直到获取正确值

            try { // 在用户输出非数字时做出提醒

                System.out.print("请输入日期(int)：");
                day = scanner.nextInt();
                if (month < 8) {// 判断日期是否合法

                    if (month != 2) { // 判断是否是2月

                        if (month % 2 == 0) { // 判断大小月

                            if (day > 30) {

                                System.out.println("请输入合法日期");
                                continue;
                            }
                        } else {

                            if (day > 31) {

                                System.out.println("请输入合法日期");
                                continue;
                            }
                        }

                    } else {

                        if (year % 4 == 0 && year % 400 != 0) {// 判断是否闰年

                            if (day > 29) {

                                System.out.println("请输入合法日期");
                                continue;
                            }
                        } else {

                            if (day > 28) {

                                System.out.println("请输入合法日期");
                                continue;
                            }
                        }
                    }
                } else {

                    if (month % 2 == 0) { // 判断大小月

                        if (day > 31) {

                            System.out.println("请输入合法日期");
                            continue;
                        }
                    } else {

                        if (day > 30) {

                            System.out.println("请输入合法日期");
                            continue;
                        }
                    }
                }
                break;
            } catch (Exception e) {

                System.out.println("您输入的不是一个数字!\n");
                scanner = new Scanner(System.in);
            }
        }

        if (month < 2) { // 判断是否可以直接得出答案

            result = day;
        } else {

            for (int i = 1; i <= month - 1; i++) { // 循环判断天数 减去当前未满的月数

                if (i < 8) {// 八月以下单数为大月

                    if (i % 2 == 0) { // 判断月份单双

                        result += 30;
                    } else {

                        result += 31;
                    }
                } else {

                    if (i % 2 == 0) { // 判断月份单双

                        result += 31;
                    } else {

                        result += 30;
                    }
                }
            }

            if (month > 2) { // 判断是否大于二月 如果大于 补正2月天数

                if (year % 4 == 0 && year % 400 != 0) {// 判断是否闰年

                    result -= 1;
                } else {

                    result -= 2;
                }
            }

            result += day; // 加上日期
        }

        System.out.println("这一天是" + year + "年的第" + result + "天\n");
        System.out.println("感谢使用拉钩万年历 如果有任何问题 请联系微信：wxid_b31s7xk4uze722");// 小朋友 你是否有很多问号?
    }
}
