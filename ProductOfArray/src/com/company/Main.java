package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter your list of integers, separated by a space");
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] productArray = new int[input.length];
        for(int i = 0; i < input.length; i++){
            int product = 1;
            for(int j = 0; j < input.length; j++){
                if(j != i){
                    product *= input[j];
                }
            }
            productArray[i] = product;
        }
        for(int i = 0; i < productArray.length; i++){
            System.out.print(productArray[i] + " ");
        }
    }
}
