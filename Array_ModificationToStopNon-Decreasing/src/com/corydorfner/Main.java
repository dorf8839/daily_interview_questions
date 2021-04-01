package com.corydorfner;

public class Main {

    public static void main(String[] args) {
//        int[] input = {10,5,7};
//        int[] input = {10,5,1};
//        int[] input = {1};
        int[] input = {};
        System.out.println(modNonDecrease(input));
    }

    public static boolean modNonDecrease(int[] input){
        int count = 0;
        if(input.length <= 1){
            return true;
        }
        for(int i = 1; i < input.length; i++){
            if(input[i] < input[i-1]){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}
