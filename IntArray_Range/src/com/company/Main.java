package com.company;

public class Main {

    public static void main(String[] args) {
//	    int[] input = {9,11,8,5,7,10};
	    int[] input = {10};
	    int profit = maxRange(input);
	    if(profit == -1){
            System.out.println("Not enough values were provided to determine your profit");
        }else {
            System.out.println("Your highest profit is $" + maxRange(input));
        }
    }

    private static int maxRange(int[] input){
        if(input.length <= 1){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < input.length; i++){
            for(int j = i; j < input.length; j++){
                if(input[j] - input[i] > max){
                    max = input[j] - input[i];
                }
            }
        }
        return max;
    }
}
