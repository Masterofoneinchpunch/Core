package com.mooip.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public final class MathUtil {   
    private MathUtil() {
    }

    /**
     * Recursive solution for factorial.  Only use for small n.
     * @param n The number to factorial.
     * @return factorial The factorial number of the number passed in.
     */
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
    
    /**
     * Gets the combinatoric value with the given n and r.
     * 
     * @param n The number of things that we have to choose from.
     * @param r The number that represents the number of things that we choose from 'n'.
     * @return The amount of ways of selecting r from n.
     * @see <a href="https://en.wikipedia.org/wiki/Combinatorics">Combinatorics</a>
     */
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

    /**
     * Gets the primes up until the maximum value;
     * 
     * @param maxValue The maximum value.
     * @return primes A List of primes.
     */
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
    /**
     * Gets the primes up until the maximum value from the start value;
     * 
     * @param startValue The starting value (has to be odd).
     * @param maxValue The maximum value.
     * @return primes A List of primes.
     */
    public static Set<Integer> getPrimes(int startValue, int maxValue) {
        Set<Integer> primes = new TreeSet<Integer>();
        for (int i = startValue; i <= maxValue; i += 2) {
            if (MathUtil.isPrime((long)i)) {
                primes.add(i);
            }
        }
        
        return primes;
    }
       
    /**
     * Add each digit of the passed in string.
     * 
     * @param number The passed in string (should be a number).
     * @return sum The summation of the passed in string.
     * @throws NullPointerException if the parameter is null.
     * @throws IllegalArgumentException if the passed in string is not a number.
     */
    public static long addStringDigits(String number) {
        if (number == null) {
            throw new NullPointerException("The parameter number in addStringDigits method should not be null!");
        }
        if (number.matches("\\d+") == false) {
            throw new IllegalArgumentException(number + " is not a number.");
        }
        
        final char[] numbers = number.toCharArray();
        long sum = 0;
        
        for (char charNum : numbers) {
            final int num = Character.digit(charNum, 10);
            sum += num;
        }
        
        return sum;
    }

    public static long addFactorialDigits(String number) {
        if (number == null) {
            throw new NullPointerException("The parameter number in addFactorialDigits method should not be null!");
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
    
    /**
     * Add in each digit squared from the passed in number.   
     * 
     * @param number The number.
     * @return sum The sum of all the digits squared.
     */
    public static long addSquareDigits(long number) {
        long sum = 0;
        while (number > 0) {
            long digit = number % 10;
            sum += (digit * digit);
            
            number = number / 10;
        }
        
        return sum;
    }

    /**
     * Add in each digit from the passed in number.  This is much faster than addStringDigits. 
     * 
     * @param number The number.
     * @return sum The sum of all the digits.
     */
    public static long addDigits(long number) {
        long sum = 0;
        while (number > 0) {
            long digit = number % 10;
            sum = sum + digit;
            
            number = number / 10;
        }
        
        return sum;
    }
    
    /**
     * Gets the factorial of the passed in value.
     * 
     * @param number The number you are going to return a factorial of.
     * @return factorial The factorial of the passed in number.
     */
    public static BigInteger getFactorial(short number) {
        BigInteger factorial = new BigInteger("1");
        
        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
        }
        
        return factorial;
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
    
    /**
     * Sum of the proper divisors.
     * 
     * @param number The passed in number
     * @return sumProperDivisors The sum of the proper divisors.
     * @see https://www.geeksforgeeks.org/sum-of-all-proper-divisors-of-a-natural-number/ 
     */
    public static int sumProperDivisors(final int number) {
        int sumProperDivisors = 0;
       
        if (number == 1) {
            return sumProperDivisors; // no proper divisor
        }
        
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {            
            if (number % i == 0) {
                // if both divisors are same add it only once else add both
                if (i == (number / i)) {
                    sumProperDivisors += i;
                } else { 
                    sumProperDivisors += (i + number / i);
                }
            }
        }
 
        return (sumProperDivisors + 1);
    }
     
    public static int listSum(List<Integer> list) {
         int sum = 0; 

         for (int i : list) {
             sum = sum + i;
         }

         return sum;
    }    

    public static int setSum(Set<Integer> set) {
         int sum = 0; 

         for (int i : set) {
             sum = sum + i;
         }

         return sum;
    }
    
    /**
     * Gets the nth digit for the passed in number.  This is quite quick.
     * 
     * @param number The number you are looking through.
     * @param n the digit (2nd digit of 2345 from right would be 4)
     * @return nth The nth digit.
     */
    public static int getNthDigit(int number, int n) {    
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }    

    /**
     * Gets the nth digit for the passed in number.  This is quite quick.
     * 
     * @param number The number you are looking through.
     * @param n the digit (2nd digit of 2345 from right would be 4)
     * @return nth The nth digit.
     */
    public static int getNthDigit(long number, int n) {    
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }    

    public static boolean isCoprime(int a, int b) {
        return (gcd(a,b) == 1);
    }
    
    /**
     * Checks these two values to see if they will be part of a Pythagorean Triple.
     * 
     * @param a side a.
     * @param b side b.
     * @return a true if these two could form a Pythagorean Triple, a false if not.
     */
    public static boolean isPythagoreanTriple(int a, int b) {
        return (Math.sqrt(a * a + b * b) % 1 == 0);
    }
    
    /**
     * Greatest Common Denominator using Euclid's algorithm.
     * 
     * @param a The first variable.
     * @param b The second variable.
     * @return gcd The Greatest Common Denominator.
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }    

    /**
     * Gets the relative primes count.  This is the Totient (aka Phi) Function. 
     * @param n The number to check.
     * @return totient The relative primes for the passed in number.
     * @see https://bit.ly/3R2sbh5
     */
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

    /**
     * Does the two passed in numbers have the same digits?
     * 
     * @param n1 Number one.
     * @param n2 Number two.
     * @return boolean A true if the numbers have the same digits; false if otherwise.
     */
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

    /**
     * Square Root Algorithm to find square root digits from Frazer Jarvis found on Wiki page.
     * 
     * @param n The number to square root.
     * @param digits The amount of digits you need to return.
     * @return BigInteger A BigInteger with the amount of square root digits you want.
     * @see https://web.archive.org/web/20220410042055/http://www.afjarvis.staff.shef.ac.uk/maths/jarvisspec02.pdf
     * @see https://github.com/dcrousso/ProjectEuler/blob/master/PE080.java 
     */
    public static BigInteger squareRootDigits(final int n, int digits) {
        int sqrInt = (int) Math.sqrt(n);
        if (sqrInt * sqrInt == n) {
            return new BigInteger(Integer.toString(n));
        }
        
        final BigInteger FIVE = BigInteger.valueOf(5);
        final BigInteger ONE_HUNDRED = BigInteger.valueOf(100);
        
        BigInteger a = BigInteger.valueOf(n * 5);
        BigInteger b = FIVE;
        while (b.compareTo(BigInteger.TEN.pow(digits + 1)) < 0) {
            if (a.compareTo(b) >= 0) {
                a = a.subtract(b);
                b = b.add(BigInteger.TEN);
            } else {
                a = a.multiply(ONE_HUNDRED);
                b = b.divide(BigInteger.TEN).multiply(ONE_HUNDRED).add(FIVE);                                        
            }
        }

        return b.divide(ONE_HUNDRED);
    }

    /**
     * The sum of a sequence.  For example if 5 is passed in (5 + 4 + 3 + 2 + 1)
     * will be returned. 
     * 
     * @param n The number you want to sum a sequence of.
     * @return sum The sum of the sequence of the number passed in.
     */
    public static int sumSequence(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Expecting a value 0 or above");
        }
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    // formula Hn=n(2n−1)
    public static int hexagonalNumber(int i) {
        return (int) i * (2*i - 1);
    }
    
    /**
     * Returns a pentagonal number given the sequence.
     * Formula is Pn=n(3n−1)/2.
     * 
     * @param i The sequence number.
     * @return pentNum The pentagonal number given the sequence.
     * @see <a href="https://bit.ly/41AQt6m">Pentagonal Number definition</a>
     */
    public static int pentagonalNumber(int i) {
        return i * (3 * i - 1) / 2;
    }

    /**
     * Returns a triangle number given the sequence.
     * Formula is tn = ½n(n+1).
     * 
     * @param i The sequence number.
     * @return triNum The triangle number given the sequence.
     * @see <a href="https://bit.ly/3EJn5Bc">Triangle Number definition</a>
     */
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
    
    /**
     * Evaluates a string with the JavaScript parser.  This can be a bit slow if used over and over. 
     * 
     * @param evalStr The string to be evaluated.
     * @return 
     * @todo check the string to make sure bad values are not pushed in.  This is a security hazard.
     */
    public static Double evaluate(String evalStr) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Double result;
        try {
            result = (Double) engine.eval(evalStr);
        } catch (ScriptException se) {
            throw new RuntimeException("parameter " + evalStr + " did not parse correctly.");
        }
        
        return result;
    }
    
    /**
     * Math Parser for string.
     * 
     * @param str The String passed in to be evaluated.
     * @return parsedValue The string parsed and given back as a value.
     * @see  <a href="https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form">Awesome code example</a>
     */
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }       

    public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
}
