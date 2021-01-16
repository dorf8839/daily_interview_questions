package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {3, 4, -1, 1, 2, 7, 6, 5};
        Arrays.sort(intArray);
        int min = 1;
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] > 0){
                if(intArray[i] == min){
                    min++;
                }else{
                    break;
                }
            }
        }
        System.out.println("The lowest positive non-existent integer is " + min);
    }
}
