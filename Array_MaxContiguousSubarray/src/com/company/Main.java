package com.company;

public class Main {

    public static void main(String[] args) {
//	    int[] input = {34,-50,42,14,-5,86};
	    int[] input = {-5,-1,-8,-9};
        System.out.println("Maximum contiguous sum is " + maxSum(input));
    }

    public static int maxSum(int[] input){
        int size = input.length;
        int currMax = 0;
        int newMax = 0;

        for(int i = 0; i < size; i++){
            newMax = newMax + input[i];
            if(newMax < 0){
                newMax = 0;
            }else if(currMax < newMax){
                currMax = newMax;
            }
        }
        return currMax;
    }
}
