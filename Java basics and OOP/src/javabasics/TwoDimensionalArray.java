package javabasics;

public class TwoDimensionalArray {
    public static int tictactoe(int[][] arr) {
        int res = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            flag = true;
            res = arr[i][0];
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] != arr[i][j + 1]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            return res;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1},
                {0, 1, 0},
                {0, 1, 0}
        };
        System.out.println((tictactoe(arr) == 1 ? "X" : "O")+ " wins!");
    }
}
