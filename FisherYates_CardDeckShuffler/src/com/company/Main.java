package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {1,2,3,4,5,6,7,8};
	    int n = arr.length;
	    randomize(arr, n);
    }

    //Function to generate a random permutation of arr[]
    static void randomize(int[] arr, int n){
        //Creating an object for Random class
        Random r = new Random();

        //Start from the last element and swap one by one.  We don't
        //need to run for the first element
        for(int i = n-1; i > 0; i--){
            //Pick a random index from 0 to i
            int j = r.nextInt(i+1);
            //Swap arr[i] with the element at random index
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //Prints the random array
        System.out.println(Arrays.toString(arr));
    }
}
