package Alan.Stage1Module1;

public class task05 {

    public static void main(String[] args) {

        String[][] num = new String[17][17];

        for (int i = 0; i < 17; i++) { // 输出竖排

            for (int j = 0; j < 17; j++) { // 输出横排

                if (i == 0 && j == 0) { // 输出一个空格

                    num[i][j] = " ";
                } else if (i == 0 && j > 10) { // 输出横排字母部分

                    num[i][j] = ((char) (j - 1 + 87)) + ""; // 转化ASCII码中的小写字母
                } else if (i == 0) { // 输出横排数字部分

                    num[i][j] = j - 1 + "";
                } else if (j == 0 && i > 10) { // 输出竖排字母部分

                    num[i][j] = ((char) (i - 1 + 87)) + ""; // 转化ASCII码中的小写字母
                } else if (j == 0) { // 输出竖排数字部分

                    num[i][j] = i - 1 + "";
                } else { // 输出剩下的+号

                    num[i][j] = "+";
                }

            }
        }

        for (int i = 0; i < 17; i++) { // 循环遍历输出二维数组

            for (int j = 0; j < 17; j++) {

                System.out.print(num[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
