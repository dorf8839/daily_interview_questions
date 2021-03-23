package com.corydorfner;

//Given a list of integers, return the largest product that can be made by
//multiplying any three integers.  For example, if the list is [-10, -10, 5, 2],
//we should return 500, since that's -10 * -10 * 5.
//You can assume the list has at least three integers.

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] list = {-10, -10, 5, 2};
        System.out.println(largestProduct(list));
    }

    //Greedy
    public static int largestProduct(int[] list){
        Arrays.sort(list);
        int n = list.length;
        return Math.max((list[0] * list[1] * list[n-1]), (list[n-3] * list[n-2] * list[n-1]));
    }
//    //Brute Force
//    public static int largestProduct(int[] list){
//        int max = Integer.MIN_VALUE;
//
//        for(int i = 0; i < list.length-2; i++){
//            for(int j = i + 1; j < list.length-1; j++){
//                for(int k = j + 1; k < list.length; k++){
//                    if((list[i] * list[j] * list[k]) > max){
//                        max = list[i] * list[j] * list[k];
//                    }
//                }
//            }
//        }
//        return max;
//    }
}
