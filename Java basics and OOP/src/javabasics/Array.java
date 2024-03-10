package javabasics;

import java.util.Scanner;

public class Array {
    /**
        return the average value of user's input and print all numbers that are greater than the average
     * @return the average value of user's input
     */
    public static double avg() {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int count;
        do {
            System.out.println("Please enter the count of numbers you'd like to provide: ");
            count = scanner.nextInt();
        } while (count <= 0); // count has to be positive
        double[] nums = new double[count];

        // receive user input into int[] nums and calculate the sum of the input
        System.out.println("Please enter " + count + " numbers: ");
        for (int i = 0; i < nums.length; i++) {
            double num = scanner.nextDouble();
            nums[i] = num;
            sum += num;
        }

        // print all numbers that are greater than avg
        double avg = sum / count;
        for (int i = 0; i < count; i++) {
            if (nums[i] > avg) {
                System.out.print(nums[i] + " ");
            }
        }
        System.out.println();
        return avg;
    }

    public static void main(String[] args) {
        double average = avg();
        System.out.println("The average is: " + average);

        int[] a = {1, 2, 3, 4, 5};
        // 'a' and 'b' both refer to the same array in memory, which means
        // any changes made to 'a' or 'b' will affect the same array
        int[] b = a;
        System.out.println(a == b); // true

    }
}
