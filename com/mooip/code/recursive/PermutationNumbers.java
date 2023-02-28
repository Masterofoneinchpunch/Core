package com.mooip.code.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Specifically used for permutations of number.  This is useful when you want permutations
 * of numbers 1 through 9 (single digit permutations); it is not useful when you 
 * want permutations above 9.
 * 
 * @author masterofoneinchpunch
 */
public final class PermutationNumbers {
    private final boolean[] used;
    private final StringBuilder out = new StringBuilder();
    private final String in;
    private int count = 0;
    private int permutationCount = 0;
    private final List<Integer> perms = new ArrayList<Integer>();
    
    public PermutationNumbers(final String str) {
        in = str;
        used = new boolean[in.length()];
    }

    public PermutationNumbers(final Integer num) {
        in = String.valueOf(num);
        used = new boolean[in.length()];
    }
    
    public void permute() {
        count++;
        if (out.length() == in.length()) {
            permutationCount++;
            perms.add(Integer.valueOf(out.toString()));
            
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

    public List<Integer> getPerms() {
        return this.perms;
    }

    /**
     * Static factory method to get permutation of numbers.
     * 
     * @param num The number to get the permutations from;
     * @return perms A list of Permutations.
     */
    public static List<Integer> getPermutationNumbers(Integer num) {
        PermutationNumbers permNums = new PermutationNumbers(num);
        permNums.permute();
        
        return permNums.getPerms();
    }
    
    /**
     * Static factory method to get permutation of numbers.
     * 
     * @param num The number to get the permutations from;
     * @return perms A list of Permutations.
     */
    public static List<Integer> getPermutationNumbers(String num) {
        PermutationNumbers permNums = new PermutationNumbers(num);
        permNums.permute();
        
        return permNums.getPerms();
    }
    
    public static void main(String[] args) {
        PermutationNumbers permNums = new PermutationNumbers("012345");
        permNums.permute();
        
        System.out.println("amount of iterations: " + permNums.count);
        System.out.println("amount of permutations: " + permNums.permutationCount);
        
        System.out.println(PermutationNumbers.getPermutationNumbers("123"));
    } 
}

