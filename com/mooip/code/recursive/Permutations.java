package com.mooip.code.recursive;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private static int count = 0;  //how many times the recursion call is made
    private static int permutationsCount = 0;
    
    public Permutations() {
    }
    
    public <E> List<List<E>> generateListPerms(List<E> original) {
      if (original.isEmpty()) {
        List<List<E>> result = new ArrayList();
        result.add(new ArrayList());
        return result;
      }
      E firstElement = original.remove(0);
      List<List<E>> returnValue = new ArrayList();
      List<List<E>> permutations = generateListPerms(original);
      for (List<E> smallerPermutated : permutations) {
        for (int index = 0; index <= smallerPermutated.size(); index++) {
          List<E> temp = new ArrayList(smallerPermutated);
          temp.add(index, firstElement);
          returnValue.add(temp);
        }
      }
      return returnValue;
    }
 
    public static void permutationString(String str) { 
        permutationString("", str); 
        System.out.println("permutationsCount: " + permutationsCount);
    }

    //TODO: this needs to be refactored to allow permutation count to be added.
    private static void permutationString(String prefix, String str) {
        count++;
        int n = str.length();
        if (n == 0) {
            permutationsCount++;
            if (permutationsCount == 1000000) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < n; i++)
                permutationString(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }    

    public static void main(String[] args) {
        List<List<Integer>> permLists; 
        
        List<Integer> digits = new ArrayList<Integer>();
        digits.add(8);
        digits.add(7);
        digits.add(1);
        
        Permutations perm = new Permutations();   
        permLists = perm.generateListPerms(digits);
        
        permutationString("abcd");
        System.out.println("permutation string count: " + count);
        
        System.out.println(permLists);
    }    
}