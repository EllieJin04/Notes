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

    public static void countArrElement() {
        System.out.println("Please enter integers between 0 and 9 (enter -1 to end): ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        // Array 'count' stores the frequency of occurrence for each integer (0 to 9)
        int[] count = new int[10];

        // Read integers until -1 is entered, update count array accordingly
        while (num != -1) {
            if (num >= 0 && num <= 9) {
                count[num]++;
            }
            num = scanner.nextInt();
        }

        // Display the occurrence count for each integer
        for (int i = 0; i < count.length; i++) {
            System.out.println("The integer " + i + " occurs " + count[i] + " times.");
        }
    }

    public static void main(String[] args) {
        /*double average = avg();
        System.out.println("The average is: " + average);*/

        int[] a = {1, 2, 3, 4, 5};
        // 'a' and 'b' both refer to the same array in memory, which means
        // any changes made to 'a' or 'b' will affect the same array
        int[] b = a;
        System.out.println(a == b); // true

        countArrElement();
    }
}
