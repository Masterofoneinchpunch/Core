package com.mooip.code.iterative;

import java.util.ArrayList;
import java.util.List;

/**
 * Substrings. This is an Example of basic iterative algorithm to get all substrings 
 * (sometimes asked in interviews).  This is O(n2) algorithm.
 * 
 * @author masterofoneinchpunch
 */
public final class Substrings {
    public Substrings() {        
    }
    
    /**
     * Gets all the substring given the passed in string.  
     * 
     * @param str The passed in String.
     * @return subStrings A list of all substrings.
     */
    public List<String> getAllSubstrings(final String str) {
        List<String> subStrings = new ArrayList();
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); ++j) {
                subStrings.add(str.substring(i, j));
            }          
        }
        
        return subStrings;
    }
    
    public static void main(String[] args) {
        final String subString = "abttcd";
        Substrings subSt = new Substrings();
        
        System.out.println("initial string: " + subString);
        System.out.println(subSt.getAllSubstrings(subString));
    }
}
