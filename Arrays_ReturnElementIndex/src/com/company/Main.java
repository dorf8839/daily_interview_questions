package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Binary Search
//        int[] my_array = {1,2,3,4,5,6,7};
        int[] my_array = {7,2,5,3,4,1,6};
        //Find the index of 5
        System.out.println("Index position of 5 is: " + findIndex(my_array, 5));
        //Find the index of 7
        System.out.println("Index position of 7 is: " + findIndex(my_array, 7));
        //Linear Search
//        List<Integer> input = new ArrayList<>();
//        input.add(13);
//        input.add(18);
//        input.add(25);
//        input.add(2);
//        input.add(8);
//        input.add(10);
////        int k = 8;
//        int k = 7;
//        int index = input.indexOf(k);
//        System.out.println("The index of element " + k + " is " + (index>-1 ? index : "NULL"));
    }

    public static int findIndex(int[] arr, int t){
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
}
