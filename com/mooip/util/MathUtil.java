package com.mooip.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class MathUtil {
    
    private MathUtil() {
    }

    public static long factorial(int n) {
        if ((n > 1)) {
            return factorial(n-1) * n; /* Recursive case */
        } else {
            return 1; /* Base case */
        }
    }

    public static BigInteger factorialBig(int number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }    
    
    public static BigInteger combinatoric(int n, int r) {
        BigInteger bi = factorialBig(n);
        BigInteger denom = factorialBig(r);
        BigInteger denom2 = factorialBig(n - r);
        denom = denom.multiply(denom2);
        
        return bi.divide(denom);
    }
    
    /**
     * Is this a prime? 
     * 
     * @param n The long value passed in.
     * @return boolean A true if a prime, a false if not.
     */
    public static boolean isPrime(long n) {
        //negative numbers cannot be prime
        if (n < 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if ((n % 2 == 0)) { 
            return false;
        }
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if ((n % i == 0)) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> getPrimes(int maxValue) {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 3; i <= maxValue; i += 2) {
            if (MathUtil.isPrime((long)i)) {
                primes.add(i);
            }
        }
        
        return primes;
    }

    // currently start value has to be odd
    public static Set<Integer> getPrimes(int startValue, int maxValue) {
        Set<Integer> primes = new TreeSet<Integer>();
        for (int i = startValue; i <= maxValue; i += 2) {
            if (MathUtil.isPrime((long)i)) {
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    
    public static long addStringDigits(String number) {
        if (number == null) {
            throw new NullPointerException("The parameter number in addString method should not be null!");
        }
        if (number.matches("\\d+") == false) {
            throw new IllegalArgumentException(number + " is not a number.");
        }
        
        char[] numbers = number.toCharArray();
        long result = 0;
        
        for (char charNum : numbers) {
            int num = Character.digit(charNum, 10);
            result += num;
        }
        
        return result;
    }

    public static long addFactorialDigits(String number) {
        if (number == null) {
            throw new NullPointerException("The parameter number in addString method should not be null!");
        }
        if (number.matches("\\d+") == false) {
            throw new IllegalArgumentException(number + " is not a number.");
        }
        
        char[] numbers = number.toCharArray();
        long result = 0;
        
        for (char charNum : numbers) {
            long num = factorial(Character.digit(charNum, 10));
            result += num;
        }
        
        return result;
    }
    
    public static BigInteger getFactorial(short fact) {
        BigInteger bi = new BigInteger("1");
        
        for (int i = 2; i <= fact; i++) {
            bi = bi.multiply(new BigInteger(Integer.toString(i)));
        }
        
        return bi;
    }

    
    /**
     * Gets the number of divisors.  Uses prime factorization.
     * 
     * @param number The number you are using to get the amount of divisors.
     * @return totalFactors The total amount of factors.
     * @see nice solution here: https://bit.ly/3m42S2G
     * @see explanation here: https://bit.ly/3Sqc913
     */
    public static int numOfDivisors(long number) {
        long x = 2;
        int totalFactors = 1;
        while ((x*x) <= number) {
            int power = 0;
            while (number % x == 0) {
                power++;
                number /= x;
            }
            totalFactors *= (power + 1);
            x += 1;
        }
        
        if (number != 1) {
            totalFactors *= 2;
        }
        return totalFactors;
    }
    
    public static int sumProperDivisors(final long number) {
        // the number always has its own number as a divisor
        int sumProperDivisors = 0;
        
        for (long i = number / 2; i > 0; i--) {
            if (number % i == 0) {
                sumProperDivisors += i;
            }
        }
        
        return sumProperDivisors;
    }

    public static int listSum(List<Integer> list) {
         int sum = 0; 

         for (int i : list) {
             sum = sum + i;
         }

         return sum;
    }    

    public static int getNthDigit(int number, int n) {    
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }    

    public static int getNthDigit(long number, int n) {    
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }    

    public static boolean isCoprime(int a, int b) {
        return (gcd(a,b) == 1);
    }
    
    //Euclid's algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }    

    //Totient (aka phi) Function: https://bit.ly/3R2sbh5 
    public static int getRelativePrimesCount(int n) {
        int totient = n; //this will be the totient at the end of the sample
        for (int p = 2; p*p <= n; p++) {
            if (n % p == 0) {
                totient /= p;
                totient *= (p - 1);
                while (n % p == 0) {
                    n /= p;
                }
            }
        }
        if (n > 1) { // n is the largest prime divisor
            totient /= n;
            totient *= (n - 1);
        }
        
        return totient;
    }

    public static boolean isRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }
    
    public static int gcdBigInt(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        
        return gcd.intValue();
    }

    public static boolean sameDigits(int n1, int n2) {
        String firstValue = String.valueOf(n1);
        String nextValue = String.valueOf(n2);
        if (firstValue.length() != nextValue.length()) {
            return false;
        }

        char[] arr = firstValue.toCharArray();
        Arrays.sort(arr);
        char[] arr2 = nextValue.toCharArray();
        Arrays.sort(arr2);

        return Arrays.equals(arr, arr2);
    }
    
    public static Integer addAll(List<Integer> list) {
        int total = 0;
        for (Integer num : list) {
            total += num;
        }
        return total;
    }

    public static int addAll(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    public static int minArray(int[] arr) {
        int min = arr[0] ;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int[] getConsecutiveSubset(int maxValue) {
        int[] subsets = new int[maxValue - 1];
      
        for (int i = 0; i < subsets.length; i++) {
            subsets[i] = i+1;
        }
        
        return subsets;
    }
        
    // formula Hn=n(2n−1)
    public static int hexagonalNumber(int i) {
        return (int) i * (2*i - 1);
    }
    
    // formula Pn=n(3n−1)/2
    public static int pentagonalNumber(int i) {
        return i * (3 * i - 1) / 2;
    }

    // formula tn = ½n(n+1)
    public static int triangleNumber(int i) {
        return (int) ((i + 1) * ((double)i/2));
    }
    
    // formula n(5n−3)/2
    public static int heptagonalNumber(int i) {
        return i * (5 * i - 3) / 2;
    }
    
    // formula n(3n−2)
    public static int octagonalNumber(int i) {
        return i * (3 * i - 2);
    }
}
