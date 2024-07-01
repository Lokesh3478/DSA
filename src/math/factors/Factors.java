package math.factors;

import java.util.Arrays;

public class Factors {
    
    // Method to calculate the square root of a number 'n' with a specified precision 'precise'
    public static double squareRoot(int n, int precise) {
        double root = 1;
        int start = 1; 
        int end = n / 2;
        
        // Binary search for integer part of the square root
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        // Adjusting the root to the closest integer result of the binary search
        root = start - 1;
        
        // Refining the root to the desired precision
        double incr = 0.1f;
        for (int i = 1; i < precise; i++) {
            while (root * root < n) {
                root += incr;
            }
            // Once we overshoot, we need to step back
            root -= incr;
            incr /= 10;
        }
        
        return root;
    }
    
    // Method to check if a number 'n' is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        
        int c = 2;
        // Checking for factors up to the square root of 'n'
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        
        return true;
    }
    
    // Method to generate a boolean array indicating prime numbers up to 'n'
    public static boolean[] primeRange(int n) {
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        arr[0] = false; // 1 is not a prime number
        
        // Sieve of Eratosthenes algorithm
        for (int i = 2; i * i <= n; i++) {
            if (arr[i - 1]) {
                for (int j = i * 2; j <= n; j += i) {
                    arr[j - 1] = false;
                }
            }
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " " + isPrime(i));
        }
        
        boolean getPrime[] = primeRange(40);
        for (int i = 1; i <= 40; i++) {
            if (getPrime[i - 1]) {
                System.out.println(i);
            }
        }
        
        for (int i = 1; i <= 100; i++) {
            System.out.printf("Square root of %d is %.3f\n", i, squareRoot(i, 3));
        }
    }
}
