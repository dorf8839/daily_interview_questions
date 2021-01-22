package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{5,5,10,100,10,5};
        System.out.println(FindMaxSum(arr));
    }

    //Function to return max sum such that no two elements are adjacent
    public static int FindMaxSum(int[] arr){
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int n = arr.length;

        for(int i = 1; i < n; i++){
            //Current max excluding i
            excl_new = (incl > excl) ? incl : excl;

            //Current max including i
            incl = excl + arr[i];
            excl = excl_new;
        }
        //Return max of incl and excl
        return ((incl > excl) ? incl : excl);
    }
}
