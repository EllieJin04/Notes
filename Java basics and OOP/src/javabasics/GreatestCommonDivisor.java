package javabasics;

public class GreatestCommonDivisor {
    // brute force
    // time: O(Math.min(n, m))
    public static int gcd1(int n, int m) {
        int gcd = 1;
        for (int i = 2; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // Euclidean algorithm
    // time: O(logn)
    public static int gcd2(int n, int m) {
        while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }
}
