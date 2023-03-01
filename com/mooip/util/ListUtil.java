package com.mooip.util;

import java.util.ArrayList;
import java.util.List;

public final class ListUtil {
    private ListUtil() {
    }

    /**
     * Changes an integer list into an int array.
     * 
     * @param list The Integer list.
     * @return arr The integer array.
     */
    public static int[] toArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
    
    public static List<Integer> toList(int[] arr) {
        List<Integer> newList = new ArrayList<Integer>();
        for (Integer num : arr) {
            newList.add(num);
        }
        
        return newList;
    }
    
    public static <T> List<T> minus(List<T> list1, List<T> list2) {
        List<T> minus = new ArrayList<T>();
        for (T item : list1) {
            if (list2.contains(item) == false) {
                minus.add(item);
            }
        }
        return minus;
    }

    public static Long listToNumber(List<Integer> list) {
        StringBuilder sb = new StringBuilder(list.size());
        for (Integer num : list) {
            sb.append(num);
        }
        
        return Long.valueOf(sb.toString());
    }  
}

