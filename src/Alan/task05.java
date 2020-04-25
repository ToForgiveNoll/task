package Alan;

import java.util.Arrays;

public class task05 {

    public static void main(String[] args) {

        String[][] num = new String[17][17];

        for (int i = 0; i < 17; i++) {

            for (int j = 0; j < 17; j++) {

                if (i == 0 && j == 0) {

                    num[i][j] = " ";
                } else if (i == 0 && j > 10) {
                    num[i][j] = ((char) (j - 1 + 87)) + ""; // 转化ASCII码中的小写字母
                } else if (i == 0) {
                    num[i][j] = j - 1 + "";
                } else if (j == 0 && i > 10) {
                    num[i][j] = ((char) (i - 1 + 87)) + "";
                } else if (j == 0) {
                    num[i][j] = i - 1 + "";
                } else {
                    num[i][j] = "+";
                }

            }
        }

        for (int i = 0; i < 17; i++) {

            for (int j = 0; j < 17; j++) {

                System.out.print(num[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
