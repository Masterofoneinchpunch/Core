package com.mooip.code.iterative;

import com.mooip.util.MathUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * SubArrays. This is O(n2) algorithm.
 * 
 * @author masterofoneinchpunch
 */
public final class Subarrays {
    public Subarrays() {        
    }

    /**
     * Greatest sum for subarrays. 
     * 
     * @param ints A List of Integers.
     * @return greatestSum The greatest sum.
     */
    public static int greatestSum(List<Integer> ints) {
        Integer greatestSum = null;
        
        for (int i = 0; i < ints.size(); i++) {
            for (int j = i; j < ints.size(); j++) {
                List<Integer> subArray = ints.subList(i, j + 1);
                System.out.println(subArray);
                final int listSum = MathUtil.listSum(subArray);
                if (greatestSum == null || listSum > greatestSum) {
                    greatestSum = listSum;
                }
            }
        }
        return greatestSum;
    }
    
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(5);
        arr.add(1);
        arr.add(-1);
        
        System.out.println(Subarrays.greatestSum(arr));
    }
}

/*
    public static List<Integer> maxSubarray(List<Integer> arr) {
        List<Integer> results = new ArrayList<Integer>();
    
        results.add(greatestSum(arr));
    
        final int max = Collections.max(arr);       
        if (max < 0) {
            results.add(max);
        } else {
            int sumSubSequence = 0;
            for (Integer value : arr) {
                if (value >= 0) {
                    sumSubSequence += value;
                }
            }       
            results.add(sumSubSequence);
        }
        
    
        return results;
    }

    public static int greatestSum(List<Integer> a) {
        Integer greatestSum = null;
        
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
            for (int j = i; j < a.size(); j++) {
                List<Integer> subArray = a.subList(i, j + 1);
                System.out.println(subArray);
                final int listSum = listSum(subArray);
                if (greatestSum == null || listSum > greatestSum) {
                    greatestSum = listSum;
                }
            }
        }
        return greatestSum;
    }

    public static int listSum(List<Integer> list) {
         int sum = 0; 

         for (int i : list) {
             sum = sum + i;
         }

         return sum;
    }    

    public static List<Integer> maxSubarray(List<Integer> arr) {
        List<Integer> results = new ArrayList<Integer>();    
        Integer greatestSum = null;
        
        int sumSubSequence = 0;
        for (int i = 0; i < arr.size(); i++) {
            Integer value = arr.get(i);
            if (value > 0) {
                sumSubSequence += value;
            }
            
            //System.out.println(value);
            int subArraySum = 0;
            for (int j = i; j < arr.size(); j++) {
                subArraySum += arr.get(j);
                List<Integer> subArray = arr.subList(i, j + 1);
                System.out.println(subArray + " " + subArraySum);
                final int listSum = listSum(subArray);
                if (greatestSum == null || listSum > greatestSum) {
                    greatestSum = listSum;
                }
            }
        }
        results.add(greatestSum);
        
        if (sumSubSequence > 0) {
            results.add(sumSubSequence);
        } else {
            results.add(Collections.max(arr));
        }    
    
        return results;
    }

    public static int listSum(List<Integer> list) {
         int sum = 0; 

         for (int i : list) {
             sum = sum + i;
         }

         return sum;
    }    

    public static List<Integer> maxSubarray(List<Integer> arr) {
        List<Integer> results = new ArrayList<Integer>();    
        Integer greatestSum = null;
        
        int sumSubSequence = 0;
        for (int i = 0; i < arr.size(); i++) {
            Integer value = arr.get(i);
            if (value > 0) {
                sumSubSequence += value;
            }
            
            int subArraySum = 0;
            for (int j = i; j < arr.size(); j++) {
                subArraySum += arr.get(j);
                if (greatestSum == null || subArraySum > greatestSum) {
                    greatestSum = subArraySum;
                }
            }
        }
        results.add(greatestSum);
        
        if (sumSubSequence > 0) {
            results.add(sumSubSequence);
        } else {
            results.add(Collections.max(arr));
        }    
    
        return results;
    }
*/