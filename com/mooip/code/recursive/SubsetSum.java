package com.mooip.code.recursive;

import java.math.BigInteger;

//nice video here: https://www.youtube.com/watch?v=SXeQumnNjAI 
public class SubsetSum {
    
    private final int[] subsets;
    private final int sum;
    
    public SubsetSum(int[] subsets, int sum) {
        this.subsets = subsets;
        this.sum = sum;
    }

    public int runSubsets() {
        return subsetsRecursion(subsets.length, sum);
    }

    private int subsetsRecursion(int subset, int amountLeft) {
        // means we have an exact amount
        if (amountLeft == 0) {
            return 1;
        }
        // means we have less or we have run out of subsets
        if (amountLeft < 0 || (subset <= 0)) {
            return 0;
        }
        
        return subsetsRecursion(subset - 1, amountLeft) + subsetsRecursion(subset, amountLeft - subsets[subset - 1]);
    }
    
    /**
     * Subsets Recursion factory method. This will be slower than the dynamic
     * programming (non-recursive below).  But this gives an example of how to 
     * solve this issue with recursion.  AKA the Coin Change program.
     * 
     * @param subsets The subsets in array form.
     * @param subset The specific subset to use.
     * @param amountLeft How much you have left (if change, how much change).
     * @return amountOfWay The amount of ways to be found.
     */
    public static int subsetsRecursion(int[] subsets, int subset, int amountLeft) {
        // means we have an exact amount
        if (amountLeft == 0) {
            return 1;
        }
        // means we have less or we have run out of subsets
        if (amountLeft < 0 || (subset <= 0)) {
            return 0;
        }
        
        return subsetsRecursion(subsets, subset - 1, amountLeft) + subsetsRecursion(subsets, subset, amountLeft - subsets[subset - 1]);
    }

    //// DP solution... O(n^2) or O(n log n) complexity
    // Do this by referencing the solution for the sub problem and adding it on.
    public static int subsetsNonRecursion(int[] subsets, final int sum) {
        int[] ways = new int[sum + 1];
        ways[0] = 1;

        for(int subset: subsets)
            for(int j = subset; j <= sum; j++)
                ways[j] += ways[j - subset];

        return ways[sum];
    }

    //// DP solution... O(n^2) or O(n log n) complexity
    // Do this by referencing the solution for the sub problem and adding it on.
    public static long subsetsNonRecursionLong(int[] subsets, final int sum) {
        long[] ways = new long[sum + 1];
        ways[0] = 1;

        for(int subset: subsets)
            for(int j = subset; j <= sum; j++)
                ways[j] += ways[j - subset];

        return ways[sum];
    }

    //// DP solution... O(n^2) or O(n log n) complexity
    // Do this by referencing the solution for the sub problem and adding it on.
    public static BigInteger subsetsNonRecursionBD(int[] subsets, final int sum) {
        BigInteger[] ways = new BigInteger[sum + 1];
        
        ways[0] = new BigInteger(Integer.toString(1));
        //System.out.println("ways: " + ways[0]);
        for(int subset: subsets) {
            for(int j = subset; j <= sum; j++) {
                //System.out.println("this gets called: j " + j + " subset: " + subset);
                if (ways[j] == null) {
                    //System.out.println("create new ways");
                    ways[j] = new BigInteger("0");
                }
                ways[j] = ways[j].add(ways[j - subset]);
                //System.out.println(ways[j]);
                //ways[j] += ways[j - subset];
            }
        }
        
        return ways[sum];
    }
    
    public static void main(String[] args) {
        final int total = 200;        
        final int[] coins = {1,2,5,10,20,50,100,200};
        
        System.out.println("Using static call:");
        System.out.println(SubsetSum.subsetsRecursion(coins, coins.length, total));
        System.out.println(SubsetSum.subsetsNonRecursion(coins, total));
        
        System.out.println("Using instance call:");
        SubsetSum ss = new SubsetSum(coins, total);
        System.out.println("total: " + ss.runSubsets());
        
        final int newTotal = 5;
        final int[] newCoins = {1,2,5};
        SubsetSum ss2 = new SubsetSum(newCoins, newTotal);
        System.out.println("total: " + ss2.runSubsets());  
        
        int[] test = {1,2,3,4,5,6};
        System.out.println(SubsetSum.subsetsRecursion(test, test.length, 7));
        System.out.println(SubsetSum.subsetsNonRecursion(test, 7));
        
        
    } 
}


