package javabasics;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieve {
    /*
        generate a List of primes strictly less than n
        Similar to LeetCode 204 Count Primes
     */
    public static List<Integer> primes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] notPrime = new boolean[n + 1];

        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                primes.add(i);
                for (int j = 2; i * j <= n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return primes;
    }

    /*
        204 Count Primes
        Given an integer n, return the number of prime numbers that are strictly less than n.
        time: O(sqrt(n)log(logn) + n)
     */
    public static int countPrimes(int n) {
        if(n <= 1) return 0;

        boolean[] notPrime = new boolean[n];

        for(int i = 2; i * i < n; i++){
            if(!notPrime[i]){
                for(int j = 2; i * j < n; j++){
                    notPrime[i * j] = true;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < notPrime.length; i++){
            if(!notPrime[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> primes = primes(101);
        for(int prime : primes) {
            System.out.println(prime);
        }

        System.out.println(countPrimes(10));
    }
}
