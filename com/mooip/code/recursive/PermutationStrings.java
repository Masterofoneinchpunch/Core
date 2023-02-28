package com.mooip.code.recursive;

import java.util.ArrayList;
import java.util.List;

public final class PermutationStrings {
    private final boolean[] used;
    private final StringBuilder out = new StringBuilder();
    private final String in;
    private int count = 0;
    private int permutationCount = 0;
    private final List<String> perms = new ArrayList<String>();
    
    public PermutationStrings(final String str) {
        in = str;
        used = new boolean[in.length()];
    }
    
    public void permute() {
        count++;
        if (out.length() == in.length()) {
            permutationCount++;
            perms.add(out.toString());
            
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

    public List<String> getPerms() {
        return this.perms;
    }

    /**
     * Static factory method to get permutation of the passed in string.
     * 
     * @param str The string to get the permutations from;
     * @return perms A list of String Permutations.
     */
    public static List<String> getPermutationStrings(String str) {
        PermutationStrings perm = new PermutationStrings(str);
        perm.permute();
        
        return perm.getPerms();
    }
    
    public static void main(String[] args) {
        PermutationStrings perm = new PermutationStrings("987654321");
        perm.permute();
        
        System.out.println("amount of iterations: " + perm.count);
        System.out.println("amount of permutations: " + perm.permutationCount);
    } 
}

