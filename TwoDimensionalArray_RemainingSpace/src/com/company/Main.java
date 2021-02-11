package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int n = arr.length;
//        System.out.println("Original Array:");
//        for(int i = 0; i < n; i++){
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
        System.out.println("Maximum water that can be accumulated is " + maxWater(arr, n));
    }

    public static int maxWater(int[] arr, int n){
        //left[i] contains height of tallest bar to the left of the i'th bar including itself
        int[] left = new int[n];
        //right[i] contains height of tallest bar to the right of i'th bar including itself
        int[] right = new int[n];
        //initialize result
        int water = 0;
        //fill the left array
        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }
//        System.out.println("Left Array:");
//        for(int i = 0; i < n; i++){
//            System.out.print(left[i] + " ");
//        }
//        System.out.println();
        //fil the right array
        right[n-1] = arr[n-1];
        for(int i = n - 2;  i >= 0; i--){
            right [i] = Math.max(right[i+1], arr[i]);
        }
//        System.out.println("Right Array:");
//        for(int i = 0; i < n; i++){
//            System.out.print(right[i] + " ");
//        }
//        System.out.println();
        //Calculate the accumulated water element by element. Consider the amount of water on i'th bar, the
        //amount of water accumulated on this particular bar will be equal to min(left[i], right[i]) - arr[i]
        for(int i = 0; i < n; i++){
            water += Math.min(left[i], right[i]) - arr[i];
//            System.out.print(water + " ");
        }
//        System.out.println();
        return water;
    }
}
