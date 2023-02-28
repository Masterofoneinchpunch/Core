package com.mooip.code.recursive;

import com.mooip.util.MathUtil;
import java.util.Set;
import java.util.TreeSet;

public final class PermutationNumberPrimes {
    private final boolean[] used;
    private final StringBuilder out = new StringBuilder();
    private final String in;
    private int count = 0;
    private int permutationCount = 0;
    private final Set<Integer> setPerms = new TreeSet<Integer>();
    
    public PermutationNumberPrimes(final Integer num) {
        in = String.valueOf(num);
        used = new boolean[in.length()];
    }
    
    public void permute() {
        count++;
        if (out.length() == in.length()) {
            Integer num = Integer.valueOf(out.toString());
            if (MathUtil.isPrime(num) && num > Integer.valueOf(in)) {
                permutationCount++;
                setPerms.add(num);
            }
            
            return;
        }
        
        for (int i = 0; i < in.length(); i++) {
            if (used[i]) {
                continue;
            }
            out.append(in.charAt(i));
            used[i] = true;
            permute();
            used[i] = false;
            out.setLength(out.length() - 1);
        }
    }

    public Set<Integer> getSetPerms() {
        return this.setPerms;
    }

    /**
     * Static factory method to get larger permutations of the passed in string.
     * 
     * @param num The number to get the permutations from;
     * @return perms A list of larger Permutations.
     */
    public static Set<Integer> getLargerPermutationNumbers(Integer num) {
        PermutationNumberPrimes permNums = new PermutationNumberPrimes(num);
        permNums.permute();
        
        return permNums.getSetPerms();
    }
    
    public static void main(String[] args) {
        PermutationNumberPrimes permNums = new PermutationNumberPrimes(1487);
        permNums.permute();
        
        System.out.println("amount of iterations: " + permNums.count);
        System.out.println("amount of permutations: " + permNums.permutationCount);
        System.out.println(permNums.setPerms);
        
        for (Integer permNum : permNums.setPerms) {
            System.out.println(permNum);
        }
    } 
}

