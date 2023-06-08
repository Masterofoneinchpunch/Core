package com.mooip.code.recursive;

import java.util.ArrayList;
import java.util.List;

public final class PermutationsRepetition {
    private static int count = 0;  //how many times the recursion call is made
    private static int permutationsCount = 0;
    private final List<String> perms = new ArrayList<String>();
    
    public PermutationsRepetition() {
    }

    public List<String> getPerms() {
        return this.perms;
    }
    
    public void permutationString(String str, int size) { 
        permutationString("", str, size); 
        //System.out.println("permutationsCount: " + permutationsCount);
    }

    //TODO: this needs to be refactored to allow permutation count to be added.
    private void permutationString(String prefix, String str, int size) {
        count++;
        int n = str.length();
        if (prefix.length() == size) {
            permutationsCount++;
            perms.add(prefix);
            //System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutationString(prefix + str.charAt(i), str, size);
        }
    }    

    /**
     * Static factory method to get permutation of the passed in string.
     * 
     * @param str The string to get the permutations from;
     * @param size The size of the string.
     * @return perms A list of String Permutations.
     */
    public static List<String> getPermutationStrings(String str, int size) {
        PermutationsRepetition perm = new PermutationsRepetition();
        perm.permutationString(str, size);
                
        return perm.getPerms();
    }
    
    public static void main(String[] args) {
        PermutationsRepetition pr = new PermutationsRepetition();
        pr.permutationString("X/+-", 3);
        System.out.println("size: " + pr.getPerms().size());
        System.out.println("permutation string count: " + count);        
    }    
}
