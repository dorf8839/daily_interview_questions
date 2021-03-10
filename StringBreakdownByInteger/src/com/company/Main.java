package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//	    String input = "The quick brown fox jumps over the lazy dog";
	    String input = "The quick brown fox jumpsupanddownoverand over the lazy dog";
	    int k = 10;
	    stringBreakdown(input, k);
    }

    public static void stringBreakdown(String input, int k){
        String[] inputArr = input.split(" ");
        ArrayList<String> outputArr = new ArrayList<>();
        String currOutput = "";
        int currLength = 0;
        for(int i = 0; i < inputArr.length; i++){
            if(inputArr[i].length() > k){
                System.out.println("NULL");
                return;
            }else {
                if (currLength == 0) {
                    currOutput = inputArr[i];
                    currLength = inputArr[i].length();
                } else {
                    if (inputArr[i].length() + 1 + currLength <= k) {
                        currOutput = currOutput + " " + inputArr[i];
                        currLength += inputArr[i].length() + 1;
                    } else {
                        outputArr.add(currOutput);
                        currOutput = "";
                        currLength = 0;
                        i--;
                    }
                }
            }
        }
        if(currLength > 0){
            outputArr.add(currOutput);
        }
        System.out.println(outputArr.toString());
    }
}
