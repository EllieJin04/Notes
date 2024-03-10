package javabasics;

public class IsPrime {

    // Brute force/enumeration
    // time: O(n)
    public static boolean isPrime1(int num) {
        if (num <= 1) return false; // boundary condition
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // sqrt(num), but the speed of sqrt() is slow
    // time: O(sqrt(n))
    public static boolean isPrime2(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // i * i <= num, but i * i easily overflow
    // time: O(sqrt(n))
    public static boolean isPrime3(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // i <= num / i
    // time: O(sqrt(n))
    public static boolean isPrime4(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
