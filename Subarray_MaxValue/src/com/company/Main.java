package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    int[] intArray = new int[]{10,5,2,7,8,7};
	    int k = 3;
	    int max;
        ArrayList<Integer> subArray = new ArrayList<>();
	    for(int i = 0; i < intArray.length; i++){
	        if(subArray.size() < k){
	            subArray.add(intArray[i]);
            }else if(subArray.size() == k){
	            max = Integer.MIN_VALUE;
                for(int j = 0; j < subArray.size(); j++){
                    if(subArray.get(j) > max){
                        max = subArray.get(j);
                    }
                }
                System.out.println("Max value of subarray " + subArray.toString() + " is " + max);
                subArray.remove(0);
                subArray.add(intArray[i]);
            }
        }
        max = Integer.MIN_VALUE;
        for(int j = 0; j < subArray.size(); j++){
            if(subArray.get(j) > max){
                max = subArray.get(j);
            }
        }
        System.out.println("Max value of subarray " + subArray.toString() + " is " + max);
    }
}
