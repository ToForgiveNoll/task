package Alan;

import java.util.Arrays;

public class task05 {

    public static void main(String[] args) {

        String[][] num = new String[16][16];

        for (int i = 0; i < 16; i++) {

            for (int j = 0; j < 16; j++) {

                if (i == 0 && j == 0) {
                    num[i][j] = " ";
                } else if (i == 0 && j > 9) {
                    num[i][j] = ((char) (j + 87)) + ""; // 转化ASCII码中的小写字母
                } else if (i == 0) {
                    num[i][j] = j + "";
                } else if (j == 0 && i > 9) {
                    num[i][j] = ((char) (i + 87)) + "";
                } else if (j == 0) {
                    num[i][j] = i + "";
                } else {
                    num[i][j] = "+";
                }

            }
        }

        for (int i = 0; i < 16; i++) {

            for (int j = 0; j < 16; j++) {

                System.out.print(num[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
