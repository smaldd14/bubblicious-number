package com.hooswhere.bubbliciousnumber.util;

public final class BubbliciousUtil {
    /**
     * Most optimized algorithm because by observing that all primes
     * are of the form 6k ± 1, with the exception of 2 and 3.
     * This is because all integers can be expressed as (6k + i)
     * for some integer k and for i = -1, 0, 1, 2, 3, or 4.
     * So, a more efficient method is to test if n is divisible by 2 or 3,
     * then to check through all the numbers of form 6k ± 1 ≤ √n.
     * This approach is 3 times faster than testing all numbers up to √n.
     * Taken from https://www.geeksforgeeks.org/java-prime-number-program/
     * @param n
     * @return
     */
    public static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i < Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public static boolean hexEndsInB(int number) {
        // convert to hexadecimal
        String hex = Integer.toHexString(number);
        // check if last character is B
        return hex.charAt(hex.length() - 1) == 'b' || hex.charAt(hex.length() - 1) == 'B';
    }

    /**
     * Given a number, filter out all non-prime numbers up to and including that number
     */
    public static int[] filterNonPrimes(int number) {
        int[] nonPrimes = new int[number];
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (!isPrime(i)) {
                nonPrimes[count] = i;
                count++;
            }
        }
        return nonPrimes;
    }
}
